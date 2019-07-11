package com.springboot.api.jdbc.dao;

import java.util.List;

import com.springboot.api.jdbc.model.Persona;

public interface PersonaDao {
	
	List<Persona> getAllPersonas();
	Persona getPersona(Integer id);
	void savePersona(Persona persona);
	void deletePersona(Integer id);

}
