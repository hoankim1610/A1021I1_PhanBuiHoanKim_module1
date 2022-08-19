CREATE DATABASE `HangHoa`;

USE HangHoa;

create table PHIEUXUAT (
SoPX int primary key,
NgayXuat datetime
);

create table VATTU (
MaVTU int primary key,
TenVTU varchar(50)
);

create table ChiTietPhieXuat (
DGXuat varchar(50),
SLXuat int,
SoPX INT,
MaVTU int,
primary key (SoPX, MaVTU),
foreign key (SoPX) references PHIEUXUAT (SoPX),
foreign key (MaVTU) references VATTU (MaVTU)
);

create table PHIEUNHAP (
SoPN int primary key,
NgayNhap datetime
);

create table ChiTietPhieuNhap (
DGNhap varchar(50),
SLNhap int,
MaVTU int,
SoPN int,
primary key (MaVTU, SoPN),
foreign key (MaVTU) references VATTU (MaVTU),
foreign key (SoPN) references PHIEUNHAP (SoPN)
);

