package com.springboot.api.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.jdbc.model.Persona;
import com.springboot.api.jdbc.service.impl.PersonaServiceImpl;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaServiceImpl _personaService;
	
	@GetMapping(value = "/", produces = "application/json")	
	public List<Persona> getAllPersonas(){
		return _personaService.getAllPersonas();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")	
	public Persona getPersona(@PathVariable ("id") Integer id){
		return _personaService.getPersona(id);
	}
	
	@PostMapping(value = "/", produces = "application/json")	
	public List<Persona> savePersona(@RequestBody Persona persona){
		
		_personaService.savePersona(persona);
		
		return _personaService.getAllPersonas();
	}	
	
	@DeleteMapping(value = "/{id}", produces = "application/json")	
	public List<Persona> deletePersona(@PathVariable ("id") Integer id){
		
		_personaService.deletePersona(id);
		
		return _personaService.getAllPersonas();
	}	

}
