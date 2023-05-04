package com.onlinetutorialspoint.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface Login {

	public int loginValidation(String email, String password);
	
}
