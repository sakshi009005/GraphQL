package com.my.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.my.graphql.exception.UserNotFoundException;
import com.my.graphql.mappers.UserMapper;
import com.my.graphql.model.UserOrders;
import com.my.graphql.model.UserResponse;
import com.my.graphql.service.OrderService;
import com.my.graphql.service.UserService;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	UserService userService;

	@Autowired
	UserMapper userMapper;

	@Autowired
	OrderService orderService;

	public UserResponse findUserById(Long id) throws UserNotFoundException {
		return userMapper.toUserResponse(userService.findUserById(id));
	}

	public UserOrders getOrdersByUserId(Long userId) throws UserNotFoundException {
		return orderService.getOrdersByUserId(userId);
	}

}
