//price -> flight (arrival and departure) -> reversation detail -> reservation
create or replace trigger adjustTicket
after update 
on Price
for each row
begin
	update Reservation set Cost = (Select )
end;