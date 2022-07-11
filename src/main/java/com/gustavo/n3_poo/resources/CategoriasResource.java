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

import com.gustavo.n3_poo.Repositories.CategoriasRepository;
import com.gustavo.n3_poo.entities.Categorias;
import com.gustavo.n3_poo.entities.Clientes;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasResource {

	@Autowired
	private CategoriasRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> findAll() {
		var result = categoriaRepository.findAll();
		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categorias> findById(@PathVariable int id) {
		var result = categoriaRepository.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping
	public ResponseEntity<String> Add(@RequestBody Categorias entity) {
		String result;
		
		try
		{	
			System.out.println(entity.getCat_nome());
			categoriaRepository.Add(entity);
			result = "Registro Adicionado Com Sucesso";
		} 
		catch (Exception e)
		{
			result = "Falha ao Adicionar Registro\n"+e.getMessage();
		}
		
		return ResponseEntity.ok().body(result);
	}
	
	@PutMapping
	public ResponseEntity<String> Update(@RequestBody Categorias entity) {
		String result;
		
		
		try
		{				
			categoriaRepository.Update(entity);
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
			categoriaRepository.Delete(id);
			result = "Registro Deletado Com Sucesso";
		} 
		catch (Exception e)
		{
			result = "Falha ao Deletar Registro\n"+e.getMessage();
		}
		
		return ResponseEntity.ok().body(result);
	}
}
