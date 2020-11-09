package com.catalogo.apirestful.resources;

import java.util.ArrayList;
import java.util.Iterator;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.apirestful.models.Game;
//import com.catalogo.apirestful.models.GameService;
import com.catalogo.apirestful.models.Genero;
import com.catalogo.apirestful.repository.GameRepository;
import com.catalogo.apirestful.repository.GeneroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@Api(value="Game")
@RequestMapping(value="/api/games")
@Validated
public class GameResource {

	
//	@Autowired
//	GameService gameService;
	@Autowired
	GeneroRepository generoRepository;
	@Autowired
	GameRepository gameRepository;
	
	
	@ApiOperation(value="consulta os jogos disponíveis")
	@GetMapping
	public Page<Game> listaGames(@RequestParam(
			value = "page",
			required = false,
			defaultValue = "0") int page,
	@RequestParam(
			value = "size",
			required = false,
			defaultValue = "10") int size){
		PageRequest pageRequest = PageRequest.of(
                page,
                size);

		return gameRepository.findAllGamesWithPagination(pageRequest);
	}
	
	@ApiOperation(value="consulta os detalhes de um único jogo")
	@GetMapping("/{id}")
	public Game getGameById(@PathVariable(value="id")long id){
		return gameRepository.findById(id);
	}
	
	@ApiOperation(value="Cria um novo jogo no catálogo")
	@PostMapping()
	public ResponseEntity<?> postGame(@Valid @RequestBody Game game){
		
		gameRepository.save(game);
		return ResponseEntity.ok("Jogo salvo");
		
	}
	
	@ApiOperation(value=" Atualiza um jogo do catálogo")
	@PutMapping("/{id}")
	public ResponseEntity<?> putGame(@PathVariable(value="id")long id, @Valid @RequestBody Game game){
		Game gameFind = gameRepository.findById(id);
		if(gameFind == null) {
			return new ResponseEntity("Jogo nao encontrado",HttpStatus.NOT_FOUND);
		}
		gameFind.setName(game.getName());
		gameFind.setGeneros(new ArrayList<Genero>());
		Iterator<Genero> generositerator = game.getGeneros().iterator();
		Genero genero;
		while(generositerator.hasNext()) {
			genero = generositerator.next();
			Genero buscaGen = generoRepository.findById(genero.getId());
			if(buscaGen != null) {
				gameFind.getGeneros().add(buscaGen);
			}
		}
		gameRepository.save(gameFind);
		
		return new ResponseEntity("Jogo Atualizado",HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Deleta um jogo do catálogo")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteGameById(@PathVariable(value="id")long id){
		Game gameFind = gameRepository.findById(id);
		if(gameFind == null) {
			return new ResponseEntity("Jogo nao encontrado",HttpStatus.NOT_FOUND);
		}
		gameRepository.delete(gameFind);
		
		return new ResponseEntity("Jogo Deletado",HttpStatus.OK);
	}
	


}
