package com.my.graphql.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.my.graphql.entities.Fruit;
import com.my.graphql.entities.Vegetable;
import com.my.graphql.mappers.OrderMapper;
import com.my.graphql.model.OrderDetailsResponse;
import com.my.graphql.model.OrderType;
import com.my.graphql.model.OrdersResponse;
import com.my.graphql.repository.FruitRepository;
import com.my.graphql.repository.VegetableRepository;

@Service
public class OrderDetailsResolver implements GraphQLResolver<OrdersResponse> {

	@Autowired
	FruitRepository fruitRepository;

	@Autowired
	VegetableRepository vegetableRepository;

	@Autowired
	OrderMapper orderMapper;

	public List<OrderDetailsResponse> getOrderDetails(OrdersResponse ordersResponse, OrderType orderType) {
		List<OrderDetailsResponse> orderDetails = new ArrayList<>();
		populateOrderDetails(ordersResponse, orderType, orderDetails);
		ordersResponse.setOrderDetails(orderDetails);
		return orderDetails;
	}

	private void populateOrderDetails(OrdersResponse ordersResponse, OrderType orderType,
			List<OrderDetailsResponse> orderDetails) {
		if (orderType.equals(OrderType.VEGETABLE)) {
			populateVegetables(ordersResponse.getOrderId(), orderDetails);
		}
		if (orderType.equals(OrderType.FRUIT)) {
			populateFruits(ordersResponse.getOrderId(), orderDetails);
		}
	}

	private void populateFruits(int orderId, List<OrderDetailsResponse> orderDetails) {
		List<Fruit> fruits = fruitRepository.findByOrderId((long) orderId);
		orderDetails.addAll(orderMapper.fromFruitDetails(fruits));
	}

	private void populateVegetables(int orderId, List<OrderDetailsResponse> orderDetails) {
		List<Vegetable> vegetables = vegetableRepository.findByOrderId((long) orderId);
		orderDetails.addAll(orderMapper.fromVegetableDetails(vegetables));
	}

}
