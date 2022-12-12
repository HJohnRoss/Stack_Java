package com.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentroster.models.Clas;
import com.studentroster.models.Student;
import com.studentroster.repositories.ClassRepository;
import com.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ClassRepository classRepository;
	
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student oneStudent(Long id) {
		Optional<Student> optional = studentRepository.findById(id);
		return optional.get();
	}

//	============================ BLACK BELT ============================
	public Student addClass(Long studentId, Long classId) {
		Student student = studentRepository.findById(studentId).get();
		Clas clas = classRepository.findById(classId).get();
		student.getClasses().add(clas);
		studentRepository.save(student);
		return student;
	}

	public List<Clas> someClasses(Student oneStudent) {
		return classRepository.findByStudentsNotContains(oneStudent);
	}

	public void delClass(Long studentId, Long classId) {
		Student student = studentRepository.findById(studentId).get();
		Clas clas = classRepository.findById(classId).get();
		student.getClasses().remove(clas);
		studentRepository.save(student);
	}
}
