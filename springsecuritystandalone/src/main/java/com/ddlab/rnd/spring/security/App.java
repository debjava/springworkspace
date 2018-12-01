package com.ddlab.rnd.spring.security;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext =  new ClassPathXmlApplicationContext(new String[]{"application-security.xml","beans.xml"});
//    	InMemoryUserDetailsManager userDetailsService = applicationContext.getBean(InMemoryUserDetailsManager.class);
//    	UserDetails userDetails = userDetailsService.loadUserByUsername ("admin");
//		Authentication authToken = new UsernamePasswordAuthenticationToken (userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(authToken);
    	
//    	Service1 service1 = (Service1) applicationContext.getBean("service1");
//    	service1.executeMethod3();
//    	service1.executeMethod1();
    	
    	
    	List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
    	auths.add(new SimpleGrantedAuthority("ROLE_USER"));
    	User user = new User("deba1", "deba1", auths);
    	Authentication authToken = new UsernamePasswordAuthenticationToken (user.getUsername(), user.getPassword(), user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authToken);
		Service1 service1 = (Service1) applicationContext.getBean("service1");
    	service1.executeMethod3();
    	
    	
    }
}
