package com.evan.beltReview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.beltReview.models.User;
import com.evan.beltReview.models.Wedding;
import com.evan.beltReview.repositories.WeddingRepository;

@Service
public class WeddingService {
	@Autowired
	private WeddingRepository wRepo;
	
	public List<Wedding> getAllWeddings() {
		return this.wRepo.findAll();
	}
	
	public Wedding getOneWedding(Long id) {
		return this.wRepo.findById(id).orElse(null);
	}
	
	public Wedding createWedding(Wedding wedding) {
		return this.wRepo.save(wedding);
	}
	
	public void deleteWedding(Long id) {
		this.wRepo.deleteById(id);
	}
	
	public void RSVP(User user, Wedding wedding) {
		List<User> allGuests = wedding.getGuests();
		allGuests.add(user);
		this.wRepo.save(wedding);
	}
	
	public void UnRSVP(User user, Wedding wedding) {
		List<User> getGuests = wedding.getGuests();
		getGuests.remove(user);
		this.wRepo.save(wedding);
	}
}
