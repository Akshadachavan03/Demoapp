package com.onlinetutorialspoint.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.onlinetutorialspoint.model.Person;
import com.onlinetutorialspoint.model.User;

public interface UserService {
	
		ResponseEntity<String> signup(Map<String, String> requestMap);
		public User getUserFromMap(Map<String, String> requestMap);
		

}
