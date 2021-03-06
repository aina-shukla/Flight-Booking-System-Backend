package com.userService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userService.Entity.UserEntity;
import com.userService.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserEntity> findUsersFromDb() {
		return userRepository.findAll();
	}

	public UserEntity create(UserEntity u) {
		return userRepository.save(u);
	}

	public UserEntity findUserFromDb(String userName) {
		return userRepository.findByUserName(userName);
	}
	

}
