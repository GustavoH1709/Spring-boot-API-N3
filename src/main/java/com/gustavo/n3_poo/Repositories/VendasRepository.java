package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.Vendas;

@Component
public class VendasRepository {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();
	
	public Vendas findById(int venda_id) {
		
		em.getTransaction().begin();
		Vendas get = (Vendas) em.createNativeQuery(String.format("select * from vendas where venda_id = '%d' limit 1", venda_id), Vendas.class).getResultList().stream().findFirst().orElse(null);	
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
}
