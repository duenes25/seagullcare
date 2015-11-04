package com.headhigh.seagullcare.test.login;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.headhigh.seagullcare.dao.SeagullCareDAO;
import com.headhigh.seagullcare.helper.EncryptionHelper;
import com.headhigh.seagullcare.model.Member;
import com.headhigh.seagullcare.model.StatusModel;
import com.headhigh.seagullcare.model.Users;


public class MemberTest extends TestCase {
	 
		public void testApp() {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
	 
			Users user = new Users("firstuser", "test", 0);
			session.save(user);
	 
			session.getTransaction().commit();
			session.close();
		}
		
		public void testAddMember() {
			StatusModel status = new StatusModel();
			try{
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
				SeagullCareDAO memberDAO = context.getBean(SeagullCareDAO.class);
				Member newMember = new Member("memberN3", "12345667", "memberEmail", 1);
				status = memberDAO.saveOrUpdateMember(newMember);
			}catch (Exception e){
				System.out.println("Error: " + e);
			}
			assertTrue(status.isError());
		}
		
		public void testSaveOrUpdateMember() {
			StatusModel status = new StatusModel();
			try{
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
				SeagullCareDAO memberDAO = context.getBean(SeagullCareDAO.class);
				Member newMember = new Member(1L,"memberN", "12345667", "memberEmail", 1);
				status = memberDAO.saveOrUpdateMember(newMember);
			}catch (Exception e){
				System.out.println("Error: " + e);
			}
			assertTrue(status.isError());
		}
		
		public void testGetMemberInformation() {
			Member getMember = new Member();
			try{
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
				SeagullCareDAO memberDAO = context.getBean(SeagullCareDAO.class);
				Member sampleMember = new Member();
				sampleMember.setId(1L);
				getMember = memberDAO.getMemberInformation(sampleMember);
			}catch (Exception e){
				System.out.println("Error: " + e);
			}
	       assertNotNull(getMember.getMemberName());
		}
		
		public void testGetMembers() {
			List<Member> memberList = new ArrayList<Member>();
			try{
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
				SeagullCareDAO memberDAO = context.getBean(SeagullCareDAO.class);
				memberList = memberDAO.getMembers();
				
			}catch (Exception e){
				System.out.println("Error: " + e);
			}
			System.out.println(memberList.size());
	       assertTrue(memberList.size() > 0);
		}
		
		public void testDeleteMember() {
			StatusModel status = new StatusModel();
			try{
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
				SeagullCareDAO deleteMemberDAO = context.getBean(SeagullCareDAO.class);
				Member member = new Member();
				member.setMemberName("memberN");
				member.setMemberPhone("12345667");
				status = deleteMemberDAO.deleteMember(member);
			}catch (Exception e){
				System.out.println("Error: " + e);
			}
	       assertTrue(status.isError());
		}
		
		public void testAddMemberWithPassword(){
			
			StatusModel status = new StatusModel();
			try {
				//Generate Password
				int i = EncryptionHelper.randInt(100000, 999999);
				System.out.println(i);
				//generate Salt
				byte[] saltByteArray = EncryptionHelper.generateSalt();
				System.out.println(saltByteArray);
				
				//encrypt the password
				byte[] encryptedPwdByteArray = EncryptionHelper.getEncryptedPassword(Integer.toString(i), saltByteArray);
				System.out.println(encryptedPwdByteArray);
				
				
				
				//store encrypted password and salt
				
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
				SeagullCareDAO memberDAO = context.getBean(SeagullCareDAO.class);
				Member newMember = new Member("memberN6", "12345667", "memberEmail", 1);
				newMember.setSalt(saltByteArray);
				newMember.setPassword(encryptedPwdByteArray);
				status = memberDAO.saveOrUpdateMember(newMember);
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error: " + e);
			}
			catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(status.isError());
		}
		
		public void testAuthenticateUser(){
			boolean status = false;
			try {
			//Set the Password of a New User
			//generate Salt
			byte[] saltByteArray = EncryptionHelper.generateSalt();
			System.out.println(saltByteArray);
			
			//encrypt the password
			byte[] encryptedPwdByteArray = EncryptionHelper.getEncryptedPassword("testing", saltByteArray);
			System.out.println(encryptedPwdByteArray);
			
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
			SeagullCareDAO memberDAO = context.getBean(SeagullCareDAO.class);
			Member newMember = new Member("memberN55", "12345667", "memberEmail222", 1);
			newMember.setSalt(saltByteArray);
			newMember.setPassword(encryptedPwdByteArray);
			memberDAO.saveOrUpdateMember(newMember);
			
			System.out.println("auth");
			Member authMember = new Member();
			authMember.setMemberEmail("memberEmail222");
			Member getMember = memberDAO.getMemberInformation(authMember);
			
				status = EncryptionHelper.authenticate("testing", getMember.getPassword(), getMember.getSalt());
				System.out.println("authDone");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(status);
			assertTrue(status);
		}
		
	}


