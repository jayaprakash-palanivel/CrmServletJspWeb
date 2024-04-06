package com.techymeet.crm.dao;

import java.util.List;

import com.techymeet.crm.bo.EmployeeBo;

public interface EmployeeDao {
	public  int createEmployee(EmployeeBo employeeBo);
	public List<EmployeeBo> listEmployee();
	public EmployeeBo viewEmployee(int employeeId);
	public boolean DeleteEmployee(int employeeId);
	public int updateEmployee(EmployeeBo employeeBo);
	public List<EmployeeBo> searchEmployee(EmployeeBo employeeBo);
	public boolean verifyUser(String email);
}
