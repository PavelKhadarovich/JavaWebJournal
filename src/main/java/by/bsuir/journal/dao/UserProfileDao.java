package by.bsuir.journal.dao;

import java.util.List;

import by.bsuir.journal.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
