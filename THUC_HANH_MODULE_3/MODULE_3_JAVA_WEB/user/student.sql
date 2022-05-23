CREATE USER 'hoankim'@'*' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON `database`.* TO 'hoankim'@'*';

use `database`;

create table student (
id varchar(10) primary key,
name varchar(50),
birthday date,
sex bit
);

select * from `database`.student;
insert into student values ('ms1', N'An', '26/07/1994', 1);
insert into student values ('ms2', N'Thanh', '23/04/1999', 0);
insert into student values ('ms3', N'Hoang', '05/09/1996', 0);
