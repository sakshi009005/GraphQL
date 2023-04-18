package com.my.graphql.model;

import lombok.Data;

@Data
public class OrderDetailsResponse {

	private OrderType orderType;
	private String name;
	private int quantity;
	private String unit;

}
