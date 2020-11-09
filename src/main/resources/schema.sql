--drop table if exists games;
--drop table if exists generos;

--drop sequence if exists seq_games;
--drop sequence if exists seq_generos;
 

create sequence if not exists seq_games;

CREATE TABLE if not exists GAMES(
	ID INTEGER not null default nextval('seq_games') PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
);



create sequence if not exists seq_generos;

CREATE TABLE if not exists GENEROS(
	ID INTEGER not null default nextval('seq_generos') PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
);

