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
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	InterestListRepository intrestRepo;
	@Override
	public User addUser(User user) {
		userRepo.save(user);
		return null;
	}

	@Override
	public User updateUser(User user) {
		userRepo.save(user);
		return null;
	}

	@Override
	public List<String> getAllUserIds() {
		List<String> userIds = new ArrayList<String>();
		for(User user: userRepo.findAll()) {
			userIds.add(user.getUserId());
		}
		return userIds;
	}

	@Override
	public User checkCredentials(String id, String pass) {
		if(userRepo.existsById(id)) {
			Optional<User> user = userRepo.findById(id);
			if(user.get().getPass().equals(pass))
				return user.get();
		}
		return null;
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
	public void deleteUser(String userId) {
		try {
			userRepo.deleteById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
