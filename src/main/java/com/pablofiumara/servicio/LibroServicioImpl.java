package com.pablofiumara.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pablofiumara.dao.LibroDAO;
import com.pablofiumara.modelo.Libro;

@Service
public class LibroServicioImpl implements LibroServicio {

	@Autowired
	private LibroDAO libroDAO;

	public LibroDAO getLibroDAO() {
	        return libroDAO;
	}

	public void setLibroDAO(LibroDAO libroDAO) {
	        this.libroDAO = libroDAO;
	}

	public List<Libro> buscarLibros() {
		return libroDAO.buscarLosLibros();
	}


	public boolean agregoLibro(Libro unLibro) {
		return libroDAO.agregarUnLibro(unLibro);
	}


	public Libro buscarUnLibro(int id) {
		return libroDAO.buscarLibro(id);
	}


	public void borrarUnLibro(int id) {
		libroDAO.borrarLibro(id);
	}

	public void modificarLibro(Libro unLibro) {
		libroDAO.modificarLibro(unLibro);
	}

}
