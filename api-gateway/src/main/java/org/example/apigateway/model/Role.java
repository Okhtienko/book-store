package org.example.apigateway.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
@Data
@Builder
@Jacksonized
public class Role {

	private Long id;
	private String name;

}
