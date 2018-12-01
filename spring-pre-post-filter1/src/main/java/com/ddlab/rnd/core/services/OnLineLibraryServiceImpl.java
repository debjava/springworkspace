/**
 * 
 */
package com.ddlab.rnd.core.services;

import java.util.ArrayList;
import java.util.List;

import com.ddlab.rnd.core.models.Book;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class OnLineLibraryServiceImpl implements OnLineLibraryService {

	private List<Book> allMasterBooksList = new ArrayList<Book>();
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.core.services.OnLineLibraryService#addBooks(java.util.List)
	 */
	public void addBooks(List<Book> bookList) {
		allMasterBooksList.addAll(bookList);
		System.out.println("All books uploaded successfully ....");
		System.out.println("------------ Uploaded books details -----------");
		for( Book book : bookList) {
			System.out.println(book);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.core.services.OnLineLibraryService#getAllTypesBooks()
	 */
	public List<Book> getAllTypesBooks() {
		/*
		 * Why am I doing like this ?
		 * I could have written like this 
		 *  return allMasterBooksList ;
		 */
		return new ArrayList(allMasterBooksList);
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.core.services.OnLineLibraryService#getYourUploadedBooks()
	 */
	public List<Book> getYourUploadedBooks() {
		return new ArrayList(allMasterBooksList);
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.core.services.OnLineLibraryService#getBooksOnMaturedContents()
	 */
	public List<Book> getBooksOnMaturedContents() {
		/*
		 * The reason, Spring annotations will filter the original master 
		 * by applying the expression, so it is better to use a clone one.
		 */
		return new ArrayList(allMasterBooksList);
	}
	
	/* (non-Javadoc)
	 * @see com.ddlab.rnd.core.services.OnLineLibraryService#deleteAllBooks()
	 */
	public void deleteAllBooks() {
		allMasterBooksList.clear();
	}
}
