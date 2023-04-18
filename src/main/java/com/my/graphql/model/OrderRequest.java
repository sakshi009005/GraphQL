package com.my.graphql.model;

import java.util.List;

import lombok.Data;

@Data
public class OrderRequest {

	List<OrderDetails> orderDetails;
}
