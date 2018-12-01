/**
 * 
 */
package com.ddlab.rnd.core.services;

import java.util.List;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import com.ddlab.rnd.core.models.Book;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public interface OnLineLibraryService {
	
	@PreAuthorize ("hasAnyRole({'USER_ABOVE_18','ADMIN','USER_BELOW_18'})")
	@PostFilter ("filterObject.owner == authentication.name")
	@PreFilter ("(filterObject.isForBelow18())" )
	public void addBooks(List<Book> bookList);
	
	@PostFilter ("(filterObject.isForBelow18())" )
	public List<Book> getAllTypesBooks();
	
//	@PostFilter("filterObject.owners.email == principal.username")
	@PreAuthorize ("hasAnyRole({'USER_ABOVE_18','ADMIN','USER_BELOW_18'})")
	@PostFilter("filterObject.uploaderName == authentication.name")
	public List<Book> getYourUploadedBooks();//Books uploaded by You
	
	@PreAuthorize ("hasAnyRole({'USER_ABOVE_18','ADMIN'})")
	@PostFilter (" filterObject.type == 'MATURED_CONTENTS' " )
	public List<Book> getBooksOnMaturedContents();
	
	@PreAuthorize ("hasAnyRole('ADMIN')")
	public void deleteAllBooks();

}
