package com.project.consorcio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.TipoMedicamento;
import com.project.consorcio.entity.services.MedicamentoServices;
import com.project.consorcio.entity.services.TipoMedicamentoServices;

// Anotación que indica que la clase es un controlador, por lo tanto
// permite recibir peticiones de los clientes y envia respuestas
@Controller

// Permite crear una dirección URL o Ruta para acceder al controlador
@RequestMapping("/medicamento")

public class MedicamentoController {

	@Autowired
	private MedicamentoServices servicioMed;

	@Autowired
	private TipoMedicamentoServices servicioTipo;

	@RequestMapping("/lista")
	// Model es una interfaz que permite crear atributos que luego seran enviados a
	// la página

	public String index(Model model) {
		// Atributos
		model.addAttribute("medicamento", servicioMed.listarTodos());
		model.addAttribute("tipo", servicioTipo.listarTodos());
		return "medicamento";
	}

	// @RequestParam, permite recuperar valores que se encuentran en los controles
	// del formulario
	// (cajas, checkbox, radio, etc)
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigo") Integer cod, 
						@RequestParam("nombre") String nom, 
						@RequestParam("descripcion") String des,
						@RequestParam("stock") int stock, 
						@RequestParam("precio") double pre, 
						@RequestParam("fecha") String fec,
						@RequestParam("tipo") int codTipo, 
						RedirectAttributes redirect) {

		try {
			// Crear objeto de la entidad Medicamento
			Medicamento med = new Medicamento();
			// Setear atributos del objeto "med" con los parametros
			med.setNombre(nom);
			med.setDescripcion(des);
			med.setStock(stock);
			med.setPrecio(pre);
			med.setFecha(LocalDate.parse(fec));
			// Crear un objeto de la entidad TipoMedicamento
			TipoMedicamento tm = new TipoMedicamento();
			// Setear atributo "codigo" del objeto "tm" con el parametro codTipo
			tm.setCodigo(codTipo);
			// Invocar al método setTipo y enviar el objeto "tm"
			med.setTipo(tm);
			// Validar parametro "cod"
			if (cod==0) {
			// Invocar método registrar
			servicioMed.registrar(med);
			// crear atributo de tipo flash
			redirect.addFlashAttribute("MENSAJE", "Medicamento registrado");
			}
			else {
				// Setear atributo codigo
				med.setCodigo(cod);
				servicioMed.actualizar(med);
				redirect.addFlashAttribute("MENSAJE","Medicamento actualizado");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/medicamento/lista";
	}

	// ruta o direccion url para buscar medicamento segun codigo

	@RequestMapping("/buscar")
	@ResponseBody
	public Medicamento buscar(@RequestParam("codigo") Integer cod) {
		return servicioMed.buscarPorID(cod);

	}

}
