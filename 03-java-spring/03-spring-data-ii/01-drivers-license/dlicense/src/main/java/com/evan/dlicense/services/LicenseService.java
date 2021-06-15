package com.evan.dlicense.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.dlicense.models.License;
import com.evan.dlicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepo;
	
	public LicenseService(LicenseRepository repo) {
		this.lRepo = repo;
	}
	
	public List<License> findAll() {
		return lRepo.findAll();
	}
	
	public License createLicense(License l) {
		l.setNumber(this.generateLicenseNumber());
		return lRepo.save(l);
	}
	
	public int generateLicenseNumber() {
		License l = lRepo.findTopByOrderByNumberDesc();
		if(l == null)
			return 1;
		int largestNumber = l.getNumber();
		largestNumber++;
		return (largestNumber);
	}

	public License getSingleLicense(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}

}
