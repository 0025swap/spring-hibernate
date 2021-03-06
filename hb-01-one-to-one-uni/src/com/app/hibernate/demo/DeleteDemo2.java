package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo2 
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
			
			//get instructor by primary key/id
			int theId =2;
			Instructor tempinstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found Instructor: "+ tempinstructor);
			
			//delete instructor
			if(tempinstructor != null)
			{
				System.out.println("Deleting: "+ tempinstructor);
				//Alsowill delete associated details object
				session.delete(tempinstructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done..");
			
		}
		finally
		{
			factory.close();
		}
	}

}
