create table if not exists bank(
id serial primary key ,
bank_name varchar(30));

create table if not exists person(
id serial primary key ,
first_name varchar(40) ,
last_name varchar (40) ,
username varchar(255) not null unique ,
password varchar(255) not null ,
address varchar(255) ,
birth_date DATE ,
nationalCode int unique ,
phone int);

create table if not exists branch(
id serial primary key ,
id_bank int ,
id_boss int unique ,
address varchar(255),
phone int ,
constraint fk_idPerson foreign key (id_boss) references person(id) ,
constraint fk_idBank foreign key (id_bank) references bank(id)
);

create table if not exists employee(
id serial primary key ,
employeeType varchar(255) default 'grade1',
id_person int unique ,
constraint fk_idPerson foreign key (id_person) references person(id)
);

create table if not exists client(
id serial primary key ,
id_person int unique ,
constraint fk_idPerson foreign key (id_person) references person(id)
);

create table if not exists account(
id serial primary key ,
id_client int ,
account_type varchar(255) ,
balance float default '5000.0',
constraint fk_idClient foreign key (id_client) references client(id)
);

create table if not exists creditCard(
id serial primary key ,
id_account int unique ,
card_number varchar(20) unique ,
password int ,
ccv2 int ,
start_date Date ,
expired_date Date ,
constraint fk_idAccount foreign key (id_account) references account(id)
);

create table if not exists transact(
id serial primary key ,
id_account_from int ,
id_account_to int ,
transaction_date Date,
amount float ,
status varchar(255),
interest_rate int default '600' ,
constraint fk_id_client_from foreign key (id_account_from) references account(id),
constraint fk_id_client_to foreign key (id_account_to) references account(id)
);


