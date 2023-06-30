package org.example.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;

@Data
@Entity
@Builder
@Jacksonized
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	public Role() {

	}

	public Role(Long id, String name) {
		this.id = id;
		this.name = name;
	}

}
