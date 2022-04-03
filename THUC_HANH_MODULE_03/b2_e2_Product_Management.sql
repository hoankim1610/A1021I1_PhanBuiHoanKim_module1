create database Product_Management;

use Product_Management;

create table Customer (
cID int primary key,
cName varchar (50),
cAge int
);

create table `Order` (
oID int primary key,
cID int,
oDate datetime,
oTotaPrice int,
foreign key (cID) references Customer(cID)
);

create table OrderDeTAIL (
oID int,
pID int,
odQTY int,
foreign key (oID) references `Order` (oID),
foreign key (pID) references Product (pID),
primary key (oID, pID)
);

create table Product (
pID int primary key,
pName varchar (50),
pPrice int
);

select * from customer;
