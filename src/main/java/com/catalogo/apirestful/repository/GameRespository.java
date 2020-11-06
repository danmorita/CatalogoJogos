package com.catalogo.apirestful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogo.apirestful.models.Game;

public interface GameRespository extends JpaRepository<Game, Long> {
	Game findById(long id);
	
//	List<Game>
}
