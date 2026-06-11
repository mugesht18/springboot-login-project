package com.kodnest.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.learn.entity.MyEntity;
import com.kodnest.learn.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	 MyService userserv ;
	
	
	@GetMapping("/")
	public String userSignUp() {
		
		return "userreg";
	}
	
	
	@PostMapping("/register")
   public String register(@ModelAttribute MyEntity user) {
		
		
	   userserv.register(user);
	    System.out.println("Registered Successfully");
	    return "login";
	   
	   
   }
	
	@GetMapping("/login")
	public String loginpage() {
		
		return "login";
	}
	
	
	 @PostMapping("/check")
	    public String login(@RequestParam("email") String email,
	                        @RequestParam("password") String password) {

	        boolean status = userserv.login(email, password);

	        if (status) {
	            return "home";      // home.html
	        } else {
	            return "loginfail";     // login.html
	        }
	    }
	
	
}
