package com.demo.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        // find user from db where username = username

        if ("demo@gmail.com".equals(username)) {
			// return new User("demo@gmail.com", "{noop}demo@123", new ArrayList<>());
			// return new User("demo@gmail.com", "{bcrypt}$2a$10$VlMdu4h1oiTDzpjWJdKEve5YlF4SDigguneUGFp4WdlXpcUyYyE7S", new ArrayList<>());
			return new User("demo@gmail.com", "$2a$10$VlMdu4h1oiTDzpjWJdKEve5YlF4SDigguneUGFp4WdlXpcUyYyE7S", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}