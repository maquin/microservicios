package com.springboot.api.jdbc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Persona {
	
	private Integer id;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	@JsonIgnore
	private String sexo;
	private String direccion;
	private String estadoCivil;
		
	public Persona() {
		
	}
	
	public Persona(Integer id, String nombres, String apellidoPaterno, String apellidoMaterno, String sexo,
			String direccion, String estadoCivil) {
	
		this.id = id;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.sexo = sexo;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno
				+ ", apellidoMaterno=" + apellidoMaterno + ", sexo=" + sexo + ", direccion=" + direccion
				+ ", estadoCivil=" + estadoCivil + "]";
	}
	
}
