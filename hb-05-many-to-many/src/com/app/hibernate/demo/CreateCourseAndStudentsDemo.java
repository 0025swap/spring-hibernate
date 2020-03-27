package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;
import com.app.hibernate.demo.entity.Review;
import com.app.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo 
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
		
			//create a course
			Course tempCourse = new Course("Packman-how to score one millioon points");
			
			Student tempStudent1=new Student("Swaroop","Patil","swarooppatil@gmail.com");
			Student tempStudent2=new Student("Mahesh","Rokade","maheshrokade@gmail.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the course
			System.out.println("saving the course");
			session.save(tempCourse);
			
			//save the course
			System.out.println("saving the Students");
			session.save(tempStudent1);
			session.save(tempStudent2);

			
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
