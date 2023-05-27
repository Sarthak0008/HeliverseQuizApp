package com.heliverse.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(QuizException.class)
	public ResponseEntity<ErrorDetails> quizExceptionHandler(QuizException q, WebRequest req){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),q.getMessage(),req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> genralExceptionHandler(Exception u, WebRequest req){

		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),u.getMessage(),req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.OK);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noExceptionHandler(NoHandlerFoundException u, WebRequest req){

		ErrorDetails err = new ErrorDetails(LocalDateTime.now(),u.getMessage(),req.getDescription(false));

		return new ResponseEntity<ErrorDetails>(err, HttpStatus.OK);

	}

}
