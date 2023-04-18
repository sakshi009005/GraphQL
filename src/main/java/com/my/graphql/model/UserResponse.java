package com.my.graphql.model;

import lombok.Data;

@Data
public class UserResponse {

	private long id;
	private String firstName;
	private String lastName;
	private int age;

}
