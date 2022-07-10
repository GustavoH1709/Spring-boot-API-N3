package com.gustavo.n3_poo.Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Categorias;
import com.gustavo.n3_poo.entities.Clientes;
import com.gustavo.n3_poo.entities.Produtos;

@Component
public class ProdutosRepository {	
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();

	public Produtos findById(int prod_id) {
		
		em.getTransaction().begin();
		Produtos get = em.find(Produtos.class, prod_id);	
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
	
	public void Add(Produtos entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public void Update(Produtos entity) {
		em.getTransaction().begin();
		
		var get = em.find(Produtos.class, entity.getProd_id());
			
		if(get != null)
			em.merge(entity);
		
		em.getTransaction().commit();
	}
	
	public void Delete(int prod_id) {
		em.getTransaction().begin();
		var get = em.find(Produtos.class, prod_id);
		if(get != null)
			em.remove(get);
		em.getTransaction().commit();
	}
	
}
