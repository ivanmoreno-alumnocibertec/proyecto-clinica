package com.project.consorcio.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_medico")

public class Medico {

	@Id
	@Column(name = "cod_med")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "nom_med")
	private String nombre;

	@Column(name = "ape_med")
	private String apellido;

	@Column(name = "fec_nac_med")
	private LocalDate fecha;

	@Column(name = "sexo_med")
	private String sexo;

	@Column(name = "est_civ_med")
	private String estado_civil;

	@Column(name = "dni_med")
	private String dni;

	@Column(name = "sue_med")
	private Double Sueldo;

	@Column(name = "dir_emp")
	private String direccion;

	@ManyToOne
	@JoinColumn(name = "cod_espe")
	private Especialidad especialidad;

	@ManyToOne
	@JoinColumn(name = "cod_sede")
	private Sede sede;

	@ManyToOne
	@JoinColumn(name = "cod_dis")
	private Distrito distrito;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado_civil() {
		return estado_civil;
	}

	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Double getSueldo() {
		return Sueldo;
	}

	public void setSueldo(Double sueldo) {
		Sueldo = sueldo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}



}
