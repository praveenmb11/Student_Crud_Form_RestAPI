package com.std.student_man.service;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.student_man.exceptionhandling.StudentNotFound;
import com.std.student_man.model.Student;
import com.std.student_man.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public String insert(Student student) {
		studentRepository.save(student);
		return "Student data Saved";
	}
	
	public Object getStudents(long id) {
		Optional<Student>optional=studentRepository.findById(id);
		if(optional.isPresent()) {
			return optional;
		}
		else throw new StudentNotFound("No student found for the id "+id);
	}
	
	public Object getAll() {
		List<Student> list=studentRepository.findAll();
		if(list.isEmpty()) {
			throw new StudentNotFound("No Objects found to Update");
			
		}else
			return list;
	}
	
	public String modify(Student student) {
		Optional<Student>optional=studentRepository.findById(student.getId());
		if(optional.isPresent()) {
			studentRepository.save(student);
			return "Data Updated";
		}
		else
			throw new StudentNotFound("No data Found");
			}
	
	public String remove(long id) {
		Optional<Student>optional=studentRepository.findById(id);
		if(optional.isPresent()) {
			studentRepository.deleteById(id);
			return "Data Deleted";
		}else
			throw new StudentNotFound("No data to delete");
	}
}
