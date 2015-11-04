package com.headhigh.seagullcare.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.headhigh.seagullcare.helper.SeagullConstants;
import com.headhigh.seagullcare.model.Company;
import com.headhigh.seagullcare.model.Member;
import com.headhigh.seagullcare.model.StatusModel;

public class SeagullCareDAOImpl implements SeagullCareDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(SeagullCareDAOImpl.class);
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getCompanies() {
		logger.info("Entered  getCompanies");
		Session session = null;
		List<Company> companyList = new ArrayList<Company>();
		try{
			session = this.sessionFactory.openSession();			
			Criteria criteria = session.createCriteria(Company.class);
			companyList = criteria.list();
		}catch(Exception e){
			logger.error("Error occurred: " + e.getMessage());
		}finally{
			session.close();
		}
		return companyList;
	}
	
	
	@Override
	public Company getCompanyInformation(Company companyToRetrieve) {
		logger.info("Entered  getCompanyInformation");
		Session session = null;
		Company company = new Company();
		try{
			session = this.sessionFactory.openSession();
			
			Criteria criteria = session.createCriteria(Company.class);
			if(companyToRetrieve.getId() != null){
				criteria.add(Restrictions.eq("id",companyToRetrieve.getId()));
			}
			if(companyToRetrieve.getCompanyName()!=null){
				criteria.add(Restrictions.eq("companyName",companyToRetrieve.getCompanyName()));
			}
			if(companyToRetrieve.getCompanyAddress()!=null){
				criteria.add(Restrictions.eq("companyAddress",companyToRetrieve.getCompanyAddress()));
			}
			if(companyToRetrieve.getCompanyPhone()!=null){
				criteria.add(Restrictions.eq("companyPhone",companyToRetrieve.getCompanyPhone()));
			}
			if(companyToRetrieve.getPointOfContactEmail()!=null){
				criteria.add(Restrictions.eq("pointOfContactEmail",companyToRetrieve.getPointOfContactEmail()));
			}
			if(companyToRetrieve.getPointOfContactName()!=null){
				criteria.add(Restrictions.eq("pointOfContactName",companyToRetrieve.getPointOfContactName()));
			}
			if(companyToRetrieve.getPointOfContactPhone()!=null){
				criteria.add(Restrictions.eq("pointOfContactPhone",companyToRetrieve.getPointOfContactPhone()));
			}
			
			company = (Company) criteria.uniqueResult();
					
		}catch(Exception e){
			logger.error("Error occurred: " + e.getMessage());
		}finally{
			session.close();
		}
		return company;
	}

	@Override
	public StatusModel saveOrUpdateCompany(Company companyToSaveOrUpdate) {
		logger.info("Entered  saveOrUpdateCompany");
		Session session = null;
		StatusModel status = new StatusModel();
		try{
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(companyToSaveOrUpdate);
	        tx.commit();
	        status.setError(false);
	        status.setErrorMessage("Success");
		}catch(ConstraintViolationException e){
			logger.error("Error occurred :" + e.getMessage());
			status.setError(true);
			status.setErrorMessage(SeagullConstants.DUPLICATE_ENTRY);
		}
		catch(Exception e){
			logger.error("Error occurred :" + e.getMessage());
			status.setError(true);
			status.setErrorMessage(SeagullConstants.SYSTEM_ERROR);
		}
	    finally{
			session.close();
		}
		return status;
	}

	@Override
	public StatusModel deleteCompany(Company companyToDelete) {
		logger.info("Entered  deleteCompany");
		Session session = null;
		StatusModel status = new StatusModel();
		try{
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Company comp = getCompanyInformation(companyToDelete);
			if(comp != null){
				session.delete(comp);
			}
			
	        tx.commit();
	        status.setError(false);
	        status.setErrorMessage("Success");
		}catch(Exception e){
			logger.error("Error occurred :" + e.getMessage());
			status.setError(true);
			status.setErrorMessage(SeagullConstants.SYSTEM_ERROR);
		}finally{
			session.close();
		}
		return status;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getMembers() {
		logger.info("Entered  getMembers");
		Session session = null;
		List<Member> memberList = new ArrayList<Member>();
		try{
			session = this.sessionFactory.openSession();
			
			
			Criteria criteria = session.createCriteria(Member.class);
			
				
			//member = (Member) criteria.uniqueResult();
					
			
			memberList = criteria.list();
		}catch(Exception e){
			logger.error("Error occurred: " + e.getMessage());
		}finally{
			session.close();
		}
		return memberList;
	}

	
	@Override
	public Member getMemberInformation(Member memberToRetrieve) {
		logger.info("Entered  getMemberInformation");
		Session session = null;
		Member member = new Member();
		try{
			session = this.sessionFactory.openSession();
			//member = (Member) session.createQuery("from Member where ID = " + memberToRetrieve.getId()).uniqueResult();
			//session.get(Member.class, )
			
			Criteria criteria = session.createCriteria(Member.class);
			if(memberToRetrieve.getId() != null){
				criteria.add(Restrictions.eq("id",memberToRetrieve.getId()));
			}
			if(memberToRetrieve.getMemberEmail()!=null){
				criteria.add(Restrictions.eq("memberEmail",memberToRetrieve.getMemberEmail()));
			}
			if(memberToRetrieve.getMemberName()!=null){
				criteria.add(Restrictions.eq("memberName",memberToRetrieve.getMemberName()));
			}
			if(memberToRetrieve.getMemberPhone()!=null){
				criteria.add(Restrictions.eq("memberPhone",memberToRetrieve.getMemberPhone()));
			}
			
				
			member = (Member) criteria.uniqueResult();
					
		}catch(Exception e){
			logger.error("Error occurred: " + e.getMessage());
		}finally{
			session.close();
		}
		return member;
	}
	
	
	@Override
	public StatusModel saveOrUpdateMember(Member memberToSaveUpdate) {
		logger.info("Entered  saveOrUpdateMember");
		Session session = null;
		StatusModel status = new StatusModel();
		try{
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(memberToSaveUpdate);
	        tx.commit();
	        status.setError(false);
	        status.setErrorMessage("Success");
		}catch(ConstraintViolationException e){
			logger.error("Error occurred :" + e.getMessage());
			status.setError(true);
			status.setErrorMessage(SeagullConstants.DUPLICATE_ENTRY);
		}
		catch(Exception e){
			logger.error("Error occurred :" + e.getMessage());
			status.setError(true);
			status.setErrorMessage(SeagullConstants.SYSTEM_ERROR);
		}finally{
			session.close();
		}
		return status;
	}

	@Override
	public StatusModel deleteMember(Member memberToDelete) {
		logger.info("Entered  deleteMember");
		Session session = null;
		StatusModel status = new StatusModel();
		try{
			session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Member mem = getMemberInformation(memberToDelete);
			if(mem != null){
				session.delete(mem);
			}
  
	        
	        tx.commit();
	        status.setError(false);
	        status.setErrorMessage("Success");
		}catch(Exception e){
			logger.error("Error occurred :" + e.getMessage());
			status.setError(true);
			status.setErrorMessage(SeagullConstants.SYSTEM_ERROR);
		}finally{
			session.close();
		}
		return status;
	}
	
	

}
