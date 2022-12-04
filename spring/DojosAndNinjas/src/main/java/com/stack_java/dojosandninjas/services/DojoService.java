package com.stack_java.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stack_java.dojosandninjas.models.Dojo;
import com.stack_java.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;
	
	DojoService(DojoRepository dojoRepository){
		this.dojoRepository = dojoRepository;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	public Dojo findDojo(Long id) {
		Optional<Dojo> oneDojo = dojoRepository.findById(id);
		if(oneDojo != null) {
			return oneDojo.get();
		}
		return null;
	}
}
