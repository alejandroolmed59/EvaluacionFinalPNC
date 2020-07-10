package com.olmedo.evfinal.Controller;

import java.text.ParseException;
import java.util.List;

import com.olmedo.evfinal.config.Sesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
		mav.addObject("error", false);
		mav.addObject("error2", false);
		mav.setViewName("Autenticacion/Login");
		return mav;
	}
	
	@RequestMapping("/menu")
	public ModelAndView menu(Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("error2",false);
		mav.addObject("error", true);
		Usuario user = usuarioRepository.findByNombreUsuarioAndContrasennia(usuario.getNombreUsuario(), usuario.getContrasennia());
		if(user!=null){
			if(user.isEstado()){
				Sesion sesion = Sesion.setSesion(user);
				if(sesion.getUsuario().isAdmin())  return new ModelAndView( "redirect:/admin/index");
				else return new ModelAndView( "redirect:/coordinador/index");
			}else{
				mav.addObject("error2",true);
				mav.addObject("error", false);
			}
		}
		mav.addObject("usuario", new Usuario());

		mav.setViewName("Autenticacion/Login");
		return mav;
	}
	@RequestMapping("/cerrarSesion")
	public ModelAndView cerrarSesion() {
		Sesion sesion = Sesion.setSesion(null);
		return new ModelAndView( "redirect:/login");
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
	public ModelAndView insertarUser(@Valid @ModelAttribute Usuario usuario, BindingResult result){
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
