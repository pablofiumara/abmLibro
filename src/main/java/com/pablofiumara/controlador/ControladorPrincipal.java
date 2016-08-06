package com.pablofiumara.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pablofiumara.modelo.Libro;
import com.pablofiumara.servicio.LibroServicio; //importo la interfaz

@Controller
public class ControladorPrincipal {

	@Autowired
	private LibroServicio libroServicio;

	@RequestMapping(value = "/mostrarLibros")
	public ModelAndView buscarLibros() {
		ModelAndView modeloYVista = new ModelAndView("lista-de-libros");

		List<Libro> libros = libroServicio.buscarLibros();
		modeloYVista.addObject("listaLibros", libros);

		return modeloYVista;
	}

	@RequestMapping(value = "/")
	public String home(Model model) {
		return "index";
	}

	@RequestMapping(value="/agregar", method=RequestMethod.GET)
	public ModelAndView agregoLibroPagina() {
		ModelAndView modelAndView = new ModelAndView("agregar-libro-formulario");
		modelAndView.addObject("unLibro", new Libro());
		return modelAndView;
	}

	@RequestMapping(value="/agregarLibro", method=RequestMethod.POST)
	public ModelAndView agregoLibro(@ModelAttribute Libro unLibro) {

		ModelAndView modelAndView = new ModelAndView("libro-agregado");
		libroServicio.agregoLibro(unLibro);

		String mensaje = "El nuevo libro se ha agregado";
		modelAndView.addObject("unMensaje", mensaje);

		return modelAndView;
	}

	@RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
	public ModelAndView borrarLibro(@PathVariable Integer id) {
		ModelAndView modeloYVista = new ModelAndView("libro-borrado");
		libroServicio.borrarUnLibro(id);
		String mensaje = "El libro se ha borrado";
		modeloYVista.addObject("unMensaje", mensaje);
		return modeloYVista;
	}
}
