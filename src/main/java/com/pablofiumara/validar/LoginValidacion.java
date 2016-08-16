package com.pablofiumara.validar;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.pablofiumara.formulario.*;


public class LoginValidacion {

  public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
    return LoginFormulario.class.equals(clazz);
  }

  public void validar(Object obj, Errors e) {
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "usuario", "errorUsuario");
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "contraseña", "errorContraseña");
  }
}