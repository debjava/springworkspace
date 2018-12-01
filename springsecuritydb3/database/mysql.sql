/*Drop Table if exists*/
drop table IF EXISTS appusers ;

/*Create the table appusers*/
create table appusers
(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	username varchar(30),
	password varchar(50),
	enabled BOOL,
	accountNonExpired BOOL,
	credentialsNonExpired BOOL,
	accountNonLocked BOOL,
	authority varchar(50),
	UNIQUE (username)
);

/*Insert the data into the table appusers*/

insert into appusers(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authority) 
values('deb','deb',true,true,true,true,'ROLE_USER');
commit;

insert into appusers(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authority) 
values('deb1','deb1',true,true,true,true,'ROLE_WH_USER');
commit;

insert into appusers(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authority) 
values('deb3','deb3',true,true,true,true,'ROLE_ADMIN');
commit;

/*Check the data*/
select * from appusers;