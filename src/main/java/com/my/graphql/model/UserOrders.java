package com.my.graphql.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserOrders {

	List<OrdersResponse> orders;
}
