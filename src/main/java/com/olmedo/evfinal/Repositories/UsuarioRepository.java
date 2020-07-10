package com.olmedo.evfinal.Repositories;

import com.olmedo.evfinal.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
    public Usuario findByNombreUsuarioAndContrasennia(String username, String contrasennia);
}
