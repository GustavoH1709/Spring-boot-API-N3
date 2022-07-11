package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Status;
import com.gustavo.n3_poo.entities.VendasConcluidas;

@Component
public class VendasConcluidasRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("n3poo");
	private EntityManager em = emf.createEntityManager();
	
	public VendasConcluidas findById(int id_vendas_concluidas) {
		em.getTransaction().begin();
		VendasConcluidas get = em.find(VendasConcluidas.class, id_vendas_concluidas);	
		em.getTransaction().commit();
		
		return get;
	}
	
	public List<VendasConcluidas> findAll() {
		List<VendasConcluidas> get;

		em.getTransaction().begin();
		get = (List<VendasConcluidas>) em.createNativeQuery("select * from status", VendasConcluidas.class).getResultList();
		em.getTransaction().commit();
		
		return get;
	}
}
