package com.evan.dlicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evan.dlicense.models.Person;
import com.evan.dlicense.repositories.PersonRepository;

@Service
public class PersonService {
	private PersonRepository pRepo;
	
	public PersonService(PersonRepository repo) {
		this.pRepo = repo;
	}
	
	public List<Person> findAll() {
		return pRepo.findAll();
	}
	
	public Person createPerson(Person person) {
		return pRepo.save(person);
	}
	
	public Person getPerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}

}
