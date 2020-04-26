package com.cg.app.services;

import java.util.List;

import com.cg.app.dto.InterestLog;
import com.cg.app.dto.User;
import com.cg.app.exceptions.UserAlreadyExistException;
import com.cg.app.exceptions.UserException;

public interface UserService {
	User addUser(User user) throws UserException, UserAlreadyExistException;
	User updateUser(User user) throws UserException;
	List<String> getAllUserIds() throws UserException;
	User checkCredentials(String id, String pass) throws UserException;
	void deleteUser(String userId) throws UserException;
	
	List<InterestLog> getInterestLists();
	InterestLog addInterest(InterestLog interest);
}
