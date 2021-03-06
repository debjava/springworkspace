package com.ddlab.rnd.spring.security;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {

    public static void loginAs(String userName, String password, String roleType) {
        setSecurity(userName, password, roleType);
    }

    private static void setSecurity(String userName, String password, String roleType) {
        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(roleType));
        User user = new User(userName, password, auths);
        Authentication authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    public static void removeUser() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

}
