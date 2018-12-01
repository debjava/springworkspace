create table person
(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	FIRSTNAME VARCHAR(26),
	LASTNAME VARCHAR(26)
);

create table ShoppingCart
(
	id int primary key AUTO_INCREMENT,
	name varchar(50),
	noOfItems int
);

create table Account
(
	id int primary key AUTO_INCREMENT,
	name varchar(50),
	actNo varchar(50)
);

create table Product
(
	id int primary key AUTO_INCREMENT,
	name varchar(50),
	status varchar(50)
);

/*Delete the tables*/
delete from person;
delete from ShoppingCart;
delete from Account;
delete from Product;
COMMIT;

/*All select queries*/
select * from person;
select * from ShoppingCart;
select * from Account;
select * from Product;