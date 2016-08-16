package com.pablofiumara.formulario;

import javax.validation.constraints.NotNull;


public class LoginFormulario {
	
	@NotNull
	private String usuario;
	
	@NotNull
	private String contraseña;

}
