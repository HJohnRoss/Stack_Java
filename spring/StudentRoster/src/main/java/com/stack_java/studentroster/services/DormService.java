package com.stack_java.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stack_java.studentroster.models.Dorm;
import com.stack_java.studentroster.repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dormRepository;
	
	DormService(DormRepository dormRepository){
		this.dormRepository = dormRepository;
	}
	
	public Dorm createDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}

	public List<Dorm> allDorms() {
		return dormRepository.findAll();
	}

	public Dorm findDorm(Long id) {
		Optional<Dorm> dorm = dormRepository.findById(id);
		if(dorm != null) {
			return dorm.get();
		}
		return null;
	}
}
