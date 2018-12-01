package com.concretepage.service;
import java.util.ArrayList;
import java.util.List;
import com.concretepage.bean.Book;
public class BookService implements IBookService {
	@Override
	public List<Book> getBooks() {
		Book b1 = new Book("A","rahim");
		Book b2 = new Book("B","ram");
		Book b3 = new Book("C","rahim");
		Book b4 = new Book("D","ram");
		List<Book> books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		return books;
	}
	@Override
	public void addBook(List<Book> books) {
		System.out.println("Books Added.");
		for(Book b: books){
			System.out.println(b.getName()+":"+b.getOwner());
		}
	}
}
