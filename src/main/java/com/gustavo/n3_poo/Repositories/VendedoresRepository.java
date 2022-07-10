package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.Vendedores;

@Component
public class VendedoresRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();
	
	public Vendedores findById(String vend_cpf) {
		em.getTransaction().begin();
		Vendedores get = (Vendedores) em.createNativeQuery(String.format("select * from vendedores where vend_cpf = '%s' limit 1", vend_cpf), Vendedores.class).getResultList().stream().findFirst().orElse(null);	
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
}
