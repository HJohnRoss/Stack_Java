package com.stack_java.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stack_java.relationships.models.Person;
import com.stack_java.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
	
	PersonService(PersonRepository personRepository){
		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}

	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		if(person != null) {
			return person.get();
		}
		return null;
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
}
