package com.pablofiumara.servicio;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablofiumara.dao.LibroDAO;
import com.pablofiumara.modelo.Libro;

@Service
public class LibroServicioImpl implements LibroServicio {

	@Autowired
	private LibroDAO libroDAO;


	@Transactional
	public List<Libro> buscarLibros() {
		return libroDAO.buscarLosLibros();
	}

}
