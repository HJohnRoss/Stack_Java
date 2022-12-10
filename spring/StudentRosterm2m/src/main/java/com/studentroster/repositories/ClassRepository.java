package com.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentroster.models.Clas;
import com.studentroster.models.Student;

@Repository
public interface ClassRepository extends CrudRepository<Clas, Long> {
	List<Clas> findAll();
	
	List<Clas> findByStudentsNotContains(Student student);
}
