package com.pablofiumara.controladores;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

 @RequestMapping({ "/libros/agregar" })
 public String agregarLibros(Model model) {
     return "agregarLibro";
 }
}