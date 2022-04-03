drop table if exists users;
drop table if exists addresses;
drop table if exists products;
drop table if exists categories;
drop table if exists orders;
drop table if exists order_products;
drop table if exists roles;


create table categories (
	id integer primary key,
	category_name varchar(50) not null
);

create table roles (
	id integer primary key,
    role_name varchar(10)
);

create table addresses (
	id integer primary key,
	area varchar(100),
	street varchar(100),
	building_num varchar(100),
	floor_num varchar(100)
);

create table users (
	id integer primary key,
	address_id integer,
    role_id integer not null,
    username varchar(50) not null,
	email varchar(254) not null unique,
	pass varchar(150) not null,	
	interests text,
	dob date,
	is_male bit default(1), 
	job varchar(50),
	credit_limit double not null default(1000), 
	foreign key (address_id) references addresses(id),
	foreign key (role_id) references roles(id)
);

create table products(
	id integer primary key,
	product_name text not null,
	product_desc text not null,
    price double not null,
	category_id integer not null,
	stock integer not null,
	img_path text not null,
	foreign key (category_id) references categories(id)
);

create table orders (
	id integer primary key,
	date date not null default(SYSDATE()),
	customer_id integer,
	is_submitted bit default(0),
	total double 
);

 create table order_products (
	order_id integer not null,
	product_id integer not null,
	quantity integer not null,
	primary key(order_id, product_id)
);



