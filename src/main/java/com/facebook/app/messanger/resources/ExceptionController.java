package com.facebook.app.messanger.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.facebook.app.messanger.exception.DataNotFoundException;
import com.facebook.app.messanger.model.ErrorMessage;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<ErrorMessage> handleDataNotFoundException(DataNotFoundException ex,
			WebRequest request) {
		ErrorMessage error = new ErrorMessage(404, ex.getMessage(), request.getContextPath());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
