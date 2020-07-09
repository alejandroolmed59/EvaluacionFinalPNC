package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.domain.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	public Optional<Usuario> findByUsername(String nombreUsuario);
}
