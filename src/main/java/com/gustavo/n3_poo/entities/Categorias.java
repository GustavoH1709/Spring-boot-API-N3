package com.gustavo.n3_poo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "categorias")
public class Categorias implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cat_id;
	private String cat_nome;
	
	public Categorias() {
		
	}
	
	public Categorias(int cat_id, String cat_nome) {
		super();
		this.cat_id = cat_id;
		this.setCat_nome(cat_nome);
	}

	

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_nome() {
		return cat_nome;
	}

	public void setCat_nome(String cat_nome) {
		this.cat_nome = cat_nome;
	}
}
