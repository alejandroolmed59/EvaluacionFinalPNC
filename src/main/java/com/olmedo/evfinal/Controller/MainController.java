package com.olmedo.evfinal.Controller;

import com.olmedo.evfinal.Services.MunicipioService;
import com.olmedo.evfinal.domain.Escuela;
import com.olmedo.evfinal.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MunicipioService municipioService;

    @RequestMapping("/index")
    public ModelAndView prueba(){
        List<Municipio> listaMunicipios = municipioService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("escuela", new Escuela());
        mav.addObject("municipios", listaMunicipios);
        mav.setViewName("catalogoMaterias");
        return mav;
    }
    @PostMapping("/postprueba")
    public void proc(Escuela escuela){
        System.out.println(escuela.getNombre()+" "+ escuela.getDescripcion()+" "+escuela.getIdMunicipio() +" "+escuela.isEstado());
    }
}
