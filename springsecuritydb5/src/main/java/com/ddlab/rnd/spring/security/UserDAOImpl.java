/**
 * 
 */
package com.ddlab.rnd.spring.security;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDAOImpl implements UserDetailsService {
	
	private JdbcTemplate jdbcTemplate;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		String sql = "SELECT * FROM appusers1 WHERE username = ?";
		UserDetails user = jdbcTemplate.queryForObject(sql,
				new Object[] { username }, new UserRowMapper());
		return user;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  

}
