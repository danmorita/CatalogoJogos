insert into generos(name) select 'acao' where not exists(
	select 1 from generos where name = 'acao'
);

insert into generos(name) select 'aventura' where not exists(
	select 1 from generos where name = 'aventura'
);
insert into generos(name) select 'romance' where not exists(
	select 1 from generos where name = 'romance'
);
insert into generos(name) select 'drama' where not exists(
	select 1 from generos where name = 'drama'
);
insert into generos(name) select 'corrida' where not exists(
	select 1 from generos where name = 'corrida'
);
insert into generos(name) select 'rpg' where not exists(
	select 1 from generos where name = 'rpg'
);
insert into generos(name) select 'fps' where not exists(
	select 1 from generos where name = 'fps'
);
insert into generos(name) select 'moba' where not exists(
	select 1 from generos where name = 'moba'
);
