package com.cg.app.services;

import java.util.List;
import java.util.Optional;


import com.cg.app.dto.Property;
import com.cg.app.exceptions.PropertyException;

public interface PropertyService {
	Property addProperty(Property prop) throws PropertyException;
	void deleteProperty(int id) throws PropertyException;
	List<Property> getPropertyByType(String propType) throws PropertyException;
	Optional<Property> getPropertyById(int id) throws PropertyException;
	List<Property> getAllProperty() throws PropertyException;
}
