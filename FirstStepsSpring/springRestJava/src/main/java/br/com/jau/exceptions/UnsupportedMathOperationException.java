package br.com.jau.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/*Classe responsavel por tratar excecoes de operador matematico*/

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{

	public UnsupportedMathOperationException(String ex) {
		super (ex);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	
}
