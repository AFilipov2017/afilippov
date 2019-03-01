create database the_cars;

\c the_cars;

create table bodywork (
id serial primary key,
name varchar (30)
);

create table engine(
id serial primary key,
name varchar (30)
);

create table transmission(
id serial primary key,
name varchar (30)
);

create table cars(
id serial primary key,
name varchar (30),
bodywork_id int references bodywork(id),
engine_id int references engine(id),
transmission_id int references transmission(id)
);

insert into bodywork (name) values ('W191');
insert into bodywork (name) values ('W124');
insert into bodywork (name) values ('W210');
insert into bodywork (name) values ('W203');
insert into bodywork (name) values ('W250');

insert into engine (name) values ('190E 2.3');
insert into engine (name) values ('E60 AMG 6.3.');
insert into engine (name) values ('С200 CGI');
insert into engine (name) values ('MB851');
insert into engine (name) values ('MB900');

insert into transmission (name) values ('722.9');
insert into transmission  (name) values ('725.0');
insert into transmission  (name) values ('7G-DCT');
insert into transmission  (name) values ('722.4');
insert into transmission  (name) values ('722.8');

insert into cars (name, bodywork_id, engine_id, transmission_id) values ('Bercedes-Menz 190', '1', '2','3');
insert into cars  (name, bodywork_id, engine_id, transmission_id) values ('BMenz 300 GE', '2', '1', '4');
insert into cars  (name, bodywork_id, engine_id, transmission_id) values ('BMenz SLK 32 AMG', '4', '4','1');
insert into cars  (name, bodywork_id, engine_id, transmission_id) values ('BVenz A 160 CDI', '3', '3', '2');

select c.name, b.name, e.name, t.name from cars as c left outer join bodywork as b on c.bodywork_id = b.id 
left outer join engine as e on  c.engine_id = e.id 
left outer join transmission as t on c.transmission_id = t.id;

select b.name from cars as c
right outer join bodywork as b on c.bodywork_id = b.id where c.bodywork_id is null;

select e.name from cars as c
right outer join engine as e on c.engine_id = e.id where c.engine_id is null;

select t.name from cars as c
right outer join transmission as t on c.transmission_id = t.id where c.transmission_id is null;



