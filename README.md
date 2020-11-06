# CatalogoJogos

## Criação das tabelas do banco de dados

```SQL
CREATE TABLE GAMES(
	ID SERIAL PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
)

CREATE TABLE CATALOGOS(
	ID SERIAL PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
)

CREATE TABLE GAME_CATALOGOS(
	ID SERIAL PRIMARY KEY,
	GAME_ID SERIAL NOT NULL,
	CATALOGO_ID SERIAL NOT NULL,
	FOREIGN KEY (GAME_ID) REFERENCES GAMES(ID),
	FOREIGN KEY (CATALOGO_ID) REFERENCES CATALOGOS(ID)
)
```


##insert para testes
```
insert into games (name)values ('game');
insert into catalogos (name)values ('catalogo1');
insert into game_catalogos (game_id,catalogo_id)values (1,1);
insert into catalogos (name)values ('catalogo2');
insert into game_catalogos (game_id,catalogo_id)values (1,2);
```