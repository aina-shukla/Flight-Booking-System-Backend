package com.userService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.userService.Entity.UserEntity;
import com.userService.Repository.UserRepository;
import com.userService.Service.UserService;

@RestController
@RequestMapping("/userservice")
@CrossOrigin(origins = {"https://hoppscotch.io", "http://localhost:4200"})
public class UserController {

	@Autowired
	private UserService uService;
		
	 @GetMapping("/users")
	    public String greet(){
	        return "Welcome user";
	    }
	
	@GetMapping("/users/search")  //searching users
	public List<UserEntity> getAllUsers(){
		System.out.println("Getting all users");
		return uService.findUsersFromDb();
	}
	
	@GetMapping("/users/search/{userName}")  //searching users
	public UserEntity getUser(@PathVariable String userName){
		return uService.findUserFromDb(userName);
	}
	
	@PostMapping("/users/add")  //register users
	public UserEntity save(@RequestBody UserEntity u) {
		System.out.println();
		return uService.create(u);
	}
	
	}
