package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetaildemo 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			long theId=1; 											// int thid=1990;
			
			InstructorDetail tempInstructoreDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("tempInstructorDetail: "+ tempInstructoreDetail);
		
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done..");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			//To handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
