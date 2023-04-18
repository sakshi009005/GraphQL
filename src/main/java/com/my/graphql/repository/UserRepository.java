package com.my.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.graphql.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
