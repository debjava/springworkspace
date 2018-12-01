package springbasicauthcustomroledb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDAO implements UserDetailsService {
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		System.out.println("Current user Name :::"+userName);
		
		List<GrantedAuthority> gList = new ArrayList<GrantedAuthority>();
		
//		GrantedAuthority ga1 = new GrantedAuthorityImpl("TMP_BAR");
		GrantedAuthority ga1 = new SimpleGrantedAuthority("TMP_BAR");
		gList.add(ga1);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		UserDetails user = new User(userName, "Deba", enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, gList);
		
//		UserDetails user = new User(userName, "deba", enabled, true, true, true, gList);
		
		
		return user;
		
//		return null;
	}

}
