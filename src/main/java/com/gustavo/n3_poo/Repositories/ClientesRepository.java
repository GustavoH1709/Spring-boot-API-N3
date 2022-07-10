package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Clientes;
import com.gustavo.n3_poo.entities.Vendas;

@Component
public class ClientesRepository {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();

	public Clientes findById(String cli_cpf) {
		
		em.getTransaction().begin();
		Clientes get = em.find(Clientes.class, cli_cpf);
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
		
		em.persist(entity);
		
		em.getTransaction().commit();
	}
	
	public void Update(Clientes entity) throws Exception {
		em.getTransaction().begin();
		
		if(entity.getCli_cpf().equals("") || entity.getCli_cpf().equals(null))
			throw new Exception();
		
		em.merge(entity);
		
		em.getTransaction().commit();
	}
	
	public void Delete(String cli_cpf) {
		em.getTransaction().begin();
		var get = em.find(Clientes.class, cli_cpf);
		if(get != null)
			em.remove(get);
		em.getTransaction().commit();
	}
}
