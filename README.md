# CatalogoJogos

## Criação das tabelas do banco de dados

```SQL
CREATE TABLE GAMES(
	ID SERIAL PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
)

CREATE TABLE GENEROS(
	ID SERIAL PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL
)

CREATE TABLE GAME_GENEROS(
	ID SERIAL PRIMARY KEY,
	GAME_ID SERIAL NOT NULL,
	GENERO_ID SERIAL NOT NULL,
	FOREIGN KEY (GAME_ID) REFERENCES GAMES(ID),
	FOREIGN KEY (GENERO_ID) REFERENCES GENEROS(ID)
)
```


##insert para testes
```
insert into games (name)values ('game');
insert into generos (name)values ('genero1');
insert into game_generos (game_id,genero_id)values (1,1);
insert into generos (name)values ('genero2');
insert into game_generos (game_id,genero_id)values (1,2);
```


##insert de jogos em formato json
```
{
    "name": "jogo3"
}
```