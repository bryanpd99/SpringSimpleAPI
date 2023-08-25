package com.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Cliente registrado") 
public class ExistingCliente extends RuntimeException {
	

}
