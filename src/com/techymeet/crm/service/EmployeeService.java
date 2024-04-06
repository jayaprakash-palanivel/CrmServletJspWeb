/**
 * 
 */
package com.techymeet.crm.service;

import java.util.List;

import com.techymeet.crm.bo.EmployeeBo;

/**
 * @author Admin
 *
 */
public interface EmployeeService {
	public int createEmployee(EmployeeBo employeeBo);
	public List<EmployeeBo> listEmployee();
	public EmployeeBo viewEmployee(int employeeId);
	public boolean DeleteEmployee(int employeeId);
	int updateEmployee(EmployeeBo employeeBo);
	public List<EmployeeBo> searchEmployee(EmployeeBo employeeBo);
	public boolean verifyUser(String email);
}
