package com.pablofiumara.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablofiumara.dao.LibroDAO;
import com.pablofiumara.modelo.Libro;

@Service
@Transactional
public class LibroServicioImpl implements LibroServicio {

	@Autowired
	private LibroDAO libroDAO;

	public void agregarLibro(Libro unLibro) {
		libroDAO.agregarLibro(unLibro);
	}

	public void editarLibro(Libro unLibro) {
		libroDAO.editarLibro(unLibro);
	}

	public Libro buscarLibro(int unId) {
		return libroDAO.buscarLibro(unId);
	}

	public void borrarLibro(int unId) {
		libroDAO.borrarLibro(unId);
	}

	public List<Libro> listarLibros() {
		return libroDAO.listarLibros();
	}
	
	public List<Libro> getTeams() {
		return libroDAO.getTeams();
	}

}
