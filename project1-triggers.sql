create or replace view completeTickets 
as select *
from Pricing a, Flight b, Reservation_detail c, Reservation d
where (a.departure_city = b.departure_city AND a.arrival_city = b.arrival_city) 
	AND (b.flight_number = c.flight_number) 
	AND (c.reservation_number = d.reservation_number);


//price -> flight (arrival and departure) -> reversation detail -> reservation
create or replace trigger adjustTicket
after update 
on Price
for each row
begin
	update Reservation set Cost = (Select )
end;