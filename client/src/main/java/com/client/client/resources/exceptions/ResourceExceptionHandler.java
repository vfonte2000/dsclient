package com.client.client.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.client.client.services.exceptions.DatabaseException;
import com.client.client.services.exceptions.ResourcerNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourcerNotFoundException.class)
	public ResponseEntity<StandarError> entityNotFound(ResourcerNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError err = new StandarError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("valcelio3 Database exception ");
		err.setMessage(e.getMessage());
		err.setError(request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandarError> database(DatabaseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError err = new StandarError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("valcelio2 Database exception ");
		err.setMessage(e.getMessage());
		err.setError(request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}

}
