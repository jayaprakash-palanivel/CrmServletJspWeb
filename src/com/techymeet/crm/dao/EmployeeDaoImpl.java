package com.techymeet.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.techymeet.crm.bo.EmployeeBo;
import com.techymeet.crm.db.DatabaseConnection;

public class EmployeeDaoImpl implements EmployeeDao {
//EmployeeDao employee=new EmployeeDaoImpl();

	@Override
	public int createEmployee(EmployeeBo employeeBo) {

		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "insert into employee(employeeId,firstName, lastName, emailAddress, password, mobileNumber, dateofBirth, address, city, country) values('"
					+ employeeBo.getEmployeeId() + "','"+ employeeBo.getFirstName() + "','" + employeeBo.getLastName() + "','"
					+ employeeBo.getEmailAddress() + "','" + employeeBo.getPassword() + "',"
					+ employeeBo.getMobileNumber() + ",'" + employeeBo.getDateofBirth() + "','"
					+ employeeBo.getAddress() + "','" + employeeBo.getCity() + "','" + employeeBo.getCountry() + "')";
			System.out.println(query);
			int status = st.executeUpdate(query);

			if (0 < status) { // login table insertion
				String query1 = "insert into login(userName,password) values('" + employeeBo.getEmailAddress() + "','"
						+ employeeBo.getPassword() + "')";
				st.execute(query1);

				return status;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	@Override
	public List<EmployeeBo> listEmployee() {

		List<EmployeeBo> employeelist = new ArrayList<>();
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "SELECT * FROM employee ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				EmployeeBo employeeBo = new EmployeeBo();
				employeeBo.setEmployeeId(rs.getInt("employeeId"));
				employeeBo.setFirstName(rs.getString("firstName"));
				employeeBo.setLastName(rs.getString("lastName"));
				employeeBo.setDateofBirth(rs.getString("dateofBirth"));
				employeeBo.setEmailAddress(rs.getString("emailAddress"));
				employeeBo.setPassword(rs.getString("password"));
				employeeBo.setMobileNumber(rs.getLong("mobileNumber"));
				employeeBo.setAddress(rs.getString("address"));
				employeeBo.setCity(rs.getString("city"));
				employeeBo.setCountry(rs.getString("country"));

				employeelist.add(employeeBo);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeelist;

	}

	@Override
	public EmployeeBo viewEmployee(int employeeId) {

		EmployeeBo employeeBo = new EmployeeBo();
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "select *from employee where  employeeId=" + employeeId;
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				employeeBo.setEmployeeId(rs.getInt("employeeId"));
				employeeBo.setFirstName(rs.getString("firstName"));
				employeeBo.setLastName(rs.getString("lastName"));
				employeeBo.setDateofBirth(rs.getString("dateofBirth"));
				employeeBo.setEmailAddress(rs.getString("emailAddress"));
				employeeBo.setPassword(rs.getString("password"));
				employeeBo.setMobileNumber(rs.getLong("mobileNumber"));
				employeeBo.setAddress(rs.getString("address"));
				employeeBo.setCity(rs.getString("city"));
				employeeBo.setCountry(rs.getString("country"));

			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeBo;

	}

	@Override
	public boolean DeleteEmployee(int employeeId) {
		// EmployeeBo employeeBo=new EmployeeBo();
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "delete from employee where employeeId=" + employeeId;
			int status = st.executeUpdate(query);

			if (0 < status) {

				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int updateEmployee(EmployeeBo employee) {

		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "update  employee set lastName='" + employee.getLastName() + "', emailAddress='"
					+ employee.getEmailAddress() + "',firstName='" + employee.getFirstName() + "',mobileNumber="
					+ employee.getMobileNumber() + ",dateofBirth='" + employee.getDateofBirth() + "',address='"
					+ employee.getAddress() + "',city='" + employee.getCity() + "',country='" + employee.getCountry()
					+ "' where employeeId=" + employee.getEmployeeId();
			int s = st.executeUpdate(query);
			if (0 < s) {
				return s;
			} else {
				return s;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public List<EmployeeBo> searchEmployee(EmployeeBo employeeBo) {
		List<EmployeeBo> employeeList = new ArrayList<EmployeeBo>();
		String firstNameQuery = null;
		String emailQuery = null;
		String mobileQuery = null;
		String wholeSearchQuery = null;
		ResultSet rs = null;
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			if (null != employeeBo.getFirstName() && null != employeeBo.getEmailAddress()
					&& 0 < employeeBo.getMobileNumber()) {
				wholeSearchQuery = "select * from employee where (firstName like '" + employeeBo.getFirstName()
						+ "%' or emailAddress like '" + employeeBo.getEmailAddress() + "%' or mobileNumber like '"
						+ employeeBo.getMobileNumber() + "%')";
				rs = st.executeQuery(wholeSearchQuery);

			} else if (null != employeeBo.getFirstName() || null != employeeBo.getEmailAddress()
					|| 0 < employeeBo.getMobileNumber()) {
				if (null != employeeBo.getFirstName()) {
					firstNameQuery = "select * from employee where firstName like '" + employeeBo.getFirstName() + "%'";
					rs = st.executeQuery(firstNameQuery);
				} else if (null != employeeBo.getEmailAddress()) {
					emailQuery = "select * from employee where emailAddress like '" + employeeBo.getEmailAddress()
							+ "%'";
					rs = st.executeQuery(emailQuery);
				} else if (0 < employeeBo.getMobileNumber()) {
					mobileQuery = "select * from employee where mobileNumber like '" + employeeBo.getMobileNumber()
							+ "%'";
					rs = st.executeQuery(mobileQuery);
				}
			}

			while (rs.next()) {
				EmployeeBo employee = new EmployeeBo();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setFirstName(rs.getString("firstName"));
				employee.setLastName(rs.getString("lastName"));
				employee.setDateofBirth(rs.getString("dateofBirth"));
				employee.setEmailAddress(rs.getString("emailAddress"));
				employee.setPassword(rs.getString("password"));
				employee.setMobileNumber(rs.getLong("mobileNumber"));
				employee.setAddress(rs.getString("address"));
				employee.setCity(rs.getString("city"));
				employee.setCountry(rs.getString("country"));

				employeeList.add(employee);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;

	}

	@Override
	public boolean verifyUser(String email) {
		try {

			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "select * from login where userName='" +email+"'";
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
                  return true;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return false;
	}

}