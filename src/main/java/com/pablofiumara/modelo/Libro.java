package com.pablofiumara.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libro {


	private String titulo; //este atributo puede estar escrito primero y no ser el 'primary key'

	@Id
	@GeneratedValue
	private int id;



	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String unTitulo) {
		this.titulo = unTitulo;
	}


}