package com.onlinetutorialspoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.onlinetutorialspoint.dao.PersonDAO;
import com.onlinetutorialspoint.dao.UserDAO;
import com.onlinetutorialspoint.model.User;

@Service
public class LoginService {

	@Autowired
	private UserDAO userDao;
	
	public User login(String email, String password) {
		
		User user=  userDao.findByEmailAndPassword(email, password);
		return null;
		
	}
	
}
