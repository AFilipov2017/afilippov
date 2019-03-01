create database shop;

\c shop;

create table types(id serial primary key, 
name varchar(30)
);

create table product(
id serial primary key, 
name varchar (30), 
type_id int references types(id), 
expired_date timestamp without time zone, 
price int
);

insert into types values (
'1', 'cheese'
);

insert into types values (
'2', 'milk'
);

insert into product values(
'1','Russian','1','2016-02-20','90'
);

insert into product values (
'2', 'kefir', '2','2016-03-05','30'
);

insert into product values (
'3', 'ice cream', '2','2016-04-05','25'
);


insert into product values (
'4', 'Dutch', '1','2016-05-05','100'
);

insert into product values (
'5', 'sour cream', '2','2016-06-05','100'
);

select * from product as p 
inner join types as t on p.type_id = t.id where t.name = 'cheese';

select * from product where name like '%ice cream%';

select * from product where EXTRACT(MONTH FROM expired_date) = EXTRACT(MONTH FROM now())+1;

select  t.name, p.name, p.price from product as p inner join types as t on t.id = p.type_id where p.price = (select max(price) from product);

select t.name, count(*) from product as p 
inner join types as t on p.type_id = t.id where t.name = 'milk' group by t.name;

select * from product as p 
inner join types as t on p.type_id = t.id where t.name in ('cheese', 'milk');

select t.name, count(*) as "count" from product as p 
inner join types as t on p.type_id = t.id group by t.name having count(*) < 3;

select * from product as p 
inner join types as t on p.type_id = t.id;