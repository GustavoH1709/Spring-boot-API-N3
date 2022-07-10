package com.gustavo.n3_poo.Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Clientes;
import com.gustavo.n3_poo.entities.Produtos;

@Component
public class ProdutosRepository {	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();

	public Produtos findById(int prod_id) {
		
		em.getTransaction().begin();
		Produtos get = (Produtos) em.createNativeQuery(String.format("select * from produtos where prod_id = '%d' limit 1", prod_id), Produtos.class).getResultList().stream().findFirst().orElse(null);	
		em.getTransaction().commit();
		
		return get;
		
	}

	public List<Produtos> findAll() {

		List<Produtos> get;

		em.getTransaction().begin();
		get = (List<Produtos>) em.createNativeQuery("select * from produtos", Produtos.class).getResultList();
		em.getTransaction().commit();
		

		return get;
	}
	
}
