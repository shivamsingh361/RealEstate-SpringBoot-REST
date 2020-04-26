package com.cg.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.app.dto.PropertyImage;

public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long> {
	List<PropertyImage> findPropertyImageByPropId(long propId);
}

