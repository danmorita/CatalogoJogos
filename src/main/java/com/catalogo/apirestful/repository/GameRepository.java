package com.catalogo.apirestful.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catalogo.apirestful.models.Game;


public interface GameRepository extends JpaRepository<Game, Long>{
	
	@Query(value = "SELECT g FROM Game g ORDER BY id")
	Page<Game> findAllGamesWithPagination(Pageable pageable);
//	List<Game>
	Game findById(long id);
}
