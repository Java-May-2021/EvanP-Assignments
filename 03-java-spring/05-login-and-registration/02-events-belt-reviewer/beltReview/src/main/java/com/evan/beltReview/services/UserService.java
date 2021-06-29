package com.evan.beltReview.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.beltReview.models.User;
import com.evan.beltReview.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;

	public User registerUser(User user) {
		String hashedPw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPw);
		return uRepo.save(user);
	}
	public User findByEmail(String email) {
		return uRepo.findByEmail(email);
	}


	public User findSingleUser(Long id) {
		return this.uRepo.findById(id).orElse(null);

	}


	public boolean authenticateUser(String email, String password) {   	
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		} 
		return BCrypt.checkpw(password, user.getPassword());
	}
	
}
