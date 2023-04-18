package com.my.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.my.graphql.exception.UnknownOrderTypeException;
import com.my.graphql.exception.UserNotFoundException;
import com.my.graphql.mappers.UserMapper;
import com.my.graphql.model.OrderRequest;
import com.my.graphql.model.UserRequest;
import com.my.graphql.model.UserResponse;
import com.my.graphql.service.OrderService;
import com.my.graphql.service.UserService;

@Service
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private OrderService orderService;

	public UserResponse createUser(UserRequest userRequest) {
		return userMapper.toUserResponse(userService.createUser(userRequest));
	}

	public String placeOrder(Long id, OrderRequest orderRequest)
			throws UserNotFoundException, UnknownOrderTypeException {
		return orderService.placeOrder(id, orderRequest);
	}

}
