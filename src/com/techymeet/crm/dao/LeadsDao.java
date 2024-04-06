package com.techymeet.crm.dao;

import java.util.List;

import com.techymeet.crm.bo.LeadsBo;

public interface LeadsDao {
	
    public int createLeads(LeadsBo leadsBo);
	
	public List<LeadsBo> listLeads();
	
	public LeadsBo viewLeads(int leadsId);
	
	public boolean deleteLeads(int leadsId);
	
	
    int updateLeads(LeadsBo leadsBo);
	
	public List<LeadsBo> searchLeads(LeadsBo leadsBo);
	
	public boolean verifyUser(String emailAddress);
	

}
