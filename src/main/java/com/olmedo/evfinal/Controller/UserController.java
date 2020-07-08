package com.olmedo.evfinal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olmedo.evfinal.Repositories.UsuarioRepository;
import com.olmedo.evfinal.Services.MunicipioService;
import com.olmedo.evfinal.Services.UsuarioService;
import com.olmedo.evfinal.domain.Municipio;
import com.olmedo.evfinal.domain.Usuario;

@Controller
public class UserController {
	
	@Autowired
	MunicipioService municipioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping("/Login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario());
		mav.setViewName("displayLogin");
		return mav;
	}
	
	@RequestMapping("/insertUser")
	public ModelAndView newUser(Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		usuarioRepository.save(usuario);
		mav.addObject("usuario", new Usuario());
		mav.setViewName("displayNewUser");
		return mav;
	}
	
	@GetMapping("/form")
	public ModelAndView form() {
		List<Municipio> Municipios = municipioService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario());
		mav.addObject("municipio", Municipios);
		mav.setViewName("displayNewUser");
		return mav;
	} 
	
	
	
}
