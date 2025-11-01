package com.std.student_man;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.std.student_man.exceptionhandling.StudentNotFound;
@ControllerAdvice
public class GlobalException extends RuntimeException {

	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<String> notFound(StudentNotFound nf){
		return new ResponseEntity<String>(nf.getMessage(),HttpStatus.NOT_FOUND);
	}
}
