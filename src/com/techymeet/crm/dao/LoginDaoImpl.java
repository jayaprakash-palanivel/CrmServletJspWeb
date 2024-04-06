package com.techymeet.crm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.techymeet.crm.bo.LoginBo;
import com.techymeet.crm.db.DatabaseConnection;

public class LoginDaoImpl implements LoginDao{

	@Override
	public LoginBo LoginEmployee(LoginBo loginBo) {
		LoginBo loginBo1=new LoginBo();
		
		try {
			
			Connection con=DatabaseConnection.getConnection();
			Statement st=con.createStatement();
			String query="select * from login where userName='"+loginBo.getUserName()+"'and password='"+loginBo.getPassword()+"'";
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()) {
				
				loginBo1.setUserName(rs.getString("userName")); 
				loginBo1.setPassword(rs.getString("password"));
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
	}
		return loginBo1;
	}


	

}
