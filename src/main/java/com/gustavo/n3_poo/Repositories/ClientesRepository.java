package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Clientes;

@Component
public class ClientesRepository {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();

	public Clientes findById(String cli_cpf) {
		
		em.getTransaction().begin();
		Clientes get = (Clientes) em.createNativeQuery(String.format("select * from clientes where cli_cpf = '%s' limit 1", cli_cpf), Clientes.class).getResultList().stream().findFirst().orElse(null);	
		em.getTransaction().commit();
		
		return get;
		
	}

	public List<Clientes> findAll() {

		List<Clientes> get;

		em.getTransaction().begin();
		get = (List<Clientes>) em.createNativeQuery("select * from clientes", Clientes.class).getResultList();
		em.getTransaction().commit();
		

		return get;
	}

	public void Add(Clientes entity) throws Exception {
		em.getTransaction().begin();
		
		if(entity.getCli_cpf().equals("") || entity.getCli_cpf().equals(null))
			throw new Exception();
		
		em.createNativeQuery(
				String.format("insert into clientes (cli_cpf, telefone, nome) values ('%s', '%s', '%s');", 
				entity.getCli_cpf(), entity.getTelefone(), entity.getNome()
				), Clientes.class);
		
		em.getTransaction().commit();
	}
	
	public void Update(Clientes entity) throws Exception {
		em.getTransaction().begin();
		
		if(entity.getCli_cpf().equals("") || entity.getCli_cpf().equals(null))
			throw new Exception();
		
		em.createNativeQuery(
				String.format("update clientes set telefone = '%s', nome = '%s' where  cli_cpf = '%s';", 
				entity.getTelefone(), entity.getNome(), entity.getCli_cpf()
				), Clientes.class);
		
		System.out.println(String.format("update clientes set telefone = '%s', nome = '%s' where cli_cpf = '%s';", 
				entity.getTelefone(), entity.getNome(), entity.getCli_cpf()));
		
		em.getTransaction().commit();
	}
	
	public void Delete(String cli_cpf) throws Exception {
		em.getTransaction().begin();
		
		if(cli_cpf.equals("") || cli_cpf.equals(null))
			throw new Exception();
		
		em.createNativeQuery(String.format("delete from clientes where cli_cpf = '%s';"));
		
		em.getTransaction().commit();
	}
}
