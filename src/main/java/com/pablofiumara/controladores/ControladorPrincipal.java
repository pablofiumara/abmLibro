package com.pablofiumara.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pablofiumara.dao.LibroDAO;
import com.pablofiumara.entity.Libro;

@Controller
public class ControladorPrincipal {

 @Autowired
 private LibroDAO LibroDAO;

 @RequestMapping({ "/", "/home" })
 public String home(Model model) {
     return "index";
 }

 @RequestMapping({ "/libros/mostrar" })
 public String mostrarLibros(Model model) {
     LibroDAO.agregarLibro("titulo del libro");

     List<Libro> lista = LibroDAO.mostrarLosLibros();

     model.addAttribute("listaDeLibros", lista);
     return "mostrarlibros";
 }

 @RequestMapping(value = "/libros/agregar", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario() {
	    return new ModelAndView("agregarLibro", "libro", new Libro());
  }


 @RequestMapping(value = "/libros/agregado", method = RequestMethod.POST)
 public String agregarLibros(@ModelAttribute("libro") final Libro libro, final BindingResult resultado, final ModelMap modelo) {
     if (resultado.hasErrors()) {
         return "error";
     }

     this.LibroDAO.agregarLibro("un nuevo libro");
     modelo.addAttribute("titulo", libro.getTitulo());
     return "libroAgregado";
 }

}