package com.concretepage.service;
import com.concretepage.bean.Book;
public class BookService implements IBookService {
	@Override
	public void addBook(Book book) {
		System.out.println("You have successfully added book.");		
	}

	@Override
	public Book getBook() {
		Book book = new Book("B", "ram");
		return book;
	}

	@Override
	public void deleteBook(Book book) {
	  System.out.println("Books deleted");		
	}
}
