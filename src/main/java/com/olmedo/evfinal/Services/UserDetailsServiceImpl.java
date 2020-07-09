package com.olmedo.evfinal.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.olmedo.evfinal.Repositories.UsuarioRepository;
import com.olmedo.evfinal.domain.Autorithy;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		
    //Buscar el usuario con el repositorio y si no existe lanzar una exepcion
    com.olmedo.evfinal.domain.Usuario appUser = 
                usuarioRepository.findByUsername(nombreUsuario).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		
   //Mapear nuestra lista de Authority con la de spring security 
   List grantList = new ArrayList();
   for (Autorithy autorithy: appUser.getAutorithy()) {
       
       GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(autorithy.getAuthority());
           grantList.add(grantedAuthority);
   }
		
   UserDetails user = (UserDetails) new User (appUser.getNombreUsuario(), appUser.getContrasennia(), grantList);
        return user;
   }
	
	
}
