package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.domain.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
}
