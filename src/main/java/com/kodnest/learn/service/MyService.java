package com.kodnest.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.learn.entity.MyEntity;
import com.kodnest.learn.repository.MyRepository;

@Service
public class MyService {
	
	@Autowired
  MyRepository	userrepo;
	
	public void register(MyEntity user) {
		
		userrepo.save(user);
		
}
	
	 public boolean login(String email, String password) {

	        MyEntity user = userrepo.findByEmailAndPassword(email, password);

	        return user != null;
	    }
	
	

}
