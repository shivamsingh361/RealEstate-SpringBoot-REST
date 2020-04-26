package com.cg.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.dao.InterestListRepository;
import com.cg.app.dao.UserRepository;
import com.cg.app.dto.InterestLog;
import com.cg.app.dto.User;
import com.cg.app.exceptions.UserAlreadyExistException;
import com.cg.app.exceptions.UserException;
import com.cg.app.exceptions.UserNotFoundException;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	InterestListRepository intrestRepo;
	@Override
	public User addUser(User user) throws UserException, UserAlreadyExistException {
		if(userRepo.existsById(user.getUserId()))
			throw new UserAlreadyExistException("Entered UserID already register!");
		try {
			return userRepo.save(user);
		} catch (Exception e) {
			throw new UserException("An Error occured while adding new User!: ",e);
		}
	}

	@Override
	public User updateUser(User user) throws UserException {
		if(userRepo.existsById(user.getUserId()))
			return userRepo.save(user);
		else
			throw new UserException("Invalid user Object received! Can't Update.");
	}

	@Override
	public List<String> getAllUserIds() throws UserException {
		List<String> userIds = new ArrayList<String>();
		try {
			for(User user: userRepo.findAll()) {
				userIds.add(user.getUserId());
			}
			return userIds;
		} catch (Exception e) {
			throw new UserException("An Error occured while fetching User by ID. : ",e);
		}
	}

	@Override
	public User checkCredentials(String id, String pass) throws UserException {
		if(userRepo.existsById(id)) {
			Optional<User> user = userRepo.findById(id);
			if(user.get().getPass().equals(pass))
				return user.get();
			else
				throw new UserNotFoundException("Invalid Credentails");
		}
		else
			throw new UserNotFoundException("UserId Dosen't Exist");
	}

	@Override
	public List<InterestLog> getInterestLists() {
		return (List<InterestLog>) intrestRepo.findAll();
	}

	@Override
	public InterestLog addInterest(InterestLog interest) {
		return intrestRepo.save(interest);
	}

	@Override
	public void deleteUser(String userId) throws UserException {
		try {
			userRepo.deleteById(userId);
		} catch (Exception e) {
			throw new UserException("An Error occured while deleting User!: ",e);
		}
	}

}
