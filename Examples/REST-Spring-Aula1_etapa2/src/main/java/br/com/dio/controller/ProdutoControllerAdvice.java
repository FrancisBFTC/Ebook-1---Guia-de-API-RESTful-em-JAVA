package br.com.dio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.dio.exception.ProductNullException;
import br.com.dio.exception.ProductPriceException;


@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> erroGenerico(){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("Message", "Ocorreu um erro generico!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	
	@ExceptionHandler(ProductNullException.class)
	public ResponseEntity<Object> capturaErroNull(){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("Message", "Verifique os campos do produto!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	
	@ExceptionHandler(ProductPriceException.class)
	public ResponseEntity<Object> capturaErroNegativo(){
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("Message", "Verifique o campo preco!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
}
