package com.pablofiumara.servicio;

import java.util.List;

import com.pablofiumara.modelo.Libro;


public interface LibroServicio {


	public List<Libro> buscarLibros();
	//no es necesario que los parámetros de los métodos de la interfaz y de su implementación se llamen igual
	public void agregoLibro(Libro unLibroNuevo);
	public Libro buscarUnLibro(int id);
	public void deleteTeam(int id);



}
