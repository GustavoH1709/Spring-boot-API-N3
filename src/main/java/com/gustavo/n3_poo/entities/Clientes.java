package com.gustavo.n3_poo.entities;

import java.io.Serializable;
import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "clientes")
public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String cli_cpf;
	private String telefone;
	private String nome;
	
	public Clientes(String cli_cpf, String telefone, String nome) {
		super();
		this.cli_cpf = cli_cpf;
		this.telefone = telefone;
		this.nome = nome;
	}
	
	public Clientes() {
		
	}
	
	public String getCli_cpf() {
		return cli_cpf;
	}
	public void setCli_cpf(String cli_cpf) {
		this.cli_cpf = cli_cpf;
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
