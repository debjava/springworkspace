package com.concretepage.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

		try {
			bookService.addBook(b1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			bookService.getBook();
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			Book b2 = new Book("B","ram");
			bookService.deleteBook(b2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.addAttribute("msg", "Done Successfully");
		return "success";
	}  
}