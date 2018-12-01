/**
 * 
 */
package com.ddlab.rnd.spring.security;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class BookServiceImpl implements BookService {
	
	private List<Book> allBooksList = new ArrayList<Book>();

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BookService#addBooks(java.util.List)
	 */
	public void addBooks(List<Book> bookList) {
		allBooksList.addAll(bookList);
		System.out.println("Books added successfully ....");
		
//		for( Book book : allBooksList ) {
//        	System.out.println("Book Name :::"+book.getBookName()+"----"+book.getType());
//        }
	}

	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BookService#getAllBooks()
	 */
	public List<Book> getAllTypeBooks() {
		return allBooksList;
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.spring.security.BookService#getBooks()
	 */
	public List<Book> getBooks() {
		return allBooksList;
	}
	
	public List<Book> getAdultBooks() {
		return allBooksList;
	}
	
	public List<Book> getBooks1() {
//		for( Book book : allBooksList ) {
//        	System.out.println("Book Name :::"+book.getBookName()+"----"+book.getType()+" : uploaded by ->"+book.getUploadedBy());
//        }
		return allBooksList;
	}
	
	public void uploadYourBooks(List<Book> bookList) {
//		System.out.println(bookList);
		
		for( Book book : bookList ) {
        	System.out.println("Book Name :::"+book.getBookName()+"----"+book.getType()+" : uploaded by ->"+book.getUploadedBy());
        }
	}

}
