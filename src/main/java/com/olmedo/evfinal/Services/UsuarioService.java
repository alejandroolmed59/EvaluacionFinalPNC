package com.olmedo.evfinal.Services;

import org.springframework.dao.DataAccessException;

import com.olmedo.evfinal.domain.Usuario;

public interface UsuarioService {
	
	public void save(Usuario usuario) throws DataAccessException;

}
