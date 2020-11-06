package com.catalogo.apirestful.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="GAMES")
public class Game implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
//	@OneToMany(mappedBy = "game")
	@ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "game_catalogos",
            joinColumns = { @JoinColumn(name = "game_id") },
            inverseJoinColumns = { @JoinColumn(name = "id") })
	private Set<Catalogo> catalogos;
	
	
	
	
	public Game(String name) {
		super();
		this.name = name;
	}



	public Game() {
	}



	public long getId() {
		return id;
	}






	public Set<Catalogo> getCatalogos() {
		return catalogos;
	}



	public void setCatalogos(Set<Catalogo> catalogos) {
		this.catalogos = catalogos;
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
