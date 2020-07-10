package com.olmedo.evfinal.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.olmedo.evfinal.Repositories.DepartamentoRepository;
import com.olmedo.evfinal.domain.Departamento;

@Service
public class DepartamentoServiceIMP implements DepartamentoService{
	
	@Autowired
	DepartamentoRepository departamentoRepository;

    @PersistenceContext(unitName = "modelo-persistence")
    EntityManager entityManager;
	
	@Override
	public List<Departamento> findAllDepartamentos() throws DataAccessException {
		// TODO Auto-generated method stub
		return departamentoRepository.findAllDepartamentos();
	}

}
