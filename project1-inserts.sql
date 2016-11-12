insert into Customer values ('00100', 'Mr', 'Gerard', 'Butler', '1111111111111111', to_date('JAN-2020', 'MON-YYYY'), '123 Sweet Dr', 'Pittsburgh', 'PA', '1234567890', 'gbutler@gmail.com', '00000');
insert into Customer values ('00101', 'Mrs', 'Sophia', 'Butler', '1111111111111112', to_date('JAN-2020', 'MON-YYYY'), '123 Sweet Dr', 'Pittsburgh', 'PA', '1234567891', 'sbutler@gmail.com', '00000');
insert into Customer values ('00102', 'Mr', 'Corny', 'Names', '1111111111111113', to_date('NOV-2020', 'MON-YYYY'), '678 Ohara Rd', 'Pittsburgh', 'PA', '1234567892', 'cornNames@gmail.com', '00001');
insert into Customer values ('00103', 'Mrs', 'Funny', 'Names', '1111111111111114', to_date('NOV-2020', 'MON-YYYY'), '678 Ohara Rd', 'Pittsburgh', 'PA', '1234567893', 'funNames@gmail.com', '00001');
insert into Customer values ('00104', 'Mr', 'Noh', 'Waife', '1111111111111115', to_date('MAR-2020', 'MON-YYYY'), '987 Mckee Pl', 'Pittsburgh', 'PA', '1234567894', 'noWife@gmail.com', '00002');

insert into Airline values ('00000', 'Alaska Airlines', 'AKA', 1932);
insert into Airline values ('00001', 'United Airlines', 'UAL', 1931);
insert into Airline values ('00002', 'All Nippon Airways', 'ANA', 1952);
insert into Airline values ('00003', 'Delta Air Lines', 'DAL', 1924);
insert into Airline values ('00004', 'Jet Blue', 'JBA', 1998);
insert into Airline values ('00005', 'American Airlines', 'AAL', 1930);
insert into Airline values ('00006', 'Frontier Airlines', 'FAL', 1994);
insert into Airline values ('00007', 'Southwest Airlines', 'SWA', 1967);
insert into Airline values ('00008', 'Virgin Airlines', 'VAL', 1984);
insert into Airline values ('00009', 'Spirit Airlines', 'SAL', 1980);

insert into Plane values('B747', 'Boeing', 200, to_date('09/09/2009', 'MM/DD/YYYY'), 1996, '00001');
insert into Plane values('A320', 'Airbus', 155, to_date('10/01/2011', 'MM/DD/YYYY'), 2001, '00002');
insert into Plane values('E145', 'Emraer', 50, to_date('06/15/2010', 'MM/DD/YYYY'), 2008, '00003');
insert into Plane values('B737', 'Boeing', 125, to_date('02/04/2007', 'MM/DD/YYYY'), 2002, '00004');
insert into Plane values('A330', 'Airbus', 175, to_date('10/10/2008', 'MM/DD/YYYY'), 2000, '00005');

insert into Reservation values('00000', '00100', 200, '1111111111111111', to_date('01-JAN-2015 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 'N');
insert into Reservation values('00001', '00101', 150, '1111111111111112', to_date('08-JAN-2015 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 'N');
insert into Reservation values('00002', '00102', 75, '1111111111111113', to_date('22-JAN-2015 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 'Y');
insert into Reservation values('00003', '00103', 175, '1111111111111114', to_date('25-JAN-2015 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 'N');
insert into Reservation values('00004', '00104', 200, '1111111111111115', to_date('17-JAN-2015 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 'Y');

insert into Flight values ('000', '00004', 'B747', 'PIT', 'JFK', '1000', '1120', 'SMTWTFS');
insert into Flight values ('001', '00003', 'A320', 'JFK', 'PIT', '1120', '1240', 'SMTWTFS');
insert into Flight values ('002', '00002', 'E145', 'DCA', 'PIT', '1430', '1530', 'SMTWTFS');
insert into Flight values ('003', '00001', 'B373', 'PIT', 'DCA', '1530', '1630', 'SMTWTFS');
insert into Flight values ('004', '00000', 'A320', 'ALK', 'PIT', '0900', '2200', '-----F-');

insert into Reservation_detail values('00001', '00101', to_date('13-Feb-2015 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 1);
insert into Reservation_detail values('00000', '00100', to_date('13-Feb-2015 07:00:00', 'DD-MON-YYYY HH24:MI:SS'), 1);
insert into Reservation_detail values('00002', '00102', to_date('13-Feb-2015 08:30:00', 'DD-MON-YYYY HH24:MI:SS'), 1);
insert into Reservation_detail values('00003', '00103', to_date('13-Feb-2015 07:30:00', 'DD-MON-YYYY HH24:MI:SS'), 1);
insert into Reservation_detail values('00004', '00104', to_date('10-Feb-2015 10:00:00', 'DD-MON-YYYY HH24:MI:SS'), 1);
