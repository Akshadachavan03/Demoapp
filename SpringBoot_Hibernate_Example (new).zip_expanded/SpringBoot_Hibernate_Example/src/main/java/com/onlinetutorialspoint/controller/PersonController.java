package com.onlinetutorialspoint.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.onlinetutorialspoint.constents.CafeConstant;
import com.onlinetutorialspoint.dao.Login;
import com.onlinetutorialspoint.dao.UserDAO;
import com.onlinetutorialspoint.model.Person;
import com.onlinetutorialspoint.model.User;
import com.onlinetutorialspoint.service.LoginService;
import com.onlinetutorialspoint.service.PersonService;
import com.onlinetutorialspoint.service.UserService;
import com.onlinetutorialspoint.serviceImpl.UserServiceImpl;
import com.onlinetutorialspoint.utils.CafeUtils;

@RestController
@RequestMapping(value = "/user")
public class PersonController{
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	Login login;

	@GetMapping("/home")
	public String home() {
		return "home";
		
	}
	
	@PostMapping(path = "/signup")
	 public ResponseEntity<String> signup(@RequestBody(required = true) Map<String, String> requestMap) {
		 try { 
			 return userService.signup(requestMap); }
		 catch (Exception ex) {
			  ex.printStackTrace();  
		 }
			  return CafeUtils.getResponseEntity(CafeConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@PostMapping(path = "/login")
	 public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap ){
		
		try { return userService.login(requestMap); }catch (Exception ex) {
			  ex.printStackTrace(); } return
			  CafeUtils.getResponseEntity(CafeConstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR); 
	
			
}

	
	@GetMapping("login/{email}/{password}")
	public int UserLogin(@PathVariable("email") String email1, @PathVariable("password") String password1) {
		
		int flag = login.loginValidation(email1, password1);
		if(flag == 0) {
			return 0;
		}
		return flag;
		
	}
}
