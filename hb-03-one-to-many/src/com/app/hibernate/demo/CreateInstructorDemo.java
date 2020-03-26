package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			//create the objects		
			Instructor tempInstructor = new Instructor("Tushar", "Deshmane","tushar.deshmane@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com","singing");
			
			
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
			//add clean up code
			session.close();
			factory.close();
		}
	}

}
