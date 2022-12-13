package com.beltpractice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beltpractice.models.Sighting;
import com.beltpractice.repositories.SightingRepository;

@Service
public class SightingService {
	@Autowired
	private SightingRepository sightingRepository;
	
	public Sighting getOne(Object idObject) {
		Optional<Sighting> sighting = sightingRepository.findById((Long) idObject);
		return sighting.get();
	}
	
	public List<Sighting> getAll() {
		return sightingRepository.findAll();
	}

	public Sighting save(Sighting sighting) {
		return sightingRepository.save(sighting);
	}

	public void deleteSighting(@Valid Sighting sighting) {
		sightingRepository.delete(sighting);
	}
}
