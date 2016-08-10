package com.pablofiumara.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.pablofiumara.formulario.*;


public class RegistrationValidator {

  public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
    return AgregarLibroFormulario.class.equals(clazz);
  }

  public void validate(Object obj, Errors e) {
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "titulo", "errorEnTitulo");
  }
}