-- -----------------------------
-- Heroku database
-- Estudo do Java JDBC
-- author: Rodrigo Andrade
-- date: 01-15-2022
-- -----------------------------
create table if not exists public.department (
	id serial,
	name VARCHAR(25) not NULL,
	
	PRIMARY KEY(id)
);


create table if not exists public.seller (
	id serial,
	name varchar(60) not null,
	email varchar(60) not null,
	birthDate date not null,
	baseSalary float not null,
	departmentId int not null,	
	primary key (id),
	constraint fk_department_seller
		foreign key (departmentId) 
			references public.department(id)
);


