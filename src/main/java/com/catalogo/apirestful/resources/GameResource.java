package com.catalogo.apirestful.resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.apirestful.models.Game;
import com.catalogo.apirestful.models.Genero;
import com.catalogo.apirestful.repository.GameRepository;
import com.catalogo.apirestful.repository.GeneroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@Api(value="Game")
@RequestMapping(value="/api")
@Validated
public class GameResource {

	
	@Autowired
	GameRepository gameRepository;
	@Autowired
	GeneroRepository generoRepository;
	
	
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
	public Game postGame(@Valid @RequestBody Game game){
		Set<Genero> lista = new HashSet<Genero>();
		Optional<Genero> gen;
		gen = generoRepository.findById(Long.valueOf(1));
		lista.add(gen.get());
		game.setGeneros(lista);
		return gameRepository.save(game);
	}
	
	
	

}
