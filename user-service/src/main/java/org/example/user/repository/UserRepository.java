package org.example.user.repository;

import org.example.user.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

	User save(final User user);

	boolean existsByUsername(final String username);

	@Query("SELECT * FROM users WHERE email = :email")
	User findByEmail(@Param("email") final String email);

	@Query("SELECT * FROM users WHERE username = :username")
	Optional<User> findByUsername(@Param("username") final String username);

}
