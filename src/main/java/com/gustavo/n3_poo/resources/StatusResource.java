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
import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.Status;

@RestController
@RequestMapping(value = "/status")
public class StatusResource {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping
	public ResponseEntity<List<Status>> findAll() {
		var result = statusRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Status> findById(@PathVariable String id) {	
	    var result = statusRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<String> Add(@PathVariable Status entity) {
		String result; 
		
		try 
		{
			statusRepository.Add(entity);
			result = "Registro Adicionado Com Sucesso";
		} 
		catch (Exception e) 
		{
			result = "Falha ao Adicionar Registro";
		}
		
		return ResponseEntity.ok().body(result);
	}
}
