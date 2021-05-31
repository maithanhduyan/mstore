-- public.currency definition

-- Drop table

-- DROP TABLE public.currency;

CREATE TABLE public.currency (
	id bigserial NOT NULL,
	code varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	symbol varchar(255) NOT NULL,
	create_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
	update_time timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT currency_pkey PRIMARY KEY (id)
);