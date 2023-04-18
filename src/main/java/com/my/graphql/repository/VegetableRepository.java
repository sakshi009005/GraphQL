package com.my.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.graphql.entities.Vegetable;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
	List<Vegetable> findByOrderId(Long orderId);

}
