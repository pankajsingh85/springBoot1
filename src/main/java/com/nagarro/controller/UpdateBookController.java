package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.Model.Author;
import com.nagarro.Model.Book;
import com.nagarro.service.AuthorService;
import com.nagarro.service.BookService;

@Controller
public class UpdateBookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	@RequestMapping("/updateBook")
	public String showUpdateForm(@ModelAttribute Book book, Model model) {
		int bookCode = book.getBookCode();
		System.out.println(bookCode);
		Book b = this.bookService.getBookById(bookCode);
		model.addAttribute("book", b);
		List<Author> authorList = this.authorService.getAuthor();
		model.addAttribute("authorList", authorList);
		return "updateBook";
	}

	@RequestMapping(path = "/updateBook/update", method = RequestMethod.POST)
	public String handleForm(@RequestParam("bookCode") int bookCode, @RequestParam("bookName") String bookName,
			@RequestParam("bookAuthor") String bookAuthor, @RequestParam("date") String date) {

		Book book = new Book();
		Author author = this.authorService.getAuthorByName(bookAuthor);
		book.setBookCode(bookCode);
		book.setBookName(bookName);
		book.setBookAuthor(author);
		book.setDate(date);
		this.bookService.updateBook(book, bookCode);
		return "redirect:/bookList";

	}
}