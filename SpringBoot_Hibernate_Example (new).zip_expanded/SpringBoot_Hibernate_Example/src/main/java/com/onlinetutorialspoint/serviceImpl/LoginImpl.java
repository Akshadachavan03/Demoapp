package com.onlinetutorialspoint.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.onlinetutorialspoint.dao.Login;

@Service
public class LoginImpl implements Login {

	Connection connection;
	int flag = 0;
	public LoginImpl() throws SQLException{
		
	}
	
	@Override
	public int loginValidation(String email, String password) {
		
		try {
			PreparedStatement statement= connection.prepareStatement("SELECT * FROM users WHERE email = '"+email+"'");
			ResultSet rs = statement.executeQuery();		
		
		while (rs.next()) {
			if(rs.getString(6).equals(email) && rs.getString(5).equals(password)) {
				flag = 1;
			}else {
				System.out.println("Invalid email/password");
				flag = 0;
			}
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	
}
