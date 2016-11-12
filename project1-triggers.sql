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
