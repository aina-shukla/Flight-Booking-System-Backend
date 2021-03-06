package com.userService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userService.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	UserEntity findByUserName(String userName);



}
