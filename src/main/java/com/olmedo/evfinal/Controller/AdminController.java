package com.olmedo.evfinal.Controller;

import com.olmedo.evfinal.Repositories.MateriaRepository;
import com.olmedo.evfinal.Services.MunicipioService;
import com.olmedo.evfinal.domain.Escuela;
import com.olmedo.evfinal.domain.Materia;
import com.olmedo.evfinal.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private MateriaRepository materiaRepository;

    @RequestMapping("/admin/editEscuela")
    public ModelAndView escuela(){
        List<Municipio> listaMunicipios = municipioService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("escuela", new Escuela());
        mav.addObject("municipios", listaMunicipios);
        mav.setViewName("editEscuela");
        return mav;
    }
    @PostMapping("/admin/post/editMunicipio")
    public void proc(Materia escuela){
        System.out.println(escuela.getIdMateria()+" "+ escuela.getDescripcion()+" "+escuela.getMateria() +" "+escuela.isEstado());
    }
    @RequestMapping("/admin/editMaterias/id/{idMateria}")
    public ModelAndView editmateria(@PathVariable("idMateria") int idMateria){
        System.out.println(idMateria);
        Materia materia = materiaRepository.getOne(idMateria);
        ModelAndView mav = new ModelAndView();
        mav.addObject("materia", materia);
        mav.setViewName("editMateria");
        return mav;
    }
    @RequestMapping("/admin/editMaterias")
    public ModelAndView nuevaMateria(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("materia", new Materia());
        mav.setViewName("editMateria");
        return mav;
    }
    @RequestMapping("/admin/Materias")
    public ModelAndView materias(){
        List<Materia> listaMaterias = materiaRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("materias", listaMaterias);
        mav.setViewName("display");
        return mav;
    }
}
