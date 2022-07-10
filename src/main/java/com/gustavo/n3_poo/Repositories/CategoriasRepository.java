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

@Component
public class CategoriasRepository {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();

	public Categorias findById(int cat_id) {
		em.getTransaction().begin();
		Categorias get = (Categorias) em.createNativeQuery(String.format("select * from categorias where cat_id = %d limit 1", cat_id), Clientes.class).getResultList().stream().findFirst().orElse(null);	
		em.getTransaction().commit();
		
		return get;
	}
	
	public List<Categorias> findAll() {
		List<Categorias> get;

		em.getTransaction().begin();
		get = (List<Categorias>) em.createNativeQuery("select * from categorias", Categorias.class).getResultList();
		em.getTransaction().commit();
		
		return get;
	}
	
	public void Add(Categorias entity) throws Exception {
		em.getTransaction().begin();
		
		if(entity.getName().equals("") || entity.getName().equals(null))
			throw new Exception();
		
		/*em.createNativeQuery(
				String.format("insert into categorias (cat_nome) values ('%s');", 
				entity.getName()
				), Categorias.class);*/
		
		em.persist(entity);
		
		em.getTransaction().commit();
	}
}