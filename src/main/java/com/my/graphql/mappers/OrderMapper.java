package com.my.graphql.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.my.graphql.entities.Fruit;
import com.my.graphql.entities.Vegetable;
import com.my.graphql.model.OrderDetailsResponse;

@Mapper(componentModel = "spring")
public interface OrderMapper {

	@Mappings({ @Mapping(source = "vegetableName", target = "name"),
			@Mapping(target = "orderType", constant = "VEGETABLE") })
	OrderDetailsResponse toOrderDetails(Vegetable vegetable);

	@Mappings({ @Mapping(source = "fruitName", target = "name"), @Mapping(target = "orderType", constant = "FRUIT") })
	OrderDetailsResponse toOrderDetails(Fruit fruit);

	@Mappings({ @Mapping(source = "vegetableName", target = "name"),
			@Mapping(target = "orderType", constant = "VEGETABLE") })
	List<OrderDetailsResponse> fromVegetableDetails(List<Vegetable> vegetable);

	@Mappings({ @Mapping(source = "fruitName", target = "name"), @Mapping(target = "orderType", constant = "FRUIT") })
	List<OrderDetailsResponse> fromFruitDetails(List<Fruit> fruit);
}
