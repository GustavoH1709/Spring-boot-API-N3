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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.gustavo.n3_poo.Repositories.ClientesRepository;
import com.gustavo.n3_poo.entities.Clientes;

@RestController
@RequestMapping(value = "/clientes")
public class ClientesResource {
	@Autowired
	private ClientesRepository clientesRepository;
	
	@GetMapping
	public ResponseEntity<List<Clientes>> findAll() {
		var result = clientesRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Clientes> findById(@PathVariable String id) {	
	    var result = clientesRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<String> Add(@RequestBody Clientes entity) {
		
		String result;
		
		try
		{		
			clientesRepository.Add(entity);
			result = "Registro Adicionado Com Sucesso";
		} 
		catch (Exception e)
		{
			result = "Falha ao Adicionar Registro";
		}

		return ResponseEntity.ok().body(result);
	}
	
	@PutMapping
	public ResponseEntity<String> Update(@RequestBody Clientes entity) {
		String result;
		
		try
		{		
			clientesRepository.Update(entity);
			result = "Registro Atualizado Com Sucesso";
		} 
		catch (Exception e)
		{
			result = "Falha ao Atualizar Registro";
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping
	public ResponseEntity<String> Delete(@PathVariable String id){
		String result;
		
		try
		{		
			clientesRepository.Delete(id);
			result = "Registro Deletado Com Sucesso";
		} 
		catch (Exception e)
		{
			result = "Falha ao Deletar Registro";
		}
		
		return ResponseEntity.ok().body(result);
	}
}
