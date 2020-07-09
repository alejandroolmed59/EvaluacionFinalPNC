package com.olmedo.evfinal.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.olmedo.evfinal.Repositories.UsuarioRepository;
import com.olmedo.evfinal.Services.MunicipioService;
import com.olmedo.evfinal.domain.Municipio;
import com.olmedo.evfinal.domain.Usuario;

import javax.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	MunicipioService municipioService;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping({"/login", "/"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario());
		mav.setViewName("Autenticacion/Login");
		return mav;
	}
	
	@RequestMapping("/menu")
	public ModelAndView menu() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Autenticacion/menu");
		return mav;
	}
	
	@RequestMapping("/Coordinador")
	public ModelAndView coor() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Autenticacion/Coordinador");
		return mav;
	}
	

	@RequestMapping("/Admin")
	public ModelAndView adm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Autenticacion/Administrador");
		return mav;
	}
/*
	@RequestMapping("/insertUser")
	public ModelAndView newUser(Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		usuarioRepository.save(usuario);
		mav.addObject("usuario", new Usuario());
		mav.setViewName("Autenticacion/Login");
		return mav;
	}

*/
	@RequestMapping("/insertUser")
	public ModelAndView insertarLibro(@Valid @ModelAttribute Usuario usuario, BindingResult result){
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			List<Municipio> Municipios = municipioService.findAll();
			mav.addObject("municipio", Municipios);
			mav.setViewName("Autenticacion/Registrarse");
		}
		else{
			try {
				usuarioRepository.save(usuario);
				mav.addObject("usuario", new Usuario());
				mav.setViewName("Autenticacion/Registrarse");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mav;
	}
	
	@GetMapping("/form")
	public ModelAndView form() {
		List<Municipio> Municipios = municipioService.findAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("usuario", new Usuario());
		mav.addObject("municipio", Municipios);
		mav.setViewName("Autenticacion/Registrarse");
		return mav;
	}
	
}
