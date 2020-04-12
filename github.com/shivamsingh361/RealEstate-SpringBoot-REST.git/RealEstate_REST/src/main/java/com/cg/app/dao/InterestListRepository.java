package com.cg.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.cg.app.dto.InterestLog;

public interface InterestListRepository extends CrudRepository<InterestLog, String> {
	
}
