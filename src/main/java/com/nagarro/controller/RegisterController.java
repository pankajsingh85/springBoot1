package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.nagarro.Model.User;
import com.nagarro.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(path="/register")
	public String showRegisterForm() {
		return "register";
	}
	
	@RequestMapping(path="/register/registerUser",method=RequestMethod.POST)
	public RedirectView registerUser(@ModelAttribute User user) {
		this.userService.createUser(user);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl("/springAssignment/");
		return redirectView;
		
	}
}
