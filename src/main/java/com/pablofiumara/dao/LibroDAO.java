package com.pablofiumara.dao;

import java.util.List;

import com.pablofiumara.modelo.Libro;


public interface LibroDAO {

  public List<Libro> buscarLosLibros();
	public void addTeam(Libro team);

}