package com.onlinetutorialspoint.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import com.onlinetutorialspoint.dao.UserDAO;
import com.onlinetutorialspoint.model.User;

@Service
public class CutomerUserDetailsService implements UserDetailsService {

	@Autowired
	UserDAO userDAO;
	
	//private com.onlinetutorialspoint.model.User user;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user=userDAO.findByEmail(email);
		if(user!=null)
		{
			return (UserDetails) new Customer(user);
		}
		 throw new UsernameNotFoundException("user not available");
	}
}

//		userDetails = userDAO.findByEmailId(email);
//		if(!Objects.isNull(userDetails))
//			return new org.springframework.security.core.userdetails.User(userDetails.getEmail(),userDetails.getPassword(),new ArrayList<>()) ; 
//		else
//			throw new UsernameNotFoundException("User not found.");
//	}
//	
//	public com.onlinetutorialspoint.model.User getUserDetails(){
//		return userDetails;
//	}
		
	

