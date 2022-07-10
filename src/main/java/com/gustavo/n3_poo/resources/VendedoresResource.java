package com.gustavo.n3_poo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.n3_poo.Repositories.StatusRepository;
import com.gustavo.n3_poo.Repositories.VendedoresRepository;
import com.gustavo.n3_poo.entities.Status;
import com.gustavo.n3_poo.entities.Vendas;
import com.gustavo.n3_poo.entities.Vendedores;

@RestController
@RequestMapping(value = "/vendedores")
public class VendedoresResource {
	
	@Autowired
	private VendedoresRepository vendedoresRepository;
	
	@GetMapping
	public ResponseEntity<List<Vendedores>> findAll() {
		var result = vendedoresRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Vendedores> findById(@PathVariable String id) {	
	    var result = vendedoresRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<String> Add(@PathVariable Vendedores entity) {
		String result; 
		
		try 
		{
			vendedoresRepository.Add(entity);
			result = "Registro Adicionado Com Sucesso";
		} 
		catch (Exception e) 
		{
			result = "Falha ao Adicionar Registro";
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> Delete(@PathVariable String id) {
		
		String result;
		
		try 
		{
			vendedoresRepository.Delete(id);
			result = "Registro Deletado com Sucesso";
		} 
		catch (Exception e)
		{
			result = "Falha ao Deletar Registro\n"+e.getMessage();
		}
			
		return ResponseEntity.ok().body(result);
	}
}
