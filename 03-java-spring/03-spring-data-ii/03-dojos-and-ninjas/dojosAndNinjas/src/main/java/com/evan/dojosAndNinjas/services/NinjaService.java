package com.evan.dojosAndNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.dojosAndNinjas.models.Ninja;
import com.evan.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository nRepo;
	
	public List<Ninja> getAll() {
		return this.nRepo.findAll();
	}
	
	public Ninja createNinja(Ninja newNinja) {
		return nRepo.save(newNinja);
	}
	
	public Ninja getSingleNinja(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	public Ninja updateNinja(Ninja updateNinja) {
		return this.nRepo.save(updateNinja);
	}
	public void deleteById(Long id) {
		this.nRepo.deleteById(id);
	}

}