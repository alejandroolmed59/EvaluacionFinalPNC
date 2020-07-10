package com.olmedo.evfinal.Services;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.olmedo.evfinal.domain.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> findAllDepartamentos() throws DataAccessException;

}
