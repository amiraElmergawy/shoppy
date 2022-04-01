drop table if exists users;
drop table if exists addresses;
drop table if exists products;
drop table if exists categories;
drop table if exists orders;
drop table if exists order_products;
drop table if exists roles;

create table customers (
	id integer primary key,
    username varchar(50) not null,
	email varchar(254) not null unique,
	pass varchar(150) not null,	
	interests text,
	dob date,
	is_male bit default(1), 
	job varchar(50),
	credit_limit double not null default(1000)
);

create table addresses (
	customer_id integer not null,
	area varchar(100) not null,
	street varchar(100) not null,
	building_num integer not null,
	floor_num integer,
    foreign key (customer_id) references customers(id)
);

create table admins (
	id integer primary key,
    username varchar(50) not null,
	email varchar(254) not null unique,
	pass varchar(150) not null
);

create table products(
	id integer primary key,
	product_name text not null,
	product_desc text not null,
    price double not null,
	category_id integer not null,
	stock integer not null,
	img_path text not null
);

create table orders (
	id integer primary key,
	created_at date not null default(SYSDATE()),
	customer_id  integer not null,
	is_submitted bit default(0),
	total_price double not null,
    foreign key (customer_id) references customers(id)
);

 create table order_products (
	order_id integer not null,
	product_id integer not null,
	quantity integer not null,
	primary key(order_id, product_id),
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
);