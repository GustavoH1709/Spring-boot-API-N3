package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.Status;

@Component
public class StatusRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();
	
	public Status findById(String status) {
		em.getTransaction().begin();
		Status get = em.find(Status.class, status);	
		em.getTransaction().commit();
		
		return get;
	}
	
	public List<Status> findAll() {
		List<Status> get;

		em.getTransaction().begin();
		get = (List<Status>) em.createNativeQuery("select * from status", Status.class).getResultList();
		em.getTransaction().commit();
		
		return get;
	}
	
	public void Add(Status entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public void Delete(String status) {
		em.getTransaction().begin();
		var get = em.find(Status.class, status);
		if(get != null)
			em.remove(get);
		em.getTransaction().commit();
	}
}
