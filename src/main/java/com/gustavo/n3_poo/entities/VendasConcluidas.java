package com.gustavo.n3_poo.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "vendasconcluidas")
public class VendasConcluidas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vendas_concluidas;
	private int venda_id;
	
	public VendasConcluidas() {
		
	}
	
	public VendasConcluidas(int venda_id) {
		super();
		this.venda_id = venda_id;
	}
	
	
	public VendasConcluidas(int id_vendas_concluidas, int venda_id) {
		super();
		this.id_vendas_concluidas = id_vendas_concluidas;
		this.venda_id = venda_id;
	}



	public int getId_vendas_concluidas() {
		return id_vendas_concluidas;
	}
	public void setId_vendas_concluidas(int id_vendas_concluidas) {
		this.id_vendas_concluidas = id_vendas_concluidas;
	}
	
	public int getVenda_id() {
		return venda_id;
	}
	public void setVenda_id(int venda_id) {
		this.venda_id = venda_id;
	}

}
