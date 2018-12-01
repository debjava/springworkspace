package com.ddlab.rnd.spring.security;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
 
public class UserRowMapper implements RowMapper<User>
{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = null;
		String username = rs.getString("username");
		String password = rs.getString("password");
		boolean enabled = rs.getBoolean("enabled");
		boolean accountNonExpired = rs.getBoolean("accountNonExpired");
		boolean credentialsNonExpired = rs.getBoolean("credentialsNonExpired");
		boolean accountNonLocked = rs.getBoolean("accountNonLocked");
		String authority = rs.getString("authority");
		List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority auth1 = new SimpleGrantedAuthority(authority);
		gaList.add(auth1);
		user = new User(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, gaList);
		return user;
	}
 
}