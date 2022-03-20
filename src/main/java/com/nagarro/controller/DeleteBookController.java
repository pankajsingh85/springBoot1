package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.Model.Book;
import com.nagarro.service.BookService;

@Controller
public class DeleteBookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/deleteBook")
	public String showUpdateForm(@ModelAttribute Book book, Model model) {
		int bookCode = book.getBookCode();
		bookService.deleteBook(bookCode);
		return "redirect:/bookList";
	}
}
