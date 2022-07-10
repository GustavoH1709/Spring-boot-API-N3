package com.gustavo.n3_poo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.n3_poo.Repositories.ProdutosRepository;
import com.gustavo.n3_poo.entities.Produtos;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutosResource {
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> findAll() {
		var result = produtosRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produtos> findById(@PathVariable int id) {
		var result = produtosRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<String> Add(@PathVariable Produtos entity) {
		String result; 
		
		try 
		{
			produtosRepository.Add(entity);
			result = "Registro Adicionado Com Sucesso";
		} 
		catch (Exception e) 
		{
			result = "Falha ao Adicionar Registro";
		}
		
		return ResponseEntity.ok().body(result);
	}
}
