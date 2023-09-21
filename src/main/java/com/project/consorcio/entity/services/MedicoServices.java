package com.project.consorcio.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.consorcio.entity.Medico;
import com.project.consorcio.repository.MedicoRepository;

@Service
public class MedicoServices {

	@Autowired
	private MedicoRepository repo;
	

	public void registrar (Medico medic){
		repo.save(medic);
	}
	
	public void actualizar (Medico medic){
		repo.save(medic);
	}
	
	public void eliminarPorID (Integer cod) {
		repo.deleteById(cod);
	}
	
	public Medico buscarPorID (Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public List<Medico> listarTodos() {
		return repo.findAll();
		}
	
}
