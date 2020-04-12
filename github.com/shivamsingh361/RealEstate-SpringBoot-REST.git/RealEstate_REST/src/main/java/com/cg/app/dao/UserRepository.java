package com.cg.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.dto.User;

public interface UserRepository extends CrudRepository<User, String> {

}
