package com.pablofiumara.controlador;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pablofiumara.modelo.Libro;
import com.pablofiumara.servicio.LibroServicio; //importo la interfaz
import com.pablofiumara.validator.*;

@Controller
public class ControladorPrincipal {

	@Autowired
	private LibroServicio libroServicio;

	private Validator validator;

	public Validator getValidator() {
	    return validator;
	}

	@Autowired
	public void setValidator(Validator validator) {
	    this.validator = validator;
	}

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
	public ModelAndView agregoLibro(@ModelAttribute(value = "unLibro") @Valid Libro unLibro, BindingResult resultado) {

		AgregarLibroValidacion validacion = new AgregarLibroValidacion();
		validacion.validar(unLibro, resultado);

		if (resultado.hasErrors()) {
			ModelAndView modeloYVista = new ModelAndView("agregar-libro-formulario");
		      return modeloYVista;
		}


		ModelAndView modeloYVista = new ModelAndView("libro-agregado");
		libroServicio.agregoLibro(unLibro);

		String mensaje = "El nuevo libro se ha agregado";
		modeloYVista.addObject("unMensaje", mensaje);

		return modeloYVista;
	}

	@RequestMapping(value="/borrar/{id}", method=RequestMethod.GET)
	public ModelAndView borrarLibro(@PathVariable Integer id) {
		ModelAndView modeloYVista = new ModelAndView("libro-borrado");
		libroServicio.borrarUnLibro(id);
		String mensaje = "El libro se ha borrado";
		modeloYVista.addObject("unMensaje", mensaje);
		return modeloYVista;
	}

	@RequestMapping(value="/modificar/{id}", method=RequestMethod.GET)
	public ModelAndView modificoLibroPagina(@PathVariable Integer id) {
		ModelAndView modeloYVista = new ModelAndView("modificar-libro-formulario");
		Libro libro = libroServicio.buscarUnLibro(id);
		modeloYVista.addObject("unLibro",libro);
		return modeloYVista;
	}

	@RequestMapping(value="/modificar/{id}", method=RequestMethod.POST)
	public ModelAndView modificarPagina(@ModelAttribute Libro libro, @PathVariable Integer id) {

		ModelAndView modeloYVista = new ModelAndView("libro-modificado");

		libroServicio.modificarLibro(libro);
		String mensaje = "El libro se ha editado correctamente";
		modeloYVista.addObject("unMensaje", mensaje);

		return modeloYVista;
	}
}
