package com.web.dao;

import org.springframework.data.repository.CrudRepository;

import com.web.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	
}
