package com.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentroster.models.Dorm;
import com.studentroster.repositories.DormRepository;

@Service
public class DormService {

	@Autowired
	DormRepository dormRepository;

	public List<Dorm> allDorms() {
		return dormRepository.findAll();
	}

	public Object getOne(Long id) {
		return dormRepository.findById(id).get();
	}

	public Dorm createDorm(Dorm dorm) {
		return dormRepository.save(dorm);
	}
}
