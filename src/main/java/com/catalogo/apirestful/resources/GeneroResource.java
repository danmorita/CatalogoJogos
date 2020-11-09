package com.catalogo.apirestful.resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.apirestful.models.Game;
import com.catalogo.apirestful.models.Genero;
import com.catalogo.apirestful.repository.GameRepository;
import com.catalogo.apirestful.repository.GeneroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins="*")
@RestController
@Api(value="Genero")
@RequestMapping(value="/api/genre")
@Validated
public class GeneroResource {

	
	@Autowired
	GameRepository gameRepository;
	@Autowired
	GeneroRepository generoRepository;
	
	
	@ApiOperation(value="Consulta todos os jogos de um gênero")
	@GetMapping("/{id}")
	public ResponseEntity<?> getGeneroById(@PathVariable(value="id")long id){
		
		
		return ResponseEntity.ok("Jogos do genero");
	}
	

}

