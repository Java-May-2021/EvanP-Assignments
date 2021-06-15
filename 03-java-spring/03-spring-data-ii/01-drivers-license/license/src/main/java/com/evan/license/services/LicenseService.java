package com.evan.license.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.license.models.License;
import com.evan.license.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepo;
	
//	public LicenseService(LicenseRepository repo) {
//		this.lRepo = repo;
//	}
	
	public List<License> findAll() {
		return lRepo.findAll();
	}
	
	public License createLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return this.lRepo.save(license);
	}
	
	public License getSingleLicense(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public int generateLicenseNumber() {
		License lic = this.lRepo.findTopByOrderByNumberDesc();
		if(lic == null) {
			return 1;
		}
		int previousLicenseNumber = lic.getNumber();
		previousLicenseNumber++;
		return (previousLicenseNumber);
	}

}

