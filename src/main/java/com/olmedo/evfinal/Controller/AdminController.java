package com.olmedo.evfinal.Controller;

import com.olmedo.evfinal.Repositories.EscuelaRepository;
import com.olmedo.evfinal.Repositories.MateriaRepository;
import com.olmedo.evfinal.Repositories.UsuarioRepository;
import com.olmedo.evfinal.Services.MunicipioService;
import com.olmedo.evfinal.domain.Escuela;
import com.olmedo.evfinal.domain.Materia;
import com.olmedo.evfinal.domain.Municipio;
import com.olmedo.evfinal.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private EscuelaRepository escuelaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @RequestMapping("/admin/Usuarios")
    public ModelAndView usuarios(){
        if(1==1){
            return new ModelAndView( "redirect:/login");
        }
        List<Usuario> listUsers = usuarioRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("usuarios", listUsers);
        mav.setViewName("displayUsuarios");
        return mav;
    }

    @RequestMapping("/admin/editUsuario")
    public ModelAndView nuevoUsuario(){
        List<Municipio> listaMunicipios = municipioService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("usuario", new Usuario());
        mav.addObject("municipios", listaMunicipios);
        mav.setViewName("editUsuario");
        return mav;
    }

    @RequestMapping("/admin/editUsuario/id/{idUsuario}")
    public ModelAndView editUsuario(@PathVariable("idUsuario") int idUsuario){

        Usuario user = usuarioRepository.getOne(idUsuario);
        List<Municipio> listaMunicipios = municipioService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("usuario", user);
        mav.addObject("municipios", listaMunicipios);
        mav.setViewName("editUsuario");
        return mav;
    }

    @RequestMapping("/admin/Escuelas")
    public ModelAndView escuelas(){
        List<Escuela> listEscuelas = escuelaRepository.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("escuelas", listEscuelas);
        mav.setViewName("displayEscuelas");
        return mav;
    }

    @RequestMapping("/admin/editEscuela")
    public ModelAndView nuevaEscuela(){
        List<Municipio> listaMunicipios = municipioService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("escuela", new Escuela());
        mav.addObject("municipios", listaMunicipios);
        mav.setViewName("editEscuela");
        return mav;
    }

    @RequestMapping("/admin/editEscuela/id/{idEscuela}")
    public ModelAndView editEscuela(@PathVariable("idEscuela") int idEscuela){
        Escuela escuela = escuelaRepository.getOne(idEscuela);
        List<Municipio> listaMunicipios = municipioService.findAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("escuela", escuela);
        mav.addObject("municipios", listaMunicipios);
        mav.setViewName("editEscuela");
        return mav;
    }


    @RequestMapping("/admin/Materias")
    public ModelAndView materias(){
        List<Materia> listaMaterias = materiaRepository.findAllOrdenado();
        ModelAndView mav = new ModelAndView();
        mav.addObject("materias", listaMaterias);
        mav.setViewName("displayMaterias");
        return mav;
    }
    @RequestMapping("/admin/editMaterias")
    public ModelAndView nuevaMateria(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("materia", new Materia());
        mav.setViewName("editMateria");
        return mav;
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

    // POST ROUTES
    @PostMapping("/admin/post/editMateria")
    public RedirectView postMateria(Materia materia){
        System.out.println(materia.getIdMateria());
        materiaRepository.save(materia);
        return new RedirectView("/admin/Materias");
    }
    @PostMapping("/admin/post/editEscuela")
    public RedirectView postEscuela(Escuela escuela){
        escuelaRepository.save(escuela);
        return new RedirectView("/admin/Escuelas");
    }

    @PostMapping("/admin/post/editUsuario")
    public RedirectView postUsuario(Usuario user) throws ParseException {
        usuarioRepository.save(user);
        return new RedirectView("/admin/Usuarios");
    }


    //OTROS METODOS
    /*public int obtenerEdad(Date fecha){
        LocalDate currentDate = new LocalDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
        if ((fecha != null) && (currentDate != null)) {
            return Period.between(fecha, currentDate).getYears();
        } else {
            return 0;
        }
    }*/
}
