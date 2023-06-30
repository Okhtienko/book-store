package org.example.apigateway.dto;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
public class SaveOrGetUserRequest {

	private String username;
	private String email;
	private String password;

}
