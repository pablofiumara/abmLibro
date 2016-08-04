package com.pablofiumara.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.pablofiumara.modelo.Libro;
import com.pablofiumara.servicio.LibroServicio; //importo la interfaz

@Controller
public class ControladorPrincipal {

 @Autowired
 private LibroServicio libroServicio;

 @RequestMapping(value="/mostrarLibros")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("listaDeLibros");

		List<Libro> teams = libroServicio.getTeams();
		modelAndView.addObject("teams", teams);

		return modelAndView;
	}

 @RequestMapping(value="/")
 public String home(Model model) {
     return "index";
 }



 @RequestMapping(value = "/libros/agregar", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario() {
	    return new ModelAndView("agregarLibro", "libro", new Libro());
  }




}