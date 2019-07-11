package com.springboot.api.jdbc.service;

import java.util.List;

import com.springboot.api.jdbc.model.Persona;

public interface PersonaService {
	
	List<Persona> getAllPersonas();
	Persona getPersona(Integer id);
	void savePersona(Persona persona);
	void deletePersona(Integer id);
	
}
