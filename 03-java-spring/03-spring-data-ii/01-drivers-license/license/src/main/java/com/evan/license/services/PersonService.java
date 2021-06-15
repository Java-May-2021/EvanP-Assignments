package com.evan.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.license.models.Person;
import com.evan.license.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	
//	public PersonService(PersonRepository repo) {
//		this.pRepo = repo;
//	}
	
	public List<Person> findAll() {
		return pRepo.findAll();
	}
	
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	public Person getSinglePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Person> getUnlicensedPeople() {
		return this.pRepo.findByLicenseIdIsNull();
	}

}