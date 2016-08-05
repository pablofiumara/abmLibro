package com.pablofiumara.controlador;


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
	public ModelAndView buscarLibros() {
		ModelAndView modeloYVista = new ModelAndView("listaDeLibros");

		List<Libro> libros = libroServicio.getTeams();
		modeloYVista.addObject("listaLibros", libros);

		return modeloYVista;
	}

 @RequestMapping(value="/")
 public String home(Model model) {
     return "index";
 }
}