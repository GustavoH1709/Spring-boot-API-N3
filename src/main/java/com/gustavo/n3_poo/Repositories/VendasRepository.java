package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.Status;
import com.gustavo.n3_poo.entities.Vendas;
import com.gustavo.n3_poo.entities.Vendedores;

@Component
public class VendasRepository {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();
	
	public Vendas findById(int venda_id) {
		
		em.getTransaction().begin();
		Vendas get = em.find(Vendas.class, venda_id);	
		em.getTransaction().commit();
		
		return get;
		
	}

	public List<Vendas> findAll() {

		List<Vendas> get;

		em.getTransaction().begin();
		get = (List<Vendas>) em.createNativeQuery("select * from vendas", Vendas.class).getResultList();
		em.getTransaction().commit();
		

		return get;
	}
	
	public void Add(Vendas entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public void Update(Vendas entity) throws Exception {
		em.getTransaction().begin();
		
		var get = em.find(Vendas.class, entity.getVenda_id());
		
		if(get != null)
			em.merge(entity);
		
		em.getTransaction().commit();
	}
	
	public void Delete(int venda_id) {
		em.getTransaction().begin();
		var get = em.find(Vendas.class, venda_id);
		em.remove(get);
		em.getTransaction().commit();
	}
}
