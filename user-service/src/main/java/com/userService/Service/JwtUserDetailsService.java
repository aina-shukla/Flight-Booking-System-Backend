package com.userService.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.userService.Entity.UserEntity;
import com.userService.Repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		  if ("user".equals(username)) {
				return new User("user", "$2a$10$a.3zhQ1X3uG8bHuf4hNPy.gtjv604yym8Xe/ZoSO1MYCH7NL9EhJa", new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}	
	
	}
}