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
	@Column(name = "cat_nome")
	private String cat_nome;
	
	public Categorias() {
		
	}

	public int getId() {
		return cat_id;
	}

	public void setId(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getName() {
		return cat_nome;
	}

	public void setName(String name) {
		this.cat_nome = name;
	}

	public Categorias(int cat_id, String name) {
		super();
		this.cat_id = cat_id;
		this.cat_nome = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cat_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorias other = (Categorias) obj;
		return cat_id == other.cat_id;
	}
}
