package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.UserDTO;

public interface UserService {
	UserDTO registerUser(UserDTO user);

	UserDTO signIn(String userName, String password);

	// use session management accordingly
	String signOut();
}
