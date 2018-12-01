package com.ddlab.rnd.spring.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.service.IUserService;

//@Repository(value = "userDao")
public class CustomUserDAO implements UserDetailsService {
	
	@Autowired
    @Qualifier("userService")
	IUserService userService;
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		userService.getAll();
		System.out.println("Current user Name :::"+userName);
		
		
		try {
			System.out.println("1----------->"+SecurityContextHolder.getContext().getAuthentication());
			Object obj = SecurityContextHolder.getContext().getAuthentication().getCredentials();
			System.out.println("Object ::::"+obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		List<GrantedAuthority> gList = new ArrayList<GrantedAuthority>();
		
//		GrantedAuthority ga1 = new GrantedAuthorityImpl("TMP_BAR");
		GrantedAuthority ga1 = new SimpleGrantedAuthority("ROLE_USER");
		gList.add(ga1);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		String password = "miki";
		
		UserDetails user = new User(userName, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, gList);
		
//		UserDetails user = new User(userName, "deba", enabled, true, true, true, gList);
		
		
		return user;
		
//		return null;
	}
	
	

}
