package com.pablofiumara.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pablofiumara.bean.Student;

@Controller
@RequestMapping("/pdf")
public class StudentController {

	@Autowired
	private Student student;

	@RequestMapping(value = "/html", produces = "application/xml")
	public String html(Model model) {
		student.setName("Corey Brown");
		model.addAttribute("stud", student);
		return "studentPage";
	}

	@RequestMapping("/rich")
	public ModelAndView beanToPdf() {
		ModelAndView m = new ModelAndView("richStudPdfView");
		student.setName("Braxton Miller");
		m.getModelMap().addAttribute("stud", student);
		return m;
	}

}