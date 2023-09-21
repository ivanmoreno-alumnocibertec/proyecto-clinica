package com.project.consorcio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Distrito;
import com.project.consorcio.entity.Especialidad;
import com.project.consorcio.entity.Medico;
import com.project.consorcio.entity.Sede;
import com.project.consorcio.entity.services.DistritoServices;
import com.project.consorcio.entity.services.EspecialidadServices;
import com.project.consorcio.entity.services.MedicoServices;
import com.project.consorcio.entity.services.SedeServices;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private MedicoServices servicioMedic;
	
	@Autowired
	private DistritoServices servicioDistr;
	
	@Autowired
	private EspecialidadServices servicioEspec;
	
	@Autowired
	private SedeServices servicioSede;
	
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("medico", servicioMedic.listarTodos());
		model.addAttribute("distrito", servicioDistr.listarTodos());
		model.addAttribute("especialidad", servicioEspec.listarTodos());
		model.addAttribute("sede", servicioSede.listarTodos());
		
		return "medico";
	}
	
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod, 
			@RequestParam("nombre") String nom, 
			@RequestParam("apellido") String ape, 
			@RequestParam("dni") String dni,
			/*
			@RequestParam("fecha") String fec,
			@RequestParam("sexo") String sexo,
			@RequestParam("estado_civil") String est,
			@RequestParam("Sueldo") double sue, 
			*/
			@RequestParam("especialidad") int codEspe, 
			@RequestParam("sede") int codSede, 
			@RequestParam("distrito") int codDist, 
						RedirectAttributes redirect) {

		try {
			Medico medic = new Medico();
			medic.setNombre(nom);
			medic.setApellido(ape);
			medic.setDni(dni);
			
			/*
			med.setFecha(LocalDate.parse(fec));
			med.setSexo(sexo);
			med.setEstado_civil(est);
			med.setSueldo(sue);
			*/
			
			Especialidad esp = new Especialidad();
			esp.setCodigo(codEspe);
			medic.setEspecialidad(esp);
			
			Sede sede = new Sede();
			sede.setCodigo(codSede);
			medic.setSede(sede);

			Distrito dist = new Distrito();
			dist.setCodigo(codDist);
			medic.setDistrito(dist);
			
			if (cod==0) {
			servicioMedic.registrar(medic);
			redirect.addFlashAttribute("MENSAJE", "Medico registrado");
			}
			else {
				medic.setCodigo(cod);
				servicioMedic.actualizar(medic);
				redirect.addFlashAttribute("MENSAJE","Medico actualizado");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/medico/lista";
	}


	@RequestMapping("/buscar")
	@ResponseBody
	public Medico buscar(@RequestParam("codigo") Integer cod) {
		return servicioMedic.buscarPorID(cod);

	}
	
}
