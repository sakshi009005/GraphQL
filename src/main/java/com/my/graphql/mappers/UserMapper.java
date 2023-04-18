package com.my.graphql.mappers;

import org.mapstruct.Mapper;

import com.my.graphql.entities.User;
import com.my.graphql.model.UserRequest;
import com.my.graphql.model.UserResponse;

@Mapper(componentModel = "spring")
public interface UserMapper{

	UserResponse toUserResponse(User user);
	User toUser(UserRequest userData);
}
