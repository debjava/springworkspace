/*Table creation scripts for Spring Transactions*/
drop table if exists person;

create table person
(
	id int(3),
	firstName varchar(30),
	lastName varchar(30)
);