package org.example.user.converter;

import org.example.user.dto.SaveOrGetUserRequest;
import org.example.user.dto.UserResponse;
import org.example.user.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

	User fromDto(final SaveOrGetUserRequest request);

	UserResponse toDto(final User user);

}
