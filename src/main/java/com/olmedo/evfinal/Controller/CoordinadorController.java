package com.olmedo.evfinal.Controller;


import com.olmedo.evfinal.Repositories.EscuelaRepository;
import com.olmedo.evfinal.Repositories.ExpedienteRepository;
import com.olmedo.evfinal.Repositories.MateriaRepository;
import com.olmedo.evfinal.Services.ExpedienteService;
import com.olmedo.evfinal.ViewModels.ExpedienteMateriaClase;
import com.olmedo.evfinal.ViewModels.ExpedienteXmateria;
import com.olmedo.evfinal.ViewModels.NotasAlumno;
import com.olmedo.evfinal.config.Sesion;
import com.olmedo.evfinal.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CoordinadorController {
    @Autowired
    EscuelaRepository escuelaRepository;
    @Autowired
    ExpedienteRepository expedienteRepository;
    @Autowired
    ExpedienteService expedienteService;
    @Autowired
    MateriaRepository materiaRepository;

    @RequestMapping("/coordinador/index")
    public ModelAndView index() {
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("nombreCoord", sesion.getUsuario().getNombre());
        mav.setViewName("/Coordinador/index");
        return mav;
    }

    @RequestMapping("/coordinador/filtrar")
    public ModelAndView coordinadorInicio(){
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/Coordinador/BuscarExpediente");
        return mav;
    }
    @RequestMapping("/coordinador/editExpediente")
    public ModelAndView nuevoExpediente(){
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        List<Escuela> escuelas = escuelaRepository.findAllByMunicipio_IdMunicipioAndEstado(sesion.getUsuario().getMunicipio().getIdMunicipio(), true);
        ModelAndView mav = new ModelAndView();
        mav.addObject("flag",true);
        mav.addObject("expediente", new Expediente());
        mav.addObject("escuelas", escuelas);
        mav.setViewName("/Coordinador/editExpediente");
        return mav;
    }
    @RequestMapping("/coordinador/editExpediente/id/{idExpediente}")
    public ModelAndView editarExpediente(@PathVariable("idExpediente") int idExpediente){
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        Expediente ex = expedienteRepository.getOne(idExpediente);
        List<Escuela> escuelas = escuelaRepository.findAllByMunicipio_IdMunicipioAndEstado(sesion.getUsuario().getMunicipio().getIdMunicipio(), true);

        ModelAndView mav = new ModelAndView();
        mav.addObject("flag",false);
        mav.addObject("expediente", ex);
        mav.addObject("escuelas", escuelas);
        mav.setViewName("/Coordinador/editExpediente");
        return mav;
    }

    @RequestMapping("/coordinador/Materias/id/{idExpediente}")
    public ModelAndView materiasCursadas(@PathVariable("idExpediente") int idExpediente){
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        Expediente ex = expedienteRepository.getOne(idExpediente);
        ModelAndView mav = new ModelAndView();
        List<ExpedienteXmateria> emList = expedienteRepository.obtenerMateriasDeExpediente(idExpediente);
        mav.addObject("expediente", ex);
        mav.addObject("materias", emList);
        mav.setViewName("/Coordinador/displayMateriasCursadas");
        return mav;
    }

    @RequestMapping("/coordinador/editMateria/id/{id}")
    public ModelAndView editmateriasCursadas(@PathVariable("id") int id){
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        List<Materia> materias = materiaRepository.findAllOrdenado();
        ModelAndView mav = new ModelAndView();
        mav.addObject("materias", materias);
        mav.addObject("modelo", new ExpedienteMateriaClase(id, 1));
        mav.setViewName("/Coordinador/editMateriaCursada");
        return mav;
    }
    @RequestMapping("/coordinador/nueva/Materia/id/{idExpediente}")
    public ModelAndView nuevaMateriaCursada(@PathVariable("idExpediente") int idExpediente){
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        Expediente ex = expedienteRepository.getOne(idExpediente);
        ModelAndView mav = new ModelAndView();

        List<Materia> materias = materiaRepository.findAllOrdenado();
        mav.addObject("expediente", ex);
        mav.addObject("materias", materias);
        mav.addObject("modelo", new ExpedienteMateriaClase(ex.getIdExpediente()));
        mav.setViewName("/Coordinador/nuevaMateriaCursada");
        return mav;
    }

    @RequestMapping("/coordinador/materiascursadas")
    public ModelAndView MateriasCursadas() throws ParseException {
        Sesion sesion = Sesion.getSesion();
        if(sesion==null || sesion.getUsuario()==null || sesion.getUsuario().isAdmin()){
            return new ModelAndView( "redirect:/login");
        }
        List<Expediente> expedienteList = expedienteService.findAll();
        List<NotasAlumno> vistaAlumnos = new ArrayList<>();
        for (Expediente alumno:expedienteList) {
            NotasAlumno alumnoVista = expedienteService.getResultados(alumno.getIdExpediente());
            alumnoVista.setApellido(alumno.getApellido());
            alumnoVista.setNombre(alumno.getNombre());
            alumnoVista.setIdExpediente(alumno.getIdExpediente());
            vistaAlumnos.add(alumnoVista);
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("expedientes", vistaAlumnos);
        mav.addObject("titulo","Informacion de materias");
        mav.setViewName("/Coordinador/displayExpedienteFiltrado");
        return mav;
    }

    //POSTS
    /*
    @PostMapping("/coordinador/post/editExpediente")
    public RedirectView postExpediente(Expediente expediente) throws ParseException {
        System.out.println(expediente.getEdad1Delegate());
        expediente.setEdad(expediente.getEdad1Delegate());
        expedienteRepository.save(expediente);
        return new RedirectView("/coordinador/index");
    }
    */

    @PostMapping("/coordinador/post/editExpediente")
    public RedirectView postExpediente(@Valid @ModelAttribute("expediente") Expediente expediente, BindingResult result){
        if(result.hasErrors()) {
            for (ObjectError error:result.getAllErrors()) {
                System.out.println(error.toString());
            }
            System.out.println("entro chale");
            return new RedirectView("redirect:/coordinador/editExpediente");
        }
        else{
            System.out.println(expediente.getEdad1Delegate());
            expediente.setEdad(expediente.getEdad1Delegate());
            expedienteRepository.save(expediente);
            return new RedirectView("/coordinador/index");
        }

    }
    @PostMapping("/coordinador/post/filtrarExpedientes")
    public ModelAndView filtrarExp(@RequestParam Integer tipo, @RequestParam String valor) throws ParseException {
        List<Expediente> expedienteList = expedienteService.getByQuery(tipo, valor);
        List<NotasAlumno> vistaAlumnos = new ArrayList<>();
        for (Expediente alumno:expedienteList) {
            NotasAlumno alumnoVista = expedienteService.getResultados(alumno.getIdExpediente());
            alumnoVista.setApellido(alumno.getApellido());
            alumnoVista.setNombre(alumno.getNombre());
            alumnoVista.setIdExpediente(alumno.getIdExpediente());
            vistaAlumnos.add(alumnoVista);
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("titulo","Expedientes filtrados");
        mav.addObject("expedientes", vistaAlumnos);
        mav.setViewName("/Coordinador/displayExpedienteFiltrado");
        return mav;
    }

    @PostMapping("/coordinador/post/nueva/Materia")
    public RedirectView filtrarExp(ExpedienteMateriaClase emc)  {
        try{
            expedienteRepository.guardarMateria(emc.getIdexpediente(), emc.getIdmateria(), emc.getCiclo(), emc.getAnnio(), emc.getNota());
        }catch(Exception e){
            return new RedirectView("/coordinador/Materias/id/"+emc.getIdexpediente());
        }
        return new RedirectView("/coordinador/Materias/id/"+emc.getIdexpediente());
    }




    @PostMapping("/coordinador/post/edit/Materia")
    public RedirectView editMateria(ExpedienteMateriaClase emc)  {
        System.out.println(emc.getIdmateria()+" "+ emc.getIdmateria()+" "+emc.getId());
        try{
            expedienteRepository.editMateria( emc.getIdmateria(), emc.getCiclo(), emc.getAnnio(), emc.getNota(), emc.getId());
        }catch(Exception e){
            return new RedirectView("/coordinador/materiascursadas/");
        }
        return new RedirectView("/coordinador/materiascursadas/");
    }


}
