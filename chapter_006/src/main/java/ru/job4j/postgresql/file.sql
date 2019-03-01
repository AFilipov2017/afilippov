create database new_db;

\c new_db;

create table role (
id serial primary key,
name varchar(30)
);

create table users (
user_id serial primary key,
name varchar(30),
role_id int references role(id)  
);

create table category (
id serial primary key,
name varchar(30)
);

create table state (
id serial primary key,
status varchar(30)
);

create table item (
id serial primary key,
name varchar(30),
foreign key(id) references users(user_id),
category_id int references category(id),
state_id int references state(id)
);

create table rules (
id serial primary key,
rul_editor boolean 
);

create table regulation (
id serial primary key,
id_role int references role(id), 
id_rules int references rules(id)
);

create table comments (
id serial primary key,
comm text,
item_id int references item(id)
);

create table attach (
id serial primary key,
files text,
id_item int references item(id)
);

insert into role values(
'1','admin'
);

insert into users values(
'1','Alex', '1'
);

insert into category values(
'1','spare parts'
);

insert into state values(
'1','waiting for payment'
);

insert into item values(
'1','gear','1','1'
);

insert into rules values(
'1','true'
);

insert into regulation values(
'1','1', '1'
);

insert into comments values(
'1','Lorem ipsum', '1'
);

insert into attach values(
'1','c:/file.sql', '1'
);