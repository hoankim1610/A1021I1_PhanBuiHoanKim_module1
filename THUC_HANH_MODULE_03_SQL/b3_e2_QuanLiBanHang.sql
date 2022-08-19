create database Quanlihanghoa;

use Quanlihanghoa;

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

use Quanlihanghoa;

insert into Customer
value (1, 'Minh Quan', 10),
	(2, 'Ngoc Oanh', 20),
	(3, 'Hong Ha', 50);
select * from customer;