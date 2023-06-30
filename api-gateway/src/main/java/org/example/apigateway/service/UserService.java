package org.example.apigateway.service;

import lombok.RequiredArgsConstructor;
import org.example.apigateway.client.UserClient;
import org.example.apigateway.config.security.PasswordConfig;
import org.example.apigateway.dto.SaveOrGetUserRequest;
import org.example.apigateway.dto.UserResponse;
import org.example.apigateway.model.User;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserClient userClient;
	private final PasswordConfig passwordConfig;

	public UserResponse getOrSave(final SaveOrGetUserRequest request) {
		request.setPassword(passwordConfig.passwordEncoder().encode(request.getPassword()));
		return userClient.getOrSave(request);
	}

	public User get(final String email) {
		return userClient.get(email);
	}

	public boolean exists(final String username) {
		return userClient.exists(username);
	}


}
