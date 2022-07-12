package com.gustavo.n3_poo.Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Clientes;
import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.Status;
import com.gustavo.n3_poo.entities.Vendas;
import com.gustavo.n3_poo.entities.VendasConcluidas;
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
	
	public void Add(Vendas entity) throws Exception {
		em.getTransaction().begin();
		
		var produto = em.find(Produtos.class, entity.getProd_id());
		var cliente = em.find(Clientes.class, entity.getCli_cpf());
		var status = em.find(Status.class, entity.getStatus());
		
		if(produto != null && cliente != null && status != null)
		{
			try 
			{
				 em.persist(entity);
				 if(entity.getStatus().equals("F")) 
				 {
					 var get = (Vendas) em.createNativeQuery("select * from vendas order by venda_id desc limit 1", Vendas.class).getResultList().stream().findFirst().orElse(null);
					 var newEntry = new VendasConcluidas(get.getVenda_id());
					 em.persist(newEntry);
				 }
			}
			catch (Exception e)
			{
				throw new Exception("Erro ao gravar");
			}
		}
		else
		{
			em.getTransaction().commit();
			throw new Exception("Erro de FK");
		}
		
		em.getTransaction().commit();
	}
	
	public void Update(Vendas entity) throws Exception {
		em.getTransaction().begin();
		
		var get = em.find(Vendas.class, entity.getVenda_id());
		
		var produto = em.find(Produtos.class, entity.getProd_id());
		var cliente = em.find(Clientes.class, entity.getCli_cpf());
		var status = em.find(Status.class, entity.getStatus());
		
		if(get != null)
			if(produto != null && cliente != null && status != null)
				if(!get.getStatus().equals("F"))
					em.merge(entity);
				else 
				{
					var get2 = (Vendas) em.createNativeQuery("select * from vendas order by venda_id desc limit 1", Vendas.class).getResultList().stream().findFirst().orElse(null);
					var newEntry = new VendasConcluidas(get2.getVenda_id());
					em.persist(newEntry);
				}
			else 
			{
				em.getTransaction().commit();
				throw new Exception("Erro de FK");
			}
		
		em.getTransaction().commit();
	}
	
	public void Delete(int venda_id) {
		em.getTransaction().begin();
		var get = em.find(Vendas.class, venda_id);
		
		if(get != null)
			em.remove(get);
		
		em.getTransaction().commit();
	}
}
