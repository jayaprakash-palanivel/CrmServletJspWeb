package com.techymeet.crm.service;

import java.util.List;

import com.techymeet.crm.bo.LeadsBo;

public interface LeadsService {
	
	public int createLeads(LeadsBo leadsBo);
	
	public List<LeadsBo> listLeads();
	
	public LeadsBo viewLeads(int leadsId);
	
	public boolean deleteLeads(int leadsId);
	
	public int editLeads(LeadsBo leadsBo);
	
	public List<LeadsBo> searchLeads(LeadsBo leadsBo);

	
	
	

}
