package com.nagarro.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.Model.Book;



@Service
public class BookService {

	private String baseUrl = "http://localhost:8081";
	RestTemplate restTemplate = new RestTemplate();

	public List<Book> getBook() {
		String url = baseUrl + "/books/";
		ResponseEntity<Book[]> response=restTemplate.getForEntity(url,Book[].class);
		Book[] book=response.getBody();
		List<Book> bookDetails=Arrays.asList(book);
		
		return bookDetails;
	}
	
	public String addBook(Book book) {
		    String url = baseUrl + "/books/";
		    System.out.println(book.getBookAuthor());
		    System.out.println(book.getBookCode());
		    System.out.println(book.getBookName());
		    System.out.println(book.getDate());
		   
			ResponseEntity<String> response=restTemplate.postForEntity(url, book, String.class);
			System.out.print(response);
			return response.getBody();
		
	}
	
	
	public void deleteBook(int id) {
		String url=baseUrl+"/books/"+id;
		restTemplate.delete(url, id);
		
	}
	
	public void updateBook(Book book, int id) {
		String url=baseUrl+"/books/"+id;
		restTemplate.put(url, book);
		
	}

	public Book getBookById(int bookCode) {
		String url=baseUrl+"/books/"+bookCode;
		ResponseEntity<Book> response=restTemplate.getForEntity(url, Book.class);
		return response.getBody();
	}
}
