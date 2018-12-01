/**
 * 
 */
package com.ddlab.rnd.core.models;

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
	private String uploaderName;
	private String uploaderRole;

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

	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public String getUploaderRole() {
		return uploaderRole;
	}

	public void setUploaderRole(String uploaderRole) {
		this.uploaderRole = uploaderRole;
	}

	@SuppressWarnings("unchecked")
	public boolean isForBelow18() {
		boolean flag = true;
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();
		for (SimpleGrantedAuthority sga : authorities) {
			RoleType roleType = RoleType.valueOf(sga.getAuthority());
			if (roleType.equals(RoleType.USER_BELOW_18)
					&& this.type.equals(BookType.MATURED_CONTENTS.name())) {
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", type=" + type
				+ ", uploaderName=" + uploaderName + ", uploaderRole="
				+ uploaderRole + "]";
	}
}
