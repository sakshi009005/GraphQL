package com.my.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
public class UserRequest {
	private String firstName;
	private String lastName;
	private int age;

}
