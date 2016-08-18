package com.pablofiumara.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.pablofiumara.modelo.Libro;
import com.pablofiumara.servicio.LibroServicio;

@Controller
public class ControladorPDF {		
	
	@Autowired
	private LibroServicio libroServicio;

	@RequestMapping("/lista-libros.pdf")
	public ModelAndView listaLibrosAPDF() {
		ModelAndView m = new ModelAndView("pdfLibros");
		
		List<Libro> libros = libroServicio.buscarLibros();
		m.getModelMap().addAttribute("listaLibros", libros);
				
		
		return m;
	}

}