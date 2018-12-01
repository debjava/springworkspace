package com.concretepage.service;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import com.concretepage.bean.Book;
public interface IBookService {
	
	@PreAuthorize ("hasRole('ROLE_WRITE')")
	public void addBook(Book book);
	
	@PostAuthorize ("returnObject.owner == authentication.name")
	public Book getBook();
	
	@PreAuthorize ("#book.owner == authentication.name")
	public void deleteBook(Book book);
}
