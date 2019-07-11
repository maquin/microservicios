package com.springboot.api.jdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.api.jdbc.model.Persona;

public class PersonaRowMapper implements RowMapper<Persona>{

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		Persona persona = new Persona();
		
		persona.setId(rs.getInt("id"));
		persona.setNombres(rs.getString("nombres"));
		persona.setApellidoPaterno(rs.getString("apellidoPaterno"));
		persona.setApellidoMaterno(rs.getString("apellidoMaterno"));
		persona.setSexo(rs.getString("sexo"));
		persona.setDireccion(rs.getString("direccion"));
		persona.setEstadoCivil(rs.getString("estadoCivil"));
		
		return persona;
	}

}
