package org.example.user.service;

import lombok.RequiredArgsConstructor;
import org.example.user.model.Role;
import org.example.user.model.User;
import org.example.user.repository.RoleRepository;
import org.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public User getOrSave(final User user) {
		return userRepository.findByUsername(user.getUsername())
					.orElseGet(() -> {
						final Role role = roleRepository.findByName("USER");
						user.setRoles(new HashSet<>(Arrays.asList(role)));
						return userRepository.save(user);
					});
	}

	public User get(final String email) {
		return userRepository.findByEmail(email);
	}

	public boolean exists(final String username) {
		return userRepository.existsByUsername(username);
	}

}
