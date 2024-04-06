package com.techymeet.crm.service;

import java.util.List;

import com.techymeet.crm.bo.EmployeeBo;
import com.techymeet.crm.dao.EmployeeDao;
import com.techymeet.crm.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public int createEmployee(EmployeeBo employeeBo) {
		int status = dao.createEmployee(employeeBo);
		if (0 < status) {
			return status;
		} else {
			return status;
		}

		
	}

	@Override
	public List<EmployeeBo> listEmployee() {
		//List<EmployeeBo> list = dao.listEmployee();
		return  dao.listEmployee();
	}

	@Override
	public EmployeeBo viewEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return dao.viewEmployee(employeeId);
	}

	@Override
	public boolean DeleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		
		return dao.DeleteEmployee(employeeId);
		
	}

	@Override
	public int updateEmployee(EmployeeBo employeeBo) {
		// TODO Auto-generated method stub
		int status = dao.updateEmployee(employeeBo);
		if (0 < status) {
			return status;
		} else {
			return status;
		}
		
		//return dao.updateEmployee(employeeBo);
	}

	@Override
	public List<EmployeeBo> searchEmployee(EmployeeBo employeeBo) {
		
		return dao.searchEmployee(employeeBo);
	}

	@Override
	public boolean verifyUser(String email) {
		
		return dao.verifyUser(email);
	}
	

}
