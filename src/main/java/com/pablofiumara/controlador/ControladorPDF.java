package com.pablofiumara.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pablofiumara.bean.Student;

@Controller
public class ControladorPDF {

	@Autowired
	private Student student;	

	@RequestMapping("/lista-libros.pdf")
	public ModelAndView listaLibrosAPDF() {
		ModelAndView m = new ModelAndView("pdfLibros");
		student.setName("Braxton Miller");
		m.getModelMap().addAttribute("listaLibros", student);
		return m;
	}

}