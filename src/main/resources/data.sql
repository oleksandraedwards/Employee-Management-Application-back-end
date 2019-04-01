/*create table person
(
	id integer not null,
	name varchar(100) not null,
	location varchar(100),
	birth_date timestamp,
	primary key(id)
);
*/
--      USER:
--     private List<Role> authorities;
--     private String password;
--     private String username;
--     private boolean accountNonExpired;
--     private boolean accountNonLocked;
--     private boolean credentialsNonExpired;
--     private boolean enabled;
--

INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_PM');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

insert into USERS (name, username, email, password)
values ('max', 'max', 'michenko@mail', 'michenko@mail');

insert into USERS (name, username, email, password)
values ('jackie', 'jackie', 'jackie@mail', 'jackie@mail');

insert into USERS (name, username, email, password)
values ('sarah', 'sarah', 'sarah@mail', 'sarah@mail');

insert into USERS (name, username, email, password)
values ('keith', 'keith', 'keith@mail', 'keith@mail');


insert into USER_ROLES (USER_ID, ROLE_ID)
values (1, 1);

insert into USER_ROLES (USER_ID, ROLE_ID)
values (2, 1);

insert into USER_ROLES (USER_ID, ROLE_ID)
values (3, 1);

insert into USER_ROLES (USER_ID, ROLE_ID)
values (4, 1);


insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP , 'Max', 'Michenko', 34.56, 'welder');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Elena', 'Temnova', 47.56, 'waitress');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Anton', 'Sestricin', 56.16, 'translator');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP , 'Jack', 'Michenko', 100.56, 'technical writer');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Dan', 'Karoll', 16.56, 'statistician');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Olga', 'Ruben', 82.56, 'shipping clerk');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP , 'Max', 'Michenko', 34.56, 'welder');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Elena', 'Temnova', 47.56, 'waitress');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Anton', 'Sestricin', 56.16, 'translator');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP , 'Jack', 'Michenko', 100.56, 'technical writer');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Dan', 'Karoll', 16.56, 'statistician');

insert into EMPL (created, name, last_name, salary, position)
values (CURRENT_TIMESTAMP ,'Olga', 'Ruben', 82.56, 'shipping clerk');
