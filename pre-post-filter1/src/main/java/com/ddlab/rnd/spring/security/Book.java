/**
 * 
 */
package com.ddlab.rnd.spring.security;

import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class Book {
	
	private String bookName;
	private String type;
	private String uploadedBy;
	
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public boolean isForStudents() {
		boolean flag = true;
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		for( SimpleGrantedAuthority sga : authorities) {
//			System.out.println(sga.getAuthority());
			
			if( sga.getAuthority().equals("ROLE_BELOW_18") && this.type.equals("ADULT") ) {
				flag = false;
//				break;
			}
//			if( ROLETYPE.valueOf(sga.getAuthority()).equals(ROLETYPE.USER_BELOW_18) ) {
//				flag = false;
//				break;
//			}
				
		}
//		System.out.println("Flag----->"+flag);
		return flag;
	}

}
