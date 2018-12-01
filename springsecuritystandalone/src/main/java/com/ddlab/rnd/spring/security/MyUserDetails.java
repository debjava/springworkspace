/**
 * 
 */
package com.ddlab.rnd.spring.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Debadatta Mishra (Piku)
 *
 */
public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = -499205757951433470L;
	
	private String userName ;
	private String password ;
	private String roleType ;
	
	public MyUserDetails(String userName , String password, String roleType) {
		this.userName = userName;
		this.password = password;
		this.roleType = roleType;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
//        auths.add(new SimpleGrantedAuthority("Admin"));
		auths.add(new SimpleGrantedAuthority(roleType));
        return auths;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return userName;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
