create database vehiclemanagementsystem;
use vehiclemanagementsystem;
create table login(username varchar(20), pwd varchar(20));
insert into login values('admin', '1234567');
create table vehicle(vregno varchar(20), dor date, price float(20), oaddr varchar(30), ophno int(15));
alter table vehicle modify dor varchar(20);
alter table vehicle modify ophno varchar(15);
alter table vehicle add aadhar varchar(20);
