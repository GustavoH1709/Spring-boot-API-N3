package com.gustavo.n3_poo.entities;

import java.io.Serializable;
import java.util.Objects;

public class Produtos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private float price;
	private Categorias categoria;
	
	public Produtos(long id, String name, float price, Categorias categoria) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoria = categoria;
	}
	
	public Produtos() {
		
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
	
	public Categorias getCategory() {
		return categoria;
	}
	
	public void setCategory(Categorias categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return id == other.id;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
}
