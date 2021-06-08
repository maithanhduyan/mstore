-- CREATE DATABASE 'mstore';
-- DROP DATABASE mstore;


-- public.currency definition

-- Drop table

-- DROP TABLE public.currency;

CREATE TABLE public.currency (
	id varchar(255) NOT NULL,
	code varchar(255) NULL,
	created_date timestamp NULL,
	name varchar(255) NULL,
	symbol varchar(255) NULL,
	updated_date timestamp NULL,
	CONSTRAINT currency_pkey PRIMARY KEY (id)
);

-- public.customer definition

-- Drop table

-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	id varchar(255) NOT NULL,
	active int4 NULL,
	address varchar(255) NULL,
	created_date timestamp NULL,
	email varchar(255) NULL,
	"name" varchar(255) NULL,
	phone varchar(255) NULL,
	updated_date timestamp NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (id)
);

-- public.employee definition

-- Drop table

-- DROP TABLE public.employee;

CREATE TABLE public.employee (
	id varchar(255) NOT NULL,
	created_date timestamp NULL,
	full_name varchar(128) NOT NULL,
	hire_date date NOT NULL,
	"name" varchar(255) NOT NULL,
	updated_date timestamp NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (id)
);

-- public.orderdetail definition

-- Drop table

-- DROP TABLE public.orderdetail;

CREATE TABLE public.orderdetail (
	id varchar(255) NOT NULL,
	amount float8 NOT NULL,
	created_by varchar(255) NULL,
	created_date timestamp NULL,
	price float8 NOT NULL,
	quantity int4 NOT NULL,
	updated_by varchar(255) NULL,
	updated_date timestamp NULL,
	order_id varchar(255) NOT NULL,
	product_id varchar(255) NOT NULL,
	CONSTRAINT orderdetail_pkey PRIMARY KEY (id)
);


-- public.orderdetail foreign keys

ALTER TABLE public.orderdetail ADD CONSTRAINT order_detail_ord_fk FOREIGN KEY (order_id) REFERENCES orders(id);
ALTER TABLE public.orderdetail ADD CONSTRAINT order_detail_prod_fk FOREIGN KEY (product_id) REFERENCES product(id);

-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE public.orders (
	id varchar(255) NOT NULL,
	amount float8 NULL,
	created_by varchar(255) NULL,
	created_date timestamp NULL,
	customer_address varchar(255) NULL,
	customer_email varchar(255) NULL,
	customer_name varchar(255) NULL,
	customer_phone varchar(255) NULL,
	order_date timestamp NULL,
	order_number int4 NULL,
	updated_by varchar(255) NULL,
	updated_date timestamp NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id)
);

-- public.product definition

-- Drop table

-- DROP TABLE public.product;

CREATE TABLE public.product (
	id varchar(255) NOT NULL,
	active int4 NULL,
	code varchar(255) NULL,
	cost_price float8 NULL,
	created_by varchar(255) NULL,
	created_date timestamp NULL,
	description varchar(255) NULL,
	image_url varchar(255) NULL,
	in_stock int4 NULL,
	link_url varchar(255) NULL,
	"name" varchar(255) NULL,
	sale_price float8 NULL,
	updated_by varchar(255) NULL,
	updated_date timestamp NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);

-- public.productcategory definition

-- Drop table

-- DROP TABLE public.productcategory;

CREATE TABLE public.productcategory (
	id varchar(255) NOT NULL,
	active int4 NULL,
	code varchar(255) NULL,
	created_by varchar(255) NULL,
	created_date timestamp NULL,
	description varchar(255) NULL,
	"name" varchar(255) NULL,
	updated_by varchar(255) NULL,
	updated_date timestamp NULL,
	CONSTRAINT productcategory_pkey PRIMARY KEY (id)
);

-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id varchar(255) NOT NULL,
	active int4 NULL,
	created_date timestamp NULL,
	"password" varchar(255) NULL,
	updated_date timestamp NULL,
	username varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);
