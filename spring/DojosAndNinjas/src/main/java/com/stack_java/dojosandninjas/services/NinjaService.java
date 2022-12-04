package com.stack_java.dojosandninjas.services;

import org.springframework.stereotype.Service;

import com.stack_java.dojosandninjas.models.Ninja;
import com.stack_java.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	NinjaService(NinjaRepository ninjaRepository){
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
}
