package com.ddlab.rnd.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ddlab.rnd.core.models.Book;
import com.ddlab.rnd.core.models.BookType;
import com.ddlab.rnd.core.models.RoleType;
import com.ddlab.rnd.core.models.SecurityUtil;
import com.ddlab.rnd.core.services.OnLineLibraryService;

public class App 
{
	@SuppressWarnings("unchecked")
	private static String getUploaderRole() {
		String uploaderRole = null;
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		for( SimpleGrantedAuthority sga : authorities) {
			uploaderRole = sga.getAuthority();
			break;
		}
		return uploaderRole;
	}
	
	public static void uploadBooks(OnLineLibraryService bookService) {
		String loginUserName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		String uploaderRole = getUploaderRole();
		Book novel = new Book();
        novel.setBookName("A Novel by Charles Dickens");
        novel.setType(BookType.GENERAL.name());
        novel.setUploaderName(loginUserName);
        novel.setUploaderRole(uploaderRole);
        
        Book adult = new Book();
        adult.setBookName("A complete guide to Safe SEX");
        adult.setType(BookType.MATURED_CONTENTS.name());
        adult.setUploaderName(loginUserName);
        adult.setUploaderRole(uploaderRole);
        
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(novel);
        bookList.add(adult);
        
        bookService.addBooks(bookList);
        
	}
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	OnLineLibraryService bookService = (OnLineLibraryService) context.getBean("bookService");
    	
//    	SecurityUtil.loginAs("Deb", "pqrs", RoleType.ADMIN);
//    	SecurityUtil.loginAs("Deb", "pqrs", RoleType.USER_BELOW_18);
    	SecurityUtil.loginAs("Deb", "pqrs", RoleType.USER_ABOVE_18);
    	uploadBooks(bookService);
//    	uploadBooks(bookService);
    	
//    	SecurityUtil.loginAs("Deb1", "pqrs", RoleType.USER_BELOW_18);
    	List<Book> books = bookService.getAllTypesBooks();
//    	System.out.println("---------------- All Types of Books ----------------");
//    	for( Book book : books) {
//			System.out.println(book);
//		}
    	
//    	books = bookService.getYourUploadedBooks();
//    	System.out.println("---------------- Your Uploaded Books ----------------");
//    	for( Book book : books) {
//			System.out.println(book);
//		}
    	
    	books = bookService.getBooksOnMaturedContents();
    	System.out.println("---------------- Books on Matured Contents ----------------");
    	for( Book book : books) {
			System.out.println(book);
		}
    	
    	books = bookService.getYourUploadedBooks();
    	System.out.println("---------------- Your Uploaded Books ----------------");
    	for( Book book : books) {
			System.out.println(book);
		}
    	
    }
}
