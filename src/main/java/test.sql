create table if not exists Branch(
                id serial primary key ,
                id_bank int ,
                address varchar(255) ,
                constraint fk_idBank foreign key (id_bank) references Bank(id)
                );

create type employeeType as enum ('grade1','grade2','grade3','boss');

insert into Branch (id_bank,address) values (1,'yousefabad');

--inner join Bank b on br.id_bank = b.id
