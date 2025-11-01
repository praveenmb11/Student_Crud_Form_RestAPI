package com.std.student_man.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.CastUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.std.student_man.model.Student;
import com.std.student_man.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/add")
	public String insert(@RequestBody Student student ) {
		return studentService.insert(student);
	}
	@GetMapping("/getStudents/{a}")
	public Object getStudents(@PathVariable long a) {
		return studentService.getStudents(a);
		
	}
	@GetMapping
	public Object getAll() {
		return studentService.getAll();
	}
	@PutMapping("/modify/{a}")
	public String modify(@PathVariable long a,@RequestBody Student student) {
		student.setId(a);
		return studentService.modify(student);
	}
	@DeleteMapping("/remove/{a}")
	public String remove( @PathVariable long a) {
		return studentService.remove(a);
	}
}
