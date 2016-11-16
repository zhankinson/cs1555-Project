create or replace view completeTickets
as select b.departure_city, b.arrival_city, b.departure_time, b.arrival_time, c.reservation_number, c.leg, d.cost, d.ticketed
from Flight b, Reservation_detail c, Reservation d
where (b.flight_number = c.flight_number)
	AND (c.reservation_number = d.reservation_number);


-- price -> flight (arrival and departure) -> reversation detail -> reservation
create or replace trigger adjustTicket
after update
on Price
for each row
begin
	update Reservation set Cost = case
		when reservation_number = (select reservation_number
																  from completeTickets
																	where :new.departure_city = departure_city
																		AND :new.arrival_city = arrival_city
																		AND ticketed = 'N'
																		AND cast(departure_time as int) < cast(arrival_time as int))
		then :new.high_price
	 	when reservation_number = (select reservation_number
 																  from completeTickets
 																	where :new.departure_city = departure_city
																		AND :new.arrival_city = arrival_city
																		AND ticketed = 'N'
																		AND cast(departure_time as int) > cast(arrival_time as int))
		then :new.low_price
		end
	where reservation_number = (select reservation_number
																from completeTickets
																where :new.departure_city = departure_city
																	AND :new.arrival_city = arrival_city
																	AND ticketed = 'N');
end;
/

create or replace view seatingCheck
as select a.reservation_number, a.flight_number, b.airline_id, b.plane_type, b.departure_time, c.plane_capacity
from Reservation_detail a, Flight b, Plane c
where (a.flight_number = b.flight_number)
	AND (b.plane_type = c.plane_type);

--reservation_detail -> flight_number -> plane
create or replace trigger planeUpgrade
before insert
on Reservation_detail
for each row
begin
	update Flight set plane_type = (select plane_type
									from (select plane_type
											from plane
											where ((select count(flight_number)
													from seatingCheck
													where :new.flight_number = flight_number) <  plane_capacity)
											order by plane_capacity desc)
									where rownum <= 1)
	where flight_number = (select flight_number
							from seatingCheck
							where :new.flight_number = flight_number)
							AND ((select plane_capacity
								  from seatingCheck
								  where :new.flight_number = flight_number)
								  = (select count(flight_number)
									from seatingCheck
									where :new.flight_number = flight_number));
end;
/

create or replace trigger cancelReservation
after insert or update or delete
on Date_info
for each row
begin
	--delete any with no printed tickets within 12 hours
	delete from Reservation res
	where (ticketed = 'N')
	AND (((:new.c_date - (select r.flight_date
						from Reservation_detail r
						where r.reservation_number = res.reservation_number))*24) < 12);
		-- AND (Reservation_number = (select Reservation_number
		-- 					  from seatingCheck
		-- 					  where departure_time between departure_time
		-- 					     AND DATEADD(hh, -12, GETDATE())));
	--update plane type if capacity can be lowered
end;
/

create or replace trigger planeDegrade
after delete
on Reservation_detail
for each row
begin
	update Flight set plane_type = (select plane_type
									from (select plane_type
											from plane
											where ((select count(flight_number)
													from seatingCheck
													where :old.flight_number = flight_number)
													> (select plane_capacity
														from plane
														where plane_capacity < (select count(flight_number)
																				from seatingCheck
																				where :old.flight_number = flight_number)))
											order by plane_capacity asc)
									where rownum <= 1)
	where flight_number = (select flight_number
							from seatingCheck
							where :old.flight_number = flight_number)
							AND ((select plane_capacity
								  from seatingCheck
								  where :old.flight_number = flight_number)
								  = (select count(flight_number)
									from seatingCheck
									where :old.flight_number = flight_number));
end;
/
