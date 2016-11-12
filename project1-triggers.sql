create or replace view completeTickets 
as select a.high_price, a.low_price, b.departure_city, b.arrival_city, b.departure_time, b.arrival_time, c.reservation_number, c.leg, d.cost, d.ticketed
from Price a, Flight b, Reservation_detail c, Reservation d
where (a.departure_city = b.departure_city AND a.arrival_city = b.arrival_city) 
	AND (b.flight_number = c.flight_number) 
	AND (c.reservation_number = d.reservation_number);


//price -> flight (arrival and departure) -> reversation detail -> reservation
create or replace trigger adjustTicket
after update 
on Price
for each row
begin
	update Reservation set Cost = :new.high_price where reservation_number = (select c.reservation_number	
																			  from completeTickets	
																			  where )
end;
/