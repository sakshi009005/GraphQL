package com.my.graphql.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.graphql.entities.User;
import com.my.graphql.exception.UserNotFoundException;
import com.my.graphql.mappers.UserMapper;
import com.my.graphql.model.UserRequest;
import com.my.graphql.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	public User createUser(UserRequest userData) {
		return userRepository.save(userMapper.toUser(userData));
	}

	public User findUserById(Long userId) throws UserNotFoundException {
		return Optional.ofNullable(userRepository.findById(userId)).get()
				.orElseThrow(() -> new UserNotFoundException("User Not Found!!!"));
	}

}
