package com.pablofiumara.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pablofiumara.bean.Student;

@Controller
@RequestMapping("/pdf")
public class ControladorPDF {

	@Autowired
	private Student student;	

	@RequestMapping("/rich")
	public ModelAndView beanToPdf() {
		ModelAndView m = new ModelAndView("richStudPdfView");
		student.setName("Braxton Miller");
		m.getModelMap().addAttribute("stud", student);
		return m;
	}

}