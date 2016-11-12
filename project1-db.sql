-- Name: Zachary Hankinson
-- Username: ZAH15
-- Partner: Tim Kang
-- Team Name: The SCHEMAtics
drop table Airline cascade constraints;
drop table Flight cascade constraints;
drop table Plane cascade constraints;
drop table Price cascade constraints;
drop table Customer cascade constraints;
drop table Reservation cascade constraints;
drop table Reservation_detail cascade constraints;
drop table Date_info cascade constraints;

create table Airline(
  airline_id varchar2(5) not NULL,
  airline_name varchar2(50) not NULL,
  airline_abbreviation varchar2(10),
  year_founded int,
  constraint Airline_PK
    primary key (airline_id)
);

create table Plane(
  plane_type char(4) not NULL,
  manufacture varchar2(10),
  plane_capacity int,
  last_service date,
  year int,
  owner_id varchar2(5),
  constraint Plane_PK
    primary key (plane_type),
  constraint Plane_FK
    foreign key (owner_id) references Airline (airline_id)
);

create table Flight(
  flight_number varchar2(3) not NULL,
  airline_id varchar2(5),
  plane_type char(4),
  departure_city varchar2(3),
  arrival_city varchar2(3),
  departure_time varchar2(3),
  arrival_time varchar2(4),
  weekly_schedule varchar2(7),
  constraint Flight_PK
    primary key (flight_number),
  constraint Flight_FK_Plane
    foreign key (plane_type) references Plane (plane_type),
  constraint Flight_FK_Airline
    foreign key (airline_id) references Airline (airline_id)
);

create table Price(
  departure_city varchar2(3),
  arrival_city varchar2(3),
  airline_id varchar2(5),
  high_price int,
  low_price int,
  constraint Price_PK
    primary key (departure_city, arrival_city),
  constraint Price_FK
    foreign key (airline_id) references Airline (airline_id)
);

create table Customer(
  cid varchar2(9),
  salutation varchar2(3),
  first_name varchar2(30),
  last_name varchar2(30),
  credit_card_num varchar2(16),
  credit_card_expire date,
  street varchar2(30),
  city varchar2(30),
  state varchar2(2),
  phone varchar2(10),
  email varchar2(30),
  frequent_miles varchar2(5),
  constraint Customer_PK
    primary key (cid)
);

create table Reservation(
  reservation_number varchar2(5),
  cid varchar2(9),
  cost int,
  credit_card_num varchar2(16),
  reservation_date date,
  ticketed varchar2(1),
  constraint Reservation_PK
    primary key (reservation_number),
  constraint Reservation_FK
    foreign key (cid) references Customer (cid)
);

create table Reservation_detail(
  reservation_number varchar2(5),
  flight_number varchar2(3),
  flight_date date,
  leg int,
  constraint Reservation_detail_PK
    primary key (reservation_number, leg),
  constraint Reservation_detail_FK_Res
    foreign key (reservation_number) references Reservation (reservation_number),
  constraint Reservation_detail_FK_Flight
    foreign key (flight_number) references Flight (flight_number)
);

create table Date_info(
  c_date date,
  constraint Date_PK
    primary key (c_date)
);

