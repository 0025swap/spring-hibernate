package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;
import com.app.hibernate.demo.entity.Review;

public class CreateCourseAndReviewDemo 
{
	public static void main(String[] args)
	{
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{
			
			
			//start a transaction
			session.beginTransaction();
		
			//create a course
			Course tempCourse = new Course("Packman-how to score one millioon points");
			
			//add some reviews
			tempCourse.addReview(new Review("Great course Loved It.."));
			tempCourse.addReview(new Review("Cool Course"));
			tempCourse.addReview(new Review("Good"));
			
			//save the course
			System.out.println("saving the course");
			session.save(tempCourse);
			
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
