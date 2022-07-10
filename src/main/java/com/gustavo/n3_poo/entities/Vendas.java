package com.gustavo.n3_poo.entities;

import java.io.Serializable;

public class Vendas implements Serializable {

	private static final long serialVersionUID = 1L;

	private int venda_id;
	private Status status;
	private Produtos produto;
	private Clientes cliente;
	
	public int getVenda_id() {
		return venda_id;
	}
	public void setVenda_id(int venda_id) {
		this.venda_id = venda_id;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Produtos getProduto() {
		return produto;
	}
	
	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
	
	public Clientes getCliente() {
		return cliente;
	}
	
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	
}
