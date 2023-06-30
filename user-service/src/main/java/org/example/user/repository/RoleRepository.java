package org.example.user.repository;

import org.example.user.model.Role;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends Repository<Role, Long> {

	@Query("SELECT * FROM roles WHERE name = :name")
	Role findByName(@Param("name") final String name);

}
