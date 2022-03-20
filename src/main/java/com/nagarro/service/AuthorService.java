package com.nagarro.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.Model.Author;


@Service
public class AuthorService {


	private String baseUrl = "http://localhost:8081";
	RestTemplate restTemplate = new RestTemplate();

	public List<Author> getAuthor() {
		String url = baseUrl + "/authors/";
		ResponseEntity<Author[]> response=restTemplate.getForEntity(url,Author[].class);
		Author[] author=response.getBody();
		List<Author> authorDetails=Arrays.asList(author);
		
		return authorDetails;
	}
	
	public String addAuthor(Author author) {
		    String url = baseUrl + "/authors/";  
			ResponseEntity<String> response=restTemplate.postForEntity(url, author, String.class);
			System.out.print(response);
			return response.getBody();
		
	}
	
	
	public void deleteAuthor(int id) {
		String url=baseUrl+"/authors/"+id;
		restTemplate.delete(url, id);
		
	}
	
	public void updateAuthor(Author author, int id) {
		String url=baseUrl+"/authors/"+id;
		restTemplate.put(url, author);
		
	}

	public Author getAuthorById(int authorId) {
		String url=baseUrl+"/authors/"+authorId;
		ResponseEntity<Author> response=restTemplate.getForEntity(url, Author.class);
		return response.getBody();
	}
	
	public Author getAuthorByName(String authorName) {
		String url=baseUrl+"/authors/"+authorName;
		ResponseEntity<Author> response=restTemplate.getForEntity(url, Author.class);
		return response.getBody();
	}
}
