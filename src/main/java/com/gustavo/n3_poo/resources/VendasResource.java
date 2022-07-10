package com.gustavo.n3_poo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.n3_poo.Repositories.StatusRepository;
import com.gustavo.n3_poo.Repositories.VendasRepository;
import com.gustavo.n3_poo.entities.Status;
import com.gustavo.n3_poo.entities.Vendas;

@RestController
@RequestMapping(value = "/vendas")
public class VendasResource {
	@Autowired
	private VendasRepository vendasRepository;
	
	@GetMapping
	public ResponseEntity<List<Vendas>> findAll() {
		var result = vendasRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Vendas> findById(@PathVariable int id) {	
	    var result = vendasRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<String> Add(@PathVariable Vendas entity) {
		String result; 
		
		try 
		{
			vendasRepository.Add(entity);
			result = "Registro Adicionado Com Sucesso";
		} 
		catch (Exception e) 
		{
			result = "Falha ao Adicionar Registro";
		}
		
		return ResponseEntity.ok().body(result);
	}
}
