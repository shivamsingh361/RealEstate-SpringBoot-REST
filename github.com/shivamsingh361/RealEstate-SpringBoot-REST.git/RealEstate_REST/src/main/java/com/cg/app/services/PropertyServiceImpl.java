package com.cg.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.PropertyRepository;
import com.cg.app.dto.Property;
@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyRepository propRepo;
	@Override
	public Property addProperty(Property prop) {
		return propRepo.save(prop);
	}

	@Override
	public void deleteProperty(int id) {
		propRepo.deleteById(id);
	}

	@Override
	public List<Property> getPropertyByType(String propType) {
		return propRepo.findPropertyByPropType(propType);
	}

	@Override
	public Optional<Property> getPropertyById(int id) {
		return propRepo.findById(id);
	}

	@Override
	public List<Property> getAllProperty() {
		return (List<Property>) propRepo.findAll();
	}

}
