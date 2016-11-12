insert into Customer values (100, 'Mr.', 'Gerard', 'Butler', 1111111111111111, to_date('JAN-2020', 'MON-YYYY'), '123 Sweet Dr', 'Pittsburgh', 'PA', '1234567890', 'gbutler@gmail.com', '00000');
insert into Customer values (101, 'Mrs.', 'Sophia', 'Butler', 1111111111111112, to_date('JAN-2020', 'MON-YYYY'), '123 Sweet Dr', 'Pittsburgh', 'PA', '1234567891', 'sbutler@gmail.com', '00000');
insert into Customer values (100, 'Mr.', 'Corny', 'Names', 1111111111111113, to_date('NOV-2020', 'MON-YYYY'), '678 Ohara Rd', 'Pittsburgh', 'PA', '1234567892', 'cornNames@gmail.com', '00001');
insert into Customer values (100, 'Mrs.', 'Funny', 'Names', 1111111111111114, to_date('NOV-2020', 'MON-YYYY'), '678 Ohara Rd', 'Pittsburgh', 'PA', '1234567893', 'funNames@gmail.com', '00001');
insert into Customer values (100, 'Mr.', 'Noh', 'Waife', 1111111111111115, to_date('MAR-2020', 'MON-YYYY'), '987 Mckee Pl', 'Pittsburgh', 'PA', '1234567894', 'noWife@gmail.com', '00002');

insert into Airline values ('00001', 'United Airlines', 'UAL', 1931);
insert into Airline values ('00002', 'All Nippon Airways', 'ANA', 1952);
insert into Airline values ('00003', 'Delta Air Lines', 'DAL', 1924);
insert into Airline values ('00004', 'Jet Blue', 'JBA', 1998);
insert into Airline values ('00005', 'American Airlines', 'AAL', 1930);
insert into Airline values ('00006', 'Frontier Airlines', 'FAL', 1994);
insert into Airline values ('00007', 'Southwest Airlines', 'SWA', 1967);
insert into Airline values ('00008', 'Virgin Airlines', 'VAL', 1984);
insert into Airline values ('00009', 'Spirit Airlines', 'SAL', 1980);
insert into Airline values ('00010', 'Alaska Airlines', 'AKA', 1932);

insert into Plane values('B747', 'Boeing', 200, to_date('09/09/2009', 'MON/DD/YYYY'), 1996, '00001');
insert into Plane values('A320', 'Airbus', 155, to_date('10/01/2011', 'MON/DD/YYYY'), 2001, '00002');
insert into Plane values('E145', 'Emraer', 50, to_date('06/15/2010', 'MON/DD/YYYY'), 2008, '00003');
insert into Plane values('B737', 'Boeing', 125, to_date('02/04/2007', 'MON/DD/YYYY'), 2002, '00004');
insert into Plane values('A320', 'Airbus', 155, to_date('10/10/2008', 'MON/DD/YYYY'), 2000, '00005');