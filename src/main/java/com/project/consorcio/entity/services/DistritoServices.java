package com.project.consorcio.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.entity.Distrito;
import com.project.consorcio.repository.DistritoRepository;

@Service
public class DistritoServices {

	@Autowired
	private DistritoRepository repo;
	
	public void registrar (Distrito dist) {
		repo.save(dist);
	}
	
	public void actualizar (Distrito dist){
		repo.save(dist);
	}
	
	public void eliminar (Integer cod) {
		repo.deleteById(cod);
	}
	
	public Distrito buscarPorID (Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Distrito> listarTodos() {
		return repo.findAll();
	}
}
