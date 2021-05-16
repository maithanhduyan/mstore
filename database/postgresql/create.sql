-- CREATE DATABASE 'mstore';
-- DROP DATABASE mstore;


-- DROP TABLE public.product;

CREATE TABLE public.product (
    id varchar(255) NOT NULL,
    "name" varchar(255) NULL,
    code varchar(255) NULL,
    cost_price int4 NULL,
    sale_price int4 NULL,
    in_stock int4 NULL,
    active int4 NULL,
    created_by varchar(255) NULL,
    updated_by varchar(255) NULL,
    created_date timestamp NULL,
    updated_date timestamp NULL,
    CONSTRAINT product_code_unique UNIQUE (code),
    CONSTRAINT product_name_unique UNIQUE (name),
    CONSTRAINT product_pkey PRIMARY KEY (id)
);


-- DROP TABLE public.users;

CREATE TABLE public.users (
    id varchar(255) NOT NULL,
    "name" varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    email_verified_at timestamp(0) NULL,
    "password" varchar(255) NOT NULL,
    remember_token varchar(100) NULL,
    created_at timestamp(0) NULL,
    updated_at timestamp(0) NULL,
    active int4 NULL,
    created_date timestamp NULL,
    updated_date timestamp NULL,
    username varchar(255) NULL,
    CONSTRAINT users_email_unique UNIQUE (email)
);