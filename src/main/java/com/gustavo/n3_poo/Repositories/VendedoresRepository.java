package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.Vendas;
import com.gustavo.n3_poo.entities.Vendedores;

@Component
public class VendedoresRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();
	
	public Vendedores findById(String vend_cpf) {
		em.getTransaction().begin();
		Vendedores get = em.find(Vendedores.class, vend_cpf);
		em.getTransaction().commit();
		
		return get;
	}
	
	public List<Vendedores> findAll() {
		List<Vendedores> get;

		em.getTransaction().begin();
		get = (List<Vendedores>) em.createNativeQuery("select * from vendedores", Produtos.class).getResultList();
		em.getTransaction().commit();
		
		return get;
	}
	
	public void Add(Vendedores entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public void Delete(String vend_cpf) {
		em.getTransaction().begin();
		var get = em.find(Vendedores.class, vend_cpf);
		em.remove(get);
		em.getTransaction().commit();
	}
}
