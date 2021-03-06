package com.app.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.hibernate.demo.entity.Course;
import com.app.hibernate.demo.entity.Instructor;
import com.app.hibernate.demo.entity.InstructorDetail;
import com.app.hibernate.demo.entity.Review;
import com.app.hibernate.demo.entity.Student;

public class AddCoursesforMDemo 
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
		
			//get the student from db
			int studentId=4;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("selected student: "+ tempStudent);
			
			//create more courses
			Course tempCourse1 = new Course("Rubiks cube-how to speed cube");

			Course tempCourse2 = new Course("Atari 2600-Game Development");
			
			//add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			//save the courses
			System.out.println("saving courses....");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
