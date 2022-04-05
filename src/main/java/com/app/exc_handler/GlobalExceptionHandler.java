package com.app.exc_handler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ErrorResponse;

@ControllerAdvice // Mandatory annotation to tell SC , follo. class will contain common advice on
					// exc handling
//for all controllers
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	//how to handle globally, validation related errors?
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// return error message : field name : error mesg 
		Map<String, String> map = ex.getFieldErrors().stream()//Stream<FieldError>
		.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		return ResponseEntity.badRequest().body(map);
	}
	//how to deal with custom exc globally?
	//how to tell SC, following is an exc handling method
	//method arg : Class<T> : T => type of exc to be handled
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}
	//equivalent catch all block
		@ExceptionHandler(RuntimeException.class)
		public ResponseEntity<?> handleRuntimeException(RuntimeException e)
		{
			ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
		}

}
