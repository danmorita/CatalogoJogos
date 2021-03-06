package com.catalogo.apirestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogo.apirestful.models.Game;
import com.catalogo.apirestful.models.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
	Genero findById(long id);
}

