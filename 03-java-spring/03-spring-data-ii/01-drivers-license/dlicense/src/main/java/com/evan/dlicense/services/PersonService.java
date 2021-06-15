package com.evan.dlicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.dlicense.models.Person;
import com.evan.dlicense.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
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
	
	public Person getSinglePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}

}
