package com.olmedo.evfinal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olmedo.evfinal.Repositories.UsuarioRepository;
import com.olmedo.evfinal.domain.Usuario;

@Controller
public class UserController {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping("/home")
	public ModelAndView login() {
		Usuario user = new Usuario();
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", user);
		mav.setViewName("displayLogin");
		return mav;
	}
	
	
	
}
