package org.example.apigateway.client;

import org.example.apigateway.dto.SaveOrGetUserRequest;
import org.example.apigateway.dto.UserResponse;
import org.example.apigateway.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user", url = "${services.user.url}/api/v1/users")
public interface UserClient {

	@PostMapping
	UserResponse getOrSave(@RequestBody final SaveOrGetUserRequest request);

	@GetMapping("/gets/{email}")
	User get(@PathVariable("email") final String email);

	@GetMapping("/exists/{username}")
	boolean exists(@PathVariable("username") final String username);

}
