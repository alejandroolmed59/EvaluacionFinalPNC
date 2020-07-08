package com.olmedo.evfinal.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.olmedo.evfinal.Repositories.UsuarioRepository;
import com.olmedo.evfinal.domain.Usuario;

public class UsuarioServiceIMP implements UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public void save(Usuario usuario) throws DataAccessException {
		usuarioRepository.save(usuario);
		
	}

}
