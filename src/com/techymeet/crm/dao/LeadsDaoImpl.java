package com.techymeet.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.techymeet.crm.bo.EmployeeBo;
import com.techymeet.crm.bo.LeadsBo;
import com.techymeet.crm.db.DatabaseConnection;

public class LeadsDaoImpl implements LeadsDao{

	public static void main(String[] args) {

	}

	@Override
	public int createLeads(LeadsBo leadsBo) {
		
		try {
		Connection con=DatabaseConnection.getConnection();
		Statement st=con.createStatement();
		String sql="insert into crm.leads (leadsId,firstName,lastName,emailAddress,mobileNumber,companyName,salary,address,city,state,country)values('"+leadsBo.getLeadsId()+"','"+leadsBo.getFirstName()+"','"+leadsBo.getLastName()+"','"
				         +leadsBo.getEmailAddress()+"','"+leadsBo.getMobileNumber()+"','"+leadsBo.getCompanyName()+"','"+leadsBo.getSalary()+"','"
				         +leadsBo.getAddress()+"','"+leadsBo.getCity()+"','"+leadsBo.getState()+"','"+leadsBo.getCountry()+"')";
		int status=st.executeUpdate(sql);
		st.close();
		con.close();
		
		if (0 < status) {
			return status;
		} else {
			return status;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<LeadsBo> listLeads() {
		Connection con=DatabaseConnection.getConnection();
		List<LeadsBo> leadsList=new ArrayList<>();
		try {
			Statement st=con.createStatement();
			String sql="select *from leads ";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				
				LeadsBo leadsBo=new LeadsBo();
				leadsBo.setLeadsId(rs.getInt("leadsId"));
				leadsBo.setFirstName(rs.getString("firstName"));
				leadsBo.setLastName(rs.getString("lastName"));
				leadsBo.setEmailAddress(rs.getString("emailAddress"));
				leadsBo.setMobileNumber(rs.getLong("mobileNumber"));
				leadsBo.setCompanyName(rs.getString("companyName"));
				leadsBo.setSalary(rs.getString("salary"));
				leadsBo.setAddress(rs.getString("address"));
				leadsBo.setCity(rs.getString("city"));
				leadsBo.setState(rs.getString("state"));
				leadsBo.setCountry(rs.getString("country"));
				
				leadsList.add(leadsBo);
				}
			st.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return leadsList;
	
	}

	@Override
	public LeadsBo viewLeads(int leadsId) {
		LeadsBo leadsBo=new LeadsBo();
		try {
		Connection con = DatabaseConnection.getConnection();
		Statement st = con.createStatement();
		String query = "select *from leads where  leadsId=" + leadsId;
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			leadsBo.setLeadsId(rs.getInt("leadsId"));
			leadsBo.setFirstName(rs.getString("firstName"));
			leadsBo.setLastName(rs.getString("lastName"));
			leadsBo.setEmailAddress(rs.getString("emailAddress"));
			leadsBo.setMobileNumber(rs.getLong("mobileNumber"));
			leadsBo.setCompanyName(rs.getString("companyName"));
			leadsBo.setSalary(rs.getString("salary"));
			leadsBo.setAddress(rs.getString("address"));
			leadsBo.setCity(rs.getString("city"));
			leadsBo.setState(rs.getString("state"));
			leadsBo.setCountry(rs.getString("country"));

		}
		st.close();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return leadsBo;

	}

	@Override
	public boolean deleteLeads(int leadsId) {
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "delete from leads where leadsId=" + leadsId;
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
	public int updateLeads(LeadsBo leadsBo) {
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			
			String query = "update  leads set firstName='" + leadsBo.getFirstName() + "',lastName='" + leadsBo.getLastName() + "', emailAddress='"
					+ leadsBo.getEmailAddress() + "',mobileNumber="+ leadsBo.getMobileNumber() + ",companyName='" + leadsBo.getCompanyName() + "',salary='" + leadsBo.getSalary() + "',address='"
					+ leadsBo.getAddress() + "',city='" + leadsBo.getCity() + "',state='" + leadsBo.getState()+ "',country='" + leadsBo.getCountry()
					+ "' where leadsId=" + leadsBo.getLeadsId();
			
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

	@Override
	public List<LeadsBo> searchLeads(LeadsBo leadsBo) {
		
		List<LeadsBo> leadsList = new ArrayList<LeadsBo>();
		
		String firstNameQuery = null;
		String emailAddressQuery = null;
		String wholeSearchQuery = null;
		ResultSet rs = null;
		
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			
			if (null != leadsBo.getFirstName() && null != leadsBo.getEmailAddress()) {
				wholeSearchQuery = "select * from leads where (firstName like '" + leadsBo.getFirstName()
						+ "%' or emailAddress like '" + leadsBo.getEmailAddress() + "%' )";
				rs = st.executeQuery(wholeSearchQuery);
				
			} else if (null != leadsBo.getFirstName() || null != leadsBo.getEmailAddress()) {
				
				if (null != leadsBo.getFirstName()) {
					firstNameQuery = "select * from leads where firstName like '" + leadsBo.getFirstName() + "%'";
					rs = st.executeQuery(firstNameQuery);
					
				} else if (null != leadsBo.getEmailAddress()) {
					emailAddressQuery = "select * from leads where emailAddress like '" + leadsBo.getEmailAddress()+ "%'";
					rs = st.executeQuery(emailAddressQuery);
				}
				}
			
			while (rs.next()) {
				LeadsBo leadsbo = new LeadsBo();
				
				leadsbo.setLeadsId(rs.getInt("leadsId"));
				leadsbo.setFirstName(rs.getString("firstName"));
				leadsbo.setLastName(rs.getString("lastName"));
				leadsbo.setEmailAddress(rs.getString("emailAddress"));
				leadsbo.setMobileNumber(rs.getLong("mobileNumber"));
				leadsbo.setCompanyName(rs.getString("companyName"));
				leadsbo.setSalary(rs.getString("salary"));
				leadsbo.setAddress(rs.getString("address"));
				leadsbo.setCity(rs.getString("city"));
				leadsbo.setState(rs.getString("state"));
				leadsbo.setCountry(rs.getString("country"));

				leadsList.add(leadsbo);
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return leadsList;
	}

	@Override
	public boolean verifyUser(String emailAddress) {
		try {

			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			String query = "select * from login where userName='" +emailAddress+"'";
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
