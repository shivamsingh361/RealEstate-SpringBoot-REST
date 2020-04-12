package com.cg.app.services;

import java.util.List;
import java.util.Optional;

import com.cg.app.dto.Property;

public interface PropertyService {
	Property addProperty(Property prop);
	void deleteProperty(int id);
	List<Property> getPropertyByType(String propType);
	Optional<Property> getPropertyById(int id);
	List<Property> getAllProperty();
}
