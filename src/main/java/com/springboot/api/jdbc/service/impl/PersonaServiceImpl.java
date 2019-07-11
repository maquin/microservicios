package com.springboot.api.jdbc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.jdbc.dao.impl.PersonaDaoImpl;
import com.springboot.api.jdbc.model.Persona;
import com.springboot.api.jdbc.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonaDaoImpl _personalDao;
	
	@Override
	public List<Persona> getAllPersonas() {
		
		return _personalDao.getAllPersonas();
	}

	@Override
	public Persona getPersona(Integer id) {
		
		return _personalDao.getPersona(id);
	}

	@Override
	public void savePersona(Persona persona) {
		try {
			_personalDao.savePersona(persona);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}	
	}

	@Override
	public void deletePersona(Integer id) {
		try {
			_personalDao.deletePersona(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}

}
