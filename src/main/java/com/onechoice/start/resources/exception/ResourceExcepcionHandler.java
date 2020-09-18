package com.onechoice.start.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onechoice.start.services.exceptions.ObjectNotfoundException;

@ControllerAdvice
public class ResourceExcepcionHandler {
    
	@ExceptionHandler(ObjectNotfoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotfoundException e,HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(System.currentTimeMillis(),status.value(),"objeto nao encontrado",e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
		
	}
	
}
