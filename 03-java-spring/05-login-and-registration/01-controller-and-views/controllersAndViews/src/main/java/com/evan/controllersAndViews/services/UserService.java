package com.evan.controllersAndViews.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evan.controllersAndViews.models.User;
import com.evan.controllersAndViews.repositories.UserRepository;

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
    

    public User findUserById(Long id) {
    	Optional<User> u = uRepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    

    public boolean authenticateUser(String email, String password) { 	
        User user = this.uRepo.findByEmail(email);
        if(user == null) {
            return false;
        } 
        return BCrypt.checkpw(password, user.getPassword());
    }
}
