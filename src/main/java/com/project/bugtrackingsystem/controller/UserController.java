package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.UserDTO;
import com.project.bugtrackingsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;


	@PostMapping("/register")
	public UserDTO registerUser(@RequestBody UserDTO userDTO) {
		return userService.registerUser(userDTO);
	}

	@PostMapping("/signin")
	public UserDTO signIn(@RequestParam String userName, @RequestParam String password) {
		return userService.signIn(userName, password);
	}

	@GetMapping("/signout")
	public String signOut() {
		return userService.signOut();
	}
}