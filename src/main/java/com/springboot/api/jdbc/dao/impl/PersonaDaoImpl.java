package com.springboot.api.jdbc.dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springboot.api.jdbc.dao.PersonaDao;
import com.springboot.api.jdbc.model.Persona;
import com.springboot.api.jdbc.rowmapper.PersonaRowMapper;

@Repository
public class PersonaDaoImpl extends JdbcDaoSupport implements PersonaDao {

	public PersonaDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public List<Persona> getAllPersonas() {
		
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		String sql = " SELECT id, nombres, apellidoPaterno, apellidoMaterno, sexo, direccion, estadoCivil\n" + 
				" FROM api_test.persona";
		
		try {
			
			RowMapper<Persona> personaRow = new PersonaRowMapper();
			listaPersonas = getJdbcTemplate().query(sql, personaRow);
			logger.debug("Se han listado "+listaPersonas.size()+" personas");
					
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return listaPersonas;
	}

	@Override
	public Persona getPersona(Integer id) {
		Persona persona = new Persona();	
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		String sql = " SELECT id, nombres, apellidoPaterno, apellidoMaterno, sexo, direccion, estadoCivil\n" + 
				" FROM api_test.persona where id='"+id+"'";
				
		try {
			
			RowMapper<Persona> personaRow = new PersonaRowMapper();
			listaPersonas = getJdbcTemplate().query(sql, personaRow);
			
			persona = listaPersonas.get(0);
			
			logger.debug("Se ha traido a la persona "+listaPersonas.get(0).toString());
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return persona;
	}

	@Override
	public void savePersona(Persona persona) {
		
		String sql = "insert into api_test.persona (nombres, apellidoPaterno, apellidoMaterno, sexo, direccion, estadoCivil) "  
				+ "values (?, ?, ?, ?, ?, ?);";
		
		Object[] params = { persona.getNombres(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), persona.getSexo(), persona.getDireccion(), persona.getEstadoCivil()};
		int[] tipos = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		
		try {
			
			int filas = getJdbcTemplate().update(sql, params,tipos);
			
			logger.debug("Se han insertado : "+filas+" filas");
			logger.debug("Se ha registrado a la persona "+persona.toString());
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void deletePersona(Integer id) {
		int regeliminados = 0;		
		String sql = " delete from persona where id ='"+id+"'";		
		try {			
			regeliminados = getJdbcTemplate().update(sql);
			logger.debug("Se han eliminado "+regeliminados+" persona con id = "+id);
		} catch (Exception e) {			
			logger.error(e.getMessage());
		}
	}

}
