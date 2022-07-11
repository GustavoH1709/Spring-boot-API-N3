package com.gustavo.n3_poo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<String> Add(@RequestBody Produtos entity) {
		String result; 
		
		try 
		{
			produtosRepository.Add(entity);
			result = "Registro Adicionado Com Sucesso";
		} 
		catch (Exception e) 
		{
			result = "Falha ao Adicionar Registro\n"+e.getMessage();
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@PutMapping
	public ResponseEntity<String> Update(@RequestBody Produtos entity) {
		String result; 
		
		try 
		{
			produtosRepository.Update(entity);
			result = "Registro Atualizado Com Sucesso";
		} 
		catch (Exception e) 
		{
			result = "Falha ao Atualizar Registro\n"+e.getMessage();
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> Delete(@PathVariable int id){
		String result;
		
		
		try
		{		
			produtosRepository.Delete(id);
			result = "Registro Deletado Com Sucesso";
		} 
		catch (Exception e)
		{
			result = "Falha ao Deletar Registro\n"+e.getMessage();
		}
		
		return ResponseEntity.ok().body(result);
	}
	
}
