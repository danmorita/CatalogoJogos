# Catalogo de Jogos

## Descrição
Api restful para catalogar jogos CRUD
foi desenvolvido com framework spring boot 2

## Endpoint
- Games
	- GET/api/games - Lista de jogos
	- GET/api/games/{id} - Busca por ID
	- POST/api/games/
	
		```json
			{
    			"name": "jogo3",
    			"generos":[
     				{
      					"id": 2
     				},
     				{
     					 "id": 3
     				}
     			]

			}
		```
		
	- PUT/api/games/{id}
		```JSON
			{
    			"name": "jogo3",
    			"generos":[
     				{
      					"id": 2
     				},
     				{
     					 "id": 3
     				}
     			]

			}
		```

## Pré-requisitos
- JAVA 8 ou >
- Postgres


