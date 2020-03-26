package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class CreateDemo 
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
			//create the objects
//			Instructor tempInstructor = new Instructor("swaroop", "patil","swarooppatil25@gmail.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","luv 2 code");
			
			Instructor tempInstructor = new Instructor("mahesh", "rokade","mahesh.rokade@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com","sketching");
			
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the trasnsaction
			System.out.println("saving instructor: "+ tempInstructor);
			session.save(tempInstructor);
			
			//commit transactin
			session.getTransaction().commit();
			
			System.out.println("Done..");
			
		}
		finally
		{
			factory.close();
		}
	}

}
