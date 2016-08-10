package com.pablofiumara.formulario;

import javax.validation.constraints.NotNull;

public class RegistrationForm {


  @NotNull
  private String titulo;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}