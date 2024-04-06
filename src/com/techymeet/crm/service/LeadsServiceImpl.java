package com.techymeet.crm.service;

import java.util.List;

import com.techymeet.crm.bo.LeadsBo;
import com.techymeet.crm.dao.LeadsDao;
import com.techymeet.crm.dao.LeadsDaoImpl;

public class LeadsServiceImpl implements LeadsService {
	LeadsDao leadsDao=new LeadsDaoImpl();

	@Override
	public int createLeads(LeadsBo leadsBo) {
		int status=leadsDao.createLeads(leadsBo);
		if(0 < status) {
			return status;
		}else {
			return status;
		}
	}

	@Override
	public List<LeadsBo> listLeads() {
		return leadsDao.listLeads();
	}

	@Override
	public LeadsBo viewLeads(int leadsId) {
		return leadsDao.viewLeads(leadsId);
	}

	@Override
	public boolean deleteLeads(int leadsId) {
		return leadsDao.deleteLeads(leadsId);
	}

	@Override
	public int editLeads(LeadsBo leadsBo) {
		int status=leadsDao.updateLeads(leadsBo);
		if(0 < status) {
			return status;
		}else {
			return status;
		}
	}

	

	@Override
	public List<LeadsBo> searchLeads(LeadsBo leadsBo) {
		// TODO Auto-generated method stub
		return leadsDao.searchLeads(leadsBo);
	}

	

}
