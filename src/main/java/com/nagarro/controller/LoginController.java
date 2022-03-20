package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.Model.Book;

import com.nagarro.Model.User;
import com.nagarro.service.BookService;
import com.nagarro.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private BookService  bookService;

	@RequestMapping("/")
	public String showForm() {
		return "login";
	}
	


	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user,Model model) {
		
		if (this.userService.validateUser(user.getUsername(), user.getPassword())) {	
			List<Book> bookList=this.bookService.getBook();
			model.addAttribute("bookList", bookList);
			return "bookList";		
		}
		return "redirect:/";

	}

}
