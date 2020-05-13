package com.example.demo.resource.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.services.exceptions.ObjectNotFoundException;

// Essa anotação define que a classe vai tratar possíveis erros nas requisições
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Padrão do framework para funcionar e identificar a exceção e retornar esse método
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(),
				status.value(), "Not found object", e.getMessage(), request.getRequestURI());
		// Retorna o ResponseEntity com o status 404 e o corpo com a entidade com as respostas de erro
		return ResponseEntity.status(status).body(err);
	}
	
}
