package org.example.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.example.user.model.Role;

import java.util.Set;

@Builder
@Data
@Jacksonized
public class UserResponse {

	private Long id;
	private String username;
	private String email;
	private Set<Role> roles;

}
