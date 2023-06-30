package org.example.user.facade;

import lombok.RequiredArgsConstructor;
import org.example.user.converter.UserConverter;
import org.example.user.dto.SaveOrGetUserRequest;
import org.example.user.dto.UserResponse;
import org.example.user.model.User;
import org.example.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

	private final UserService userService;
	private final UserConverter userConverter;

	public UserResponse getOrSave(final SaveOrGetUserRequest request) {
		final User user = userConverter.fromDto(request);
		final User savedUser = userService.getOrSave(user);
		return userConverter.toDto(savedUser);
	}

	public User get(final String email) {
		return userService.get(email);
	}

	public boolean exists(final String username) {
		return userService.exists(username);
	}

}
