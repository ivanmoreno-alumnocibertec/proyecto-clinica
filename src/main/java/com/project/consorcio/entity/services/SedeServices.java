package com.project.consorcio.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.entity.Sede;
import com.project.consorcio.repository.SedeRepository;

@Service
public class SedeServices {

	
	@Autowired
	private SedeRepository repo;
	
	public void registrar (Sede sede){
		repo.save(sede);
	}
	
	public void actualizar (Sede sede){
		repo.save(sede);
	}
	
	public void eliminarPorID (Integer cod) {
		repo.deleteById(cod);
	}
	
	public Sede buscarPorID (Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Sede> listarTodos() {
		return repo.findAll();
		}
}
