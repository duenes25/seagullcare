package com.headhigh.seagullcare.dao;

import java.util.List;

import com.headhigh.seagullcare.model.Company;
import com.headhigh.seagullcare.model.Member;
import com.headhigh.seagullcare.model.StatusModel;

public interface SeagullCareDAO {

	List<Member> getMembers();
	
	Member getMemberInformation(final Member memberToRetrieve);
	
	StatusModel saveOrUpdateMember(final Member memberToSaveUpdate);
	
	StatusModel deleteMember(final Member memberToDelete);
	
	List<Company> getCompanies();
	
	Company getCompanyInformation(final Company companyToRetrieve);
	
	StatusModel saveOrUpdateCompany(final Company companyToSaveOrUpdate); 
	
	StatusModel deleteCompany(final Company companyToDelete);
	
}
