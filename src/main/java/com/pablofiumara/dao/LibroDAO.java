package com.pablofiumara.dao;

import java.util.List;

import com.pablofiumara.modelo.Libro;

public interface LibroDAO {

  public List<Libro> mostrarLosLibros() ;

  public Integer getMaxId();

  public void agregarLibro(String unTitulo);
}