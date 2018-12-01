package com.ddlab.rnd.spring.security;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ddlab.rnd.core.models.Book;
import com.ddlab.rnd.core.models.BookType;
import com.ddlab.rnd.core.models.RoleType;
import com.ddlab.rnd.core.models.SecurityUtil;
import com.ddlab.rnd.core.services.OnLineLibraryService;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private static OnLineLibraryService bookService = null;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		bookService = (OnLineLibraryService) context.getBean("bookService");
	}

	@Test
	public void uploadBooksByAdmin() {
		loginAsAdmin();
		uploadBooks(bookService);

		List<Book> allBooksByAdmin = bookService.getAllTypesBooks();
		assertEquals(2, allBooksByAdmin.size());

		List<Book> adultBooksByAdmin = bookService.getBooksOnMaturedContents();
		assertEquals(1, adultBooksByAdmin.size());

		List<Book> booksUploadedByAdmin = bookService.getYourUploadedBooks();
		assertEquals(2, booksUploadedByAdmin.size());
		List<String> namesList = new ArrayList<String>();
		for (Book book : booksUploadedByAdmin)
			namesList.add(book.getUploaderName());
		assertEquals(2, namesList.size());
	}
	
	@Test
	public void uploadBooksByParents() {
		loginAsAdmin();
		bookService.deleteAllBooks();
		loginAsParents();
		uploadBooks(bookService);

		List<Book> allBooksByParents = bookService.getAllTypesBooks();
		assertEquals(2, allBooksByParents.size());

		List<Book> adultBooksByParents = bookService.getBooksOnMaturedContents();
		assertEquals(1, adultBooksByParents.size());

		List<Book> booksUploadedByParents = bookService.getYourUploadedBooks();
		assertEquals(2, booksUploadedByParents.size());
		List<String> namesList = new ArrayList<String>();
		for (Book book : booksUploadedByParents)
			namesList.add(book.getUploaderName());
		assertEquals(2, namesList.size());
	}
	
	@Test
	public void uploadBooksByStudent() {
		loginAsAdmin();
		bookService.deleteAllBooks();
		loginAsStudent();
		uploadBooks(bookService);

		List<Book> allBooksByStudent = bookService.getAllTypesBooks();
		assertEquals(1, allBooksByStudent.size());

	}
	
	@Test(expected = AccessDeniedException.class)
	public void studentTriesToReadSexBook() {
		loginAsAdmin();
		bookService.deleteAllBooks();
		loginAsStudent();
		uploadBooks(bookService);

		List<Book> allBooksByStudent = bookService.getAllTypesBooks();
		assertEquals(1, allBooksByStudent.size());

		List<Book> adultBooksByAdmin = bookService.getBooksOnMaturedContents();
	}
	
	@Test
	public void studentVerifiesUploadBooks() {
		loginAsAdmin();
		bookService.deleteAllBooks();
		loginAsStudent();
		uploadBooks(bookService);

		List<Book> allBooksByStudent = bookService.getAllTypesBooks();
		assertEquals(1, allBooksByStudent.size());

		List<Book> booksUploadedByStudent = bookService.getYourUploadedBooks();
		assertEquals(1, booksUploadedByStudent.size());
		
		List<String> namesList = new ArrayList<String>();
		for (Book book : booksUploadedByStudent)
			namesList.add(book.getUploaderName());
		assertEquals(1, namesList.size());
	}

	// ~~ Useful supplementary methods
	private void loginAsAdmin() {
		SecurityUtil.loginAs("DebAdmin", "AdminPa$$w0rd", RoleType.ADMIN);
	}

	private void loginAsParents() {
		SecurityUtil.loginAs("Debanand", "wert@34passWORD",
				RoleType.USER_ABOVE_18);
	}

	private void loginAsStudent() {
		SecurityUtil.loginAs("John Abraham", "abrakadabra",
				RoleType.USER_BELOW_18);
	}

	@SuppressWarnings("unchecked")
	private String getUploaderRole() {
		String uploaderRole = null;
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		for (SimpleGrantedAuthority sga : authorities) {
			uploaderRole = sga.getAuthority();
			break;
		}
		return uploaderRole;
	}

	private void uploadBooks(OnLineLibraryService bookService) {
		String loginUserName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

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
}
