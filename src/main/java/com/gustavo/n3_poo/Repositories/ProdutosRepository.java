package com.gustavo.n3_poo.Repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gustavo.n3_poo.entities.Produtos;

@Component
public class ProdutosRepository {
private Map<Long, Produtos> map = new HashMap<Long, Produtos>();
	
	public void save(Produtos obj) {
		map.put(obj.getId(), obj);
	}

	public Produtos findById(Long id) {
		return map.get(id);
	}
	
	public List<Produtos> findAll() {
		return new ArrayList<Produtos>(map.values());
	}
	
}
