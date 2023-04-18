package com.my.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.graphql.entities.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
	List<Fruit> findByOrderId(Long id);
}
