package com.evan.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.dojosAndNinjas.models.Dojo;
import com.evan.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	
	public List<Dojo> getAll() {
		return this.dRepo.findAll();
	}
	
	public Dojo createDojo(Dojo newDojo) {
		return dRepo.save(newDojo);
	}
	
	public Dojo getSingleDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	public Dojo updateDojo(Dojo updateDojo) {
		return this.dRepo.save(updateDojo);
	}
	
	public void deleteById(Long id) {
		this.dRepo.deleteById(id);
	}

}