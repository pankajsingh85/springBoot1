package com.nagarro.controller;

import java.util.Calendar;
import java.util.Formatter;
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
public class AddBookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;

	@RequestMapping("/addBook")
	public String showAddForm(Model model) {
		
		Calendar cal = Calendar.getInstance();
		Formatter fmt = new Formatter();
		fmt.format("%tB ", cal);
		String date = cal.get(Calendar.DATE) + " " + fmt + "" + cal.get(Calendar.YEAR);
		fmt.close();
		model.addAttribute("date", date);
		
		List<Author> authorList=this.authorService.getAuthor();
		model.addAttribute("authorList", authorList);
		return "addBook";
	}

	@RequestMapping("/bookList")
	public String showBookList(Model model) {
		List<Book> bookList = this.bookService.getBook();
		model.addAttribute("bookList", bookList);
		return "bookList";

	}

	@RequestMapping(path = "/addBook/add", method = RequestMethod.POST)
	
	public String handleForm(@RequestParam("bookCode") int bookCode,
			@RequestParam("bookName") String bookName,
			@RequestParam("bookAuthor") String bookAuthor,
			@RequestParam("date") String date) {
		
		
		Book book=new Book();
		Author author=this.authorService.getAuthorByName(bookAuthor);
		
		book.setBookCode(bookCode);
		book.setBookName(bookName);
		book.setBookAuthor(author);
		book.setDate(date);
		
		this.bookService.addBook(book);
		return "redirect:/bookList";

	}
}
