package by.bsuir.journal.service;

import java.util.List;

import by.bsuir.journal.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
