package com.pablofiumara.formulario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Basic Registration Form with JSR-303 Validation
 *
 * @author Bubba Hines <bubba@hines57.com>
 * @since 0.02
 */
public class RegistrationForm {


  @NotNull(message = "User Name field is mandatory.")
  private String titulo;

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}