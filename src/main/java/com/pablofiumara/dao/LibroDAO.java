package com.pablofiumara.dao;

import java.util.List;

import com.pablofiumara.modelo.Libro;


public interface LibroDAO {

	public List<Libro> buscarLosLibros();

	//no es necesario que el nombre de este parámetro sea igual al nombre del parámetro de su implementacion
	public void agregarUnLibro(Libro libro);

}
