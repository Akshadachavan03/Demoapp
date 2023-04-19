package com.onlinetutorialspoint.serviceImpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.constents.CafeConstant;
import com.onlinetutorialspoint.dao.UserDAO;

import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.service.UserService;
import com.onlinetutorialspoint.utils.CafeUtils;

//import lombok.extern.java.Log;
//import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class UserServiceImpl implements UserService{

		@Autowired 
		UserDAO userDao;
	
	
	@Override
	public ResponseEntity<String> signup(Map<String, String> requestMap) {
		//log.info("Inside signup {}", requestMap);
		try {
		if(validateSignUpMap(requestMap)){
			User user = userDao.findByEmailId(requestMap.get("email"));
			if(Objects.isNull(user)) {
					userDao.save(getUserFromMap(requestMap));
					return CafeUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
					
			}
			else {
				return CafeUtils.getResponseEntity("Email already exits.", HttpStatus.BAD_REQUEST);
			}
	
			
		}
		else {
			return CafeUtils.getResponseEntity(CafeConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}

		
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return CafeUtils.getResponseEntity(CafeConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
		
		//return null;
	}

	
	private boolean validateSignUpMap(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("mobileNo") 
				&& requestMap.containsKey("email") && requestMap.containsKey("password"))
		{
			return true;
		}
			
		
		return false;
		
	}
	
	public User getUserFromMap(Map<String, String> requestMap) {
		
		User user = new User();
		user.setFirstName(requestMap.get("name"));
		user.setMobileNo(requestMap.get("mobileNo"));
		user.setemail(requestMap.get("email"));
		user.setPassword(requestMap.get("password"));
		user.setStatus("false");
		user.setRole("user");
		return user;
		
		//return null;
		
	}


	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		
		return null;
	}
}
