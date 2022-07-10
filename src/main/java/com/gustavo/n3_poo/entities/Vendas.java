package com.gustavo.n3_poo.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "vendas")
public class Vendas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int venda_id;
	private String status;
	private int prod_id;
	private String cli_cpf;
	
	public int getVenda_id() {
		return venda_id;
	}
	public void setVenda_id(int venda_id) {
		this.venda_id = venda_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getCli_cpf() {
		return cli_cpf;
	}
	public void setCli_cpf(String cli_cpf) {
		this.cli_cpf = cli_cpf;
	}
	

	
	
}
