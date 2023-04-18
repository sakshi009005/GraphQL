package com.my.graphql.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrdersResponse {

	private int orderId;
	List<OrderDetailsResponse> orderDetails;

}
