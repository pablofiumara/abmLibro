CREATE DATABASE ABMLibros1;

USE ABMLibros1;

CREATE TABLE Libros
(
  id INT NOT NULL IDENTITY(1,1) PRIMARY KEY,
  Titulo varchar(255) null,    
) 
 
 CREATE TABLE user_roles
 (
   USER_ROLE_ID int not null,
   USER_ID int not null,
   AUTHORITY varchar(255) not null,
   primary key (USER_ROLE_ID)
 )


 CREATE TABLE users
 (
   USER_ID int not null,
   USERNAME varchar(255) not null,
   PASSWORD varchar(255) not null,
   ENABLED int not null,
   primary key (USER_ID)
 )

 ALTER TABLE user_roles
	ADD CONSTRAINT USER_ROLES_USERS_FK
	foreign key (USER_ID)
	references users


INSERT INTO users (USER_ID, USERNAME,PASSWORD, ENABLED) VALUES (1, 'pablo', 'pass', 1);
INSERT INTO user_roles (USER_ROLE_ID, USER_ID,AUTHORITY) VALUES (1, 1, 'ROLE_USER');