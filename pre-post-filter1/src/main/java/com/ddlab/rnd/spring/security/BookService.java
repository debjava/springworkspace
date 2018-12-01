/**
 * 
 */
package com.ddlab.rnd.spring.security;

import java.util.List;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public interface BookService {

	@PreAuthorize ("hasRole('ROLE_ADMIN')")
//	@PostFilter ("filterObject.owner == authentication.name")
	public void addBooks(List<Book> bookList);
	
//	@PreAuthorize ("hasRole('ROLE_ABOVE18')")
	
//	@PostFilter ("filterObject.type == new String('ADULT') ")
//	@PostFilter ("filterObject.type != 'ADULT' ")
//	@PostFilter ("filterObject.type == 'ADULT' ")
//	@PostFilter ("filterObject.type == 'ADULT' and hasRole('ROLE_ABOVE_18')" )
	
//	@PostFilter ("filterObject.type != 'ADULT' or hasRole('USER_BELOW_18')" )//Got Novel Book
//	@PostFilter ("(filterObject.type != 'ADULT') and hasRole('USER_BELOW_18')" )
	
	@PreAuthorize ("hasAnyRole({'ROLE_ADMIN','ROLE_ABOVE_18'})")
	public List<Book> getAllTypeBooks();
	
//	@PreAuthorize ("permitAll")
	@PreAuthorize ("hasAnyRole({'ROLE_ADMIN','ROLE_ABOVE_18','ROLE_BELOW_18'})")
	@PostFilter (" filterObject.type != 'ADULT' " )
	public List<Book> getBooks();
	
	@PreAuthorize ("hasRole('ROLE_ADMIN')")
	@PostFilter (" filterObject.type == 'ADULT' " )
	public List<Book> getAdultBooks();
	
//	@PostFilter ("(filterObject.type == 'ADULT' or filterObject.type == 'NOVEL') and (filterObject.uploadedBy == 'USER_ABOVE_18')" )
	@PostFilter ("(filterObject.isForStudents())" )
	public List<Book> getBooks1();
	
	
	@PreFilter("filterObject.uploadedBy == authentication.name")
	public void uploadYourBooks(List<Book> bookList);//Books uploaded by You
	
}
