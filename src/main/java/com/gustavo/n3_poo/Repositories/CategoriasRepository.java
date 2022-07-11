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
		Categorias get = em.find(Categorias.class, cat_id);
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
		
		if(entity.getCat_nome().equals("") || entity.getCat_nome().equals(null))
			throw new Exception();
		
		em.persist(entity);
		
		em.getTransaction().commit();
	}
	
	public void Update(Categorias entity) {
		em.getTransaction().begin();
		
		var get = em.find(Categorias.class, entity.getCat_id());
		
		if(get != null)
			em.merge(entity);
		
		em.getTransaction().commit();
	}
	
	public void Delete(int cat_id) {
		em.getTransaction().begin();
		var get = em.find(Categorias.class, cat_id);
		if(get != null)
			em.remove(get);
		em.getTransaction().commit();
	}
}