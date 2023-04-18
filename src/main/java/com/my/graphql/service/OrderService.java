package com.my.graphql.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.graphql.entities.Fruit;
import com.my.graphql.entities.Order;
import com.my.graphql.entities.User;
import com.my.graphql.entities.Vegetable;
import com.my.graphql.exception.UnknownOrderTypeException;
import com.my.graphql.exception.UserNotFoundException;
import com.my.graphql.model.OrderDetails;
import com.my.graphql.model.OrderRequest;
import com.my.graphql.model.OrderType;
import com.my.graphql.model.OrdersResponse;
import com.my.graphql.model.UserOrders;
import com.my.graphql.repository.FruitRepository;
import com.my.graphql.repository.OrderRepository;
import com.my.graphql.repository.VegetableRepository;

@Service
public class OrderService {

	@Autowired
	private UserService userService;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private VegetableRepository vegetableRepository;

	@Autowired
	private FruitRepository fruitRepository;

	private Predicate<OrderType> VEGETABLE_PREDICATE = a -> a.equals(OrderType.VEGETABLE);

	private Predicate<OrderType> FRUIT_PREDICATE = a -> a.equals(OrderType.FRUIT);

	public String placeOrder(Long id, OrderRequest orderRequest)
			throws UserNotFoundException, UnknownOrderTypeException {

		User user = getUser(id);
		if (Objects.nonNull(user)) {
			Order order = saveOrder(user);
			placeOrderDetails(orderRequest, order);
		}
		return "Order Placed!!!";
	}

	private User getUser(Long id) throws UserNotFoundException {
		return userService.findUserById(id);
	}

	public UserOrders getOrdersByUserId(Long userId) throws UserNotFoundException {
		List<OrdersResponse> ordersResponses = new ArrayList<>();
		UserOrders userOrders = new UserOrders(ordersResponses);
		for (Order order : getOrdersForUser(userId)) {
			OrdersResponse ordersResponse = new OrdersResponse();
			ordersResponse.setOrderId((int) order.getId());
			ordersResponses.add(ordersResponse);
		}
		return userOrders;
	}

	private List<Order> getOrdersForUser(Long userId) throws UserNotFoundException {
		return orderRepository.findByUser(getUser(userId));
	}

	private void placeOrderDetails(OrderRequest orderRequest, Order order) throws UnknownOrderTypeException {
		for (OrderDetails orderDetail : orderRequest.getOrderDetails()) {
			if (VEGETABLE_PREDICATE.test(orderDetail.getOrderType())) {
				saveVegetable(order, orderDetail);
			} else if (FRUIT_PREDICATE.test(orderDetail.getOrderType())) {
				saveFruit(order, orderDetail);
			} else {
				throw new UnknownOrderTypeException("Unknown Order Type!!!");
			}
		}
	}

	private void saveFruit(Order order, OrderDetails orderDetail) {
		fruitRepository.save(getFruit(order, orderDetail));
	}

	private void saveVegetable(Order order, OrderDetails orderDetail) {
		vegetableRepository.save(getVegetable(order, orderDetail));
	}

	private Fruit getFruit(Order order, OrderDetails orderDetail) {
		return Fruit.builder().order(order).fruitName(orderDetail.getName()).quantity(orderDetail.getQuantity())
				.unit(orderDetail.getUnit()).build();
	}

	private Vegetable getVegetable(Order order, OrderDetails orderDetail) {
		return Vegetable.builder().order(order).vegetableName(orderDetail.getName()).quantity(orderDetail.getQuantity())
				.unit(orderDetail.getUnit()).build();
	}

	private Order saveOrder(User user) {
		Order order = new Order(user, new Date());
		order = orderRepository.save(order);
		return order;
	}
}
