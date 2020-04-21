package com.cg.app.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.PropertyRepository;
import com.cg.app.dto.Property;
import com.cg.app.exceptions.PropertyException;
@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	PropertyRepository propRepo;
	@Override
	public Property addProperty(Property prop) throws PropertyException {
		try {
			return propRepo.save(prop);
		} catch (Exception e) {
			throw new PropertyException("An Error Occured while adding property.", e);
		}
	}

	@Override
	public void deleteProperty(int id) throws PropertyException {
		try {
			propRepo.deleteById(id);
		} catch (Exception e) {
			throw new PropertyException("An Error Occured while deleting property.", e);
		}
	}

	@Override
	public List<Property> getPropertyByType(String propType) throws PropertyException {
		try {
			return propRepo.findPropertyByPropType(propType);
		} catch (Exception e) {
			throw new PropertyException("An Error Occured while fetching property by TYPE.", e);
		}
	}

	@Override
	public Optional<Property> getPropertyById(int id) throws PropertyException {
		try {
			return propRepo.findById(id);
		} catch (Exception e) {
			throw new PropertyException("An Error Occured while fetching property by ID.", e);
		}
	}

	@Override
	public List<Property> getAllProperty() throws PropertyException {
		try {
			return (List<Property>) propRepo.findAll();
		} catch (Exception e) {
			throw new PropertyException("An Error Occured while fetching all property list.", e);
		}
	}

}
