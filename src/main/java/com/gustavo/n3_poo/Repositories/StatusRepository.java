package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Status;

@Component
public class StatusRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();
	
	public Status findById(String status) {
		em.getTransaction().begin();
		Status get = (Status) em.createNativeQuery(String.format("select * from status where status = '%s' limit 1", status), Status.class).getResultList().stream().findFirst().orElse(null);	
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
}
