package com.project.consorcio.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.entity.Especialidad;
import com.project.consorcio.repository.EspecialidadRepository;

@Service
public class EspecialidadServices {

	@Autowired
	private EspecialidadRepository repo;
	
	public void registrar (Especialidad espe) {
		repo.save(espe);
	}
	public void actualizar (Especialidad espe){
		repo.save(espe);
	}
	
	public void eliminarPorID (Integer cod) {
		repo.deleteById(cod);
	}
	
	public Especialidad buscarPorID (Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Especialidad> listarTodos() {
		return repo.findAll();
		}
}
