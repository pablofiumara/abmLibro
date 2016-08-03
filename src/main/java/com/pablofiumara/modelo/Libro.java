package com.pablofiumara.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Libros")
public class Libro {

   private Integer Id;
   private String titulo;


   public Libro() {
   }

   public Libro(Integer unId, String unTitulo) {
       this.Id = unId;
       this.titulo = unTitulo;
   }

   @Id
   @Column(name = "numeroDeId", nullable = false)
   public Integer getId() {
       return Id;
   }

   public void setId(Integer id) {
       this.Id = id;
   }

   @Column(name = "tituloDelLibro", length = 20)
   public String getTitulo() {
       return titulo;
   }

   public void setTitulo(String unTitulo) {
       this.titulo = unTitulo;
   }
}