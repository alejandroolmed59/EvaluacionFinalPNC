package com.olmedo.evfinal.Repositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.olmedo.evfinal.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

	@Query(value = "SELECT * from public.Departamento ORDER BY idDepartamento ASC", nativeQuery = true)
	public List<Departamento> findAllDepartamentos() throws DataAccessException;
}
