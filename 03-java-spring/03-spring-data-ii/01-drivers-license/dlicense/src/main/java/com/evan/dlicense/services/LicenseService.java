package com.evan.dlicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evan.dlicense.models.License;
import com.evan.dlicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private LicenseRepository lRepo;
	
	public LicenseService(LicenseRepository repo) {
		this.lRepo = repo;
	}
	
	public List<License> findAll() {
		return lRepo.findAll();
	}
	
	public License createLicense(License license) {
		return lRepo.save(license);
	}
	
	public License getLicense(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}

}
