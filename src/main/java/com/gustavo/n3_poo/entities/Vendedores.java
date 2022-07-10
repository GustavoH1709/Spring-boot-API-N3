package com.gustavo.n3_poo.entities;

import java.io.Serializable;

import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "vendedores")
public class Vendedores implements Serializable {

	/**
	 * 
	 * a
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String vend_cpf;
	private String telefone;
	private String nome;
	
	public String getVend_cpf() {
		return vend_cpf;
	}
	public void setVend_cpf(String vend_cpf) {
		this.vend_cpf = vend_cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
