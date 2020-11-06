package com.catalogo.apirestful.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="GENEROS")
public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
//	@OneToMany(mappedBy = "catalogo")
//	private Set<GameGeneros> games;
//	 @ManyToMany(fetch = FetchType.LAZY,
//	            cascade = {
//	                CascadeType.PERSIST,
//	                CascadeType.MERGE
//	            },
//	            mappedBy = "catalogos")
//	private Set<Game> games=new HashSet<Game>();

	
	
	public Genero(String name) {
		super();
		this.name = name;
	}
	
	public Genero() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	




	
	
}
