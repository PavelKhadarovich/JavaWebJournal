package by.bsuir.journal.service.impl;

import by.bsuir.journal.dao.UserProfileDao;
import by.bsuir.journal.dao.impl.UserProfileDaoImpl;
import by.bsuir.journal.service.UserProfileService;
import by.bsuir.journal.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileDao dao;

	public UserProfileServiceImpl(){}
	public UserProfileServiceImpl(UserProfileDaoImpl dao){
		this.dao = dao;
	}

	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	public UserProfile findByType(String type){
		return dao.findByType(type);
	}

	public List<UserProfile> findAll() {
		return dao.findAll();
	}
}
