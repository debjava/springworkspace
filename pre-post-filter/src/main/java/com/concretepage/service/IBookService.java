package com.concretepage.service;
import java.util.List;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import com.concretepage.bean.Book;
public interface IBookService {
	@PreAuthorize ("hasRole('ROLE_READ')")
	@PostFilter ("filterObject.owner == authentication.name")
	public List<Book> getBooks();
	
	@PreFilter("filterObject.owner == authentication.name")
	public void addBook(List<Book> books); 
}
