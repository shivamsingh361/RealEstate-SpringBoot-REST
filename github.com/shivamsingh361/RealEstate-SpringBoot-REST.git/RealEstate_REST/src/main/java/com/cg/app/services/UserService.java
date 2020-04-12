package com.cg.app.services;

import java.util.List;

import com.cg.app.dto.InterestLog;
import com.cg.app.dto.User;

public interface UserService {
	User addUser(User user);
	User updateUser(User user);
	List<String> getAllUserIds();
	User checkCredentials(String id, String pass);
	void deleteUser(String userId);
	
	List<InterestLog> getInterestLists();
	InterestLog addInterest(InterestLog interest);
}
