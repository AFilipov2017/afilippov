create table items (
   id serial primary key not null,
   item_id varchar(50) ,
   name varchar (30),
   description varchar (200),
   created_date timestamp,
   comment text
);