
/*Drop the required tables*/
drop table IF EXISTS USERROLES  ;
drop table IF EXISTS USERS ;

/*Create the tables*/
CREATE  TABLE USERS 
(
  username VARCHAR(30) NOT NULL ,
  password VARCHAR(30) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username)
);

CREATE TABLE USERROLES 
(
  roleId int(11) NOT NULL AUTO_INCREMENT,
  username varchar(30) NOT NULL,
  role varchar(30) NOT NULL,
  PRIMARY KEY (roleId),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES USERS (username)
);

INSERT INTO USERS VALUES ('deb','123456', true);
INSERT INTO USERS VALUES ('vidya','123456', true);

INSERT INTO USERROLES VALUES (1,'deb', 'ROLE_USER');
INSERT INTO USERROLES VALUES (2,'deb', 'ROLE_ADMIN');
INSERT INTO USERROLES VALUES (3,'vidya', 'ROLE_USER');

commit;

select * from USERROLES;

select * from USERS;