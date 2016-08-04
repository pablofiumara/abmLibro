package com.pablofiumara.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Libros")
public class Libro {

	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;

    @Column(name="titulo")
	private String titulo;


	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String name) {
		this.titulo = name;
	}


}