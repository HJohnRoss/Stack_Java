package com.stack_java.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stack_java.studentroster.models.Dorm;
import com.stack_java.studentroster.models.Student;
import com.stack_java.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	
	StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> someStudents(Long id) {
		return studentRepository.findByDormId(id);
	}
	
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}

	public Student findStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		
		if(student != null) {
			return student.get();
		}
		return null;
	}

	public void addToDorm(Student student, Dorm dorm) {
		student.setDorm(dorm);
		studentRepository.save(student);
	}
	
	public void delDorm(Student student) {
		student.setDorm(null);
		studentRepository.save(student);
	}
}
