package com.cg.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.dto.Property;

public interface PropertyRepository extends CrudRepository<Property, Integer> {
	List<Property> findPropertyByPropType(String type);
}
