package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;
import com.app.hibernate.demo.entity.Review;
import com.app.hibernate.demo.entity.Student;

public class DeletePackmanCourseDemo 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			
			
			//start a transaction
			session.beginTransaction();
		
			//get the packman course from db
			int courseId=10;
			Course tempCourse = session.get(Course.class, courseId);
			
			
			//delete the course
			System.out.println("deleteing Course: "+ tempCourse);
			session.delete(tempCourse);
			
			//commit transaction
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
