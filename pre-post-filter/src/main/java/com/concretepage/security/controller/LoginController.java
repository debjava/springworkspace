package com.concretepage.security.controller;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.concretepage.bean.Book;
import com.concretepage.service.IBookService;
 
@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	public IBookService bookService;
	@RequestMapping(method = RequestMethod.GET)
	public String success(ModelMap map) {		
		Book b1 = new Book("A","rahim");
		Book b2 = new Book("B","ram");
		Book b3 = new Book("C","rahim");
		Book b4 = new Book("D","ram");
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		if(hasRole("ROLE_WRITE")){
		  bookService.addBook(books);
		}
		if(hasRole("ROLE_READ")){
		  List<Book> bks = bookService.getBooks();
		  System.out.println("Books we got.");
		  for(Book b: bks){
				System.out.println(b.getName()+":"+b.getOwner());
		  }
		}
		
		map.addAttribute("msg", "Done Successfully");
		return "success";
	}  
	
	private boolean hasRole(String role) {
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)SecurityContextHolder.getContext().
				getAuthentication().getAuthorities();
	    boolean hasRole = false;
	    for (GrantedAuthority authority : authorities) {
	    	hasRole = authority.getAuthority().equals(role);
	      if (hasRole) {
	    	  break;
	      }
	    }
	    return hasRole;
	  }
}