package com.olmedo.evfinal.Controller;


import com.olmedo.evfinal.Repositories.EscuelaRepository;
import com.olmedo.evfinal.Repositories.ExpedienteRepository;
import com.olmedo.evfinal.Services.ExpedienteService;
import com.olmedo.evfinal.domain.Escuela;
import com.olmedo.evfinal.domain.Expediente;
import com.olmedo.evfinal.domain.Municipio;
import com.olmedo.evfinal.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.util.List;

@Controller
public class CoordinadorController {
    @Autowired
    EscuelaRepository escuelaRepository;
    @Autowired
    ExpedienteRepository expedienteRepository;
    @Autowired
    ExpedienteService expedienteService;

    @RequestMapping("/coordinador/inicio")
    public ModelAndView coordinadorInicio(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/Coordinador/BuscarExpediente");
        return mav;
    }
    @RequestMapping("/coordinador/editExpediente")
    public ModelAndView nuevoExpediente(){
        List<Escuela> escuelas = escuelaRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("flag",true);
        mav.addObject("expediente", new Expediente());
        mav.addObject("escuelas", escuelas);
        mav.setViewName("/Coordinador/editExpediente");
        return mav;
    }
    @RequestMapping("/coordinador/editExpediente/id/{idExpediente}")
    public ModelAndView editarExpediente(@PathVariable("idExpediente") int idExpediente){
        Expediente ex = expedienteRepository.getOne(idExpediente);
        List<Escuela> escuelas = escuelaRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("flag",false);
        mav.addObject("expediente", ex);
        mav.addObject("escuelas", escuelas);
        mav.setViewName("/Coordinador/editExpediente");
        return mav;
    }

    //POSTS
    @PostMapping("/coordinador/post/editExpediente")
    public RedirectView postExpediente(Expediente expediente) throws ParseException {
        expedienteRepository.save(expediente);
        return new RedirectView("/coordinador/Expedientes");
    }

    @PostMapping("/coordinador/post/filtrarExpedientes")
    public ModelAndView filtrarExp(@RequestParam Integer tipo, @RequestParam String valor) throws ParseException {
        List<Expediente> expedienteList = expedienteService.getByQuery(tipo, valor);
        ModelAndView mav = new ModelAndView();
        mav.addObject("expedientes", expedienteList);
        mav.setViewName("/Coordinador/displayExpedienteFiltrado");
        return mav;
    }
}
