package org.example.apigateway.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import java.util.Set;

@Data
@Builder
@Jacksonized
public class User {

	private Long id;
	private String username;
	private String email;
	private String password;
	private Set<Role> roles;

}
