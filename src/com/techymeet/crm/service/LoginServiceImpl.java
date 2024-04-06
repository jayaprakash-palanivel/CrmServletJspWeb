package com.techymeet.crm.service;


import com.techymeet.crm.bo.LoginBo;
import com.techymeet.crm.dao.LoginDao;
import com.techymeet.crm.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	LoginDao dao = new LoginDaoImpl();

	@Override
	
		public LoginBo LoginEmployee(LoginBo loginBo) {
		return dao.LoginEmployee(loginBo);
		
	}

}
