package org.example.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.user.dto.SaveOrGetUserRequest;
import org.example.user.dto.UserResponse;
import org.example.user.facade.UserFacade;
import org.example.user.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserFacade userFacade;

	@PostMapping
	public UserResponse getOrSave(@RequestBody final SaveOrGetUserRequest request) {
		return userFacade.getOrSave(request);
	}

	@GetMapping("/gets/{email}")
	public User get(@PathVariable("email") final String email) {
		return userFacade.get(email);
	}

	@GetMapping("/exists/{username}")
	public boolean exists(@PathVariable("username") final String username) {
		return userFacade.exists(username);
	}

}
