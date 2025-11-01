package com.std.student_man.exceptionhandling;

public class StudentNotFound extends RuntimeException {

	public StudentNotFound(String message) {
		super(message);
	}
}
