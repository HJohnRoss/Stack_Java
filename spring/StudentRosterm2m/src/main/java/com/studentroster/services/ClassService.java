package com.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentroster.models.Clas;
import com.studentroster.repositories.ClassRepository;

@Service
public class ClassService {
	
	@Autowired
	ClassRepository classRepository;
	
	public List<Clas> allClasses(){
		return classRepository.findAll();
	}

	public Clas createClass(Clas clas) {
		return classRepository.save(clas);
	}

	public Clas oneClas(Long id) {
		Optional<Clas> clas = classRepository.findById((Long) id);
		if(clas != null) return clas.get();
		return null;
	}
}
