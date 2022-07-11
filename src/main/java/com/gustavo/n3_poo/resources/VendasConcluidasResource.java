package com.gustavo.n3_poo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.n3_poo.Repositories.ProdutosRepository;
import com.gustavo.n3_poo.Repositories.VendasConcluidasRepository;
import com.gustavo.n3_poo.entities.Produtos;
import com.gustavo.n3_poo.entities.VendasConcluidas;

@RestController
@RequestMapping(value = "/vendasconcluidas")
public class VendasConcluidasResource {
	
	@Autowired
	private VendasConcluidasRepository vendasConcluidasRepository;
	
	@GetMapping
	public ResponseEntity<List<VendasConcluidas>> findAll() {
		var result = vendasConcluidasRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<VendasConcluidas> findById(@PathVariable int id) {
		var result = vendasConcluidasRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
}
