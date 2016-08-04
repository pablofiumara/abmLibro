package com.pablofiumara.service;

import java.util.List;

import com.pablofiumara.modelo.Libro;


public interface LibroServicio {

	public void agregarLibro(Libro unLibro);
	public void editarLibro(Libro unLibro);
	public Libro buscarLibro(int unId);
	public void borrarLibro(int unId);
	public List<Libro> listarLibros();
	public List<Libro> getTeams();

}