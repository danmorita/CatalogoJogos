package com.catalogo.apirestful.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.apirestful.models.Game;
import com.catalogo.apirestful.repository.GameRespository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@Api(value="Game")
@RequestMapping(value="/api")
public class GameResource {

	
	@Autowired
	GameRespository gameRepository;
	
	@ApiOperation(value="consulta os jogos disponíveis")
	@GetMapping("/game")
	public List<Game> listaGames(){
		return gameRepository.findAll();
	}
	
	@ApiOperation(value="consulta os detalhes de um único jogo")
	@GetMapping("/game/{id}")
	public Game getGameById(@PathVariable(value="id")long id){
		return gameRepository.findById(id);
	}
	
	@ApiOperation(value="Cria um novo jogo no catálogo")
	@PostMapping("/game")
	public Game postGame(@RequestBody Game game){
		return gameRepository.save(game);
	}
	
	

}
