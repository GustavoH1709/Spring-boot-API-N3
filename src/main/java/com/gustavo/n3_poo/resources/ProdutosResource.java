package com.gustavo.n3_poo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.n3_poo.Repositories.ProdutosRepository;
import com.gustavo.n3_poo.entities.Produtos;

@RestController
@RequestMapping(value = "/products")
public class ProdutosResource {
	@Autowired
	private ProdutosRepository ProductRepository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> findAll() {
		var result = ProductRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produtos> findById(@PathVariable Long id) {
		var result = ProductRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
}
