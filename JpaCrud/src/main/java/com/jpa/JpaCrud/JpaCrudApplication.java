package com.jpa.JpaCrud;

import com.jpa.JpaCrud.dao.AppDao;
import com.jpa.JpaCrud.entity.Course;
import com.jpa.JpaCrud.entity.Instructor;
import com.jpa.JpaCrud.entity.InstructorDetails;
import com.jpa.JpaCrud.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaCrudApplication {
	//this is test

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return  runner->{
		    //createConstructor(appDao);
			//findInstructor(appDao);
			//deleteInstructor(appDao);
			//findInstructorDetails(appDao);
			//deleteInstructorDetails(appDao);
			//createInstructorWithCourse(appDao);
			//findInstructorWithCourses(appDao);
			//findCourseForInstructor(appDao);
			//findInstructorWithJoinFetch(appDao);
			//updateInstructor(appDao);
			//updateCourseDetails(appDao);
			//deleteInstructorWithCourse(appDao);
			//deteCourseById(appDao);
			//save course for review
			//CreateCourseByReview(appDao);
			//findCourseWithReview(appDao);
			deleteCourseByReview(appDao);
					
			//test file
		};
	}

	private void deleteCourseByReview(AppDao appDao) {
		int theId=10;
		System.out.println("delete id is:"+theId);
		appDao.deleteCourseById(theId);
	}

	private void findCourseWithReview(AppDao appDao) {
		int theId=10;
		System.out.println("id is: "+theId);
	Course tempCourse=	appDao.findCourseByReview(theId);
		System.out.println("course is: "+tempCourse);
		System.out.println("review item is : "+tempCourse.getReviews());
		System.out.println("Done!!!!");
	}

	private void CreateCourseByReview(AppDao appDao) {
		Course tempCourse=new Course("EEE-101");
		Review tempReview1=new Review("oh this course is just awesome!!!!");
		Review tempReview2=new Review("oh this course is just Shiit!!!!");
		Review tempReview3=new Review("i want to study in bangla why select this course!!!!");
		tempCourse.addReview(tempReview1);
		tempCourse.addReview(tempReview2);
		tempCourse.addReview(tempReview3);
		System.out.println("Total review is "+tempCourse.getReviews());
		appDao.save(tempCourse);
		System.out.println("Done!!!!!!!!!");

	}

	private void deteCourseById(AppDao appDao) {
		int theId=10;
		appDao.deleteCourseById(theId);
	}

	private void deleteInstructorWithCourse(AppDao appDao) {
		int theId=1;
		appDao.deleteInstructorById(theId);
	}

	private void updateCourseDetails(AppDao appDao) {
		int theId=10;
		System.out.println("id is "+theId);
Course tempCourse=	appDao.findCourseById(theId);
    tempCourse.setTitle("EEE-101");
		 appDao.update(tempCourse);

	}

	private void updateInstructor(AppDao appDao) {
		int theId=1;
		System.out.println("Id is "+theId);
	Instructor tempInstructor=	appDao.findInstructorById(theId);
	tempInstructor.setLastName("Tester");
		appDao.update(tempInstructor);
	}

	private void findInstructorWithJoinFetch(AppDao appDao) {
		int theId=1;
		System.out.println("id is"+theId);
	Instructor tempInstructor=	appDao.findInstructorJoinFetch(theId);
		System.out.println("Instructor is :"+tempInstructor);
		System.out.println("Course detail is:"+tempInstructor.getCourses());
		System.out.println("Done!!!!!!!!");
	}

	private void findCourseForInstructor(AppDao appDao) {
		int theId=8;
		Instructor tempIns= appDao.findInstructorById(theId);
		System.out.println("temp instructor is: "+tempIns);
	   List<Course>  course=appDao.findCourseByInstructor(theId);
		System.out.println("Course Details is:"+course);
		tempIns.setCourses(course);
		System.out.println("temp Course is "+tempIns.getCourses());

		System.out.println("Done!!!!");
	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId=1;
		Instructor tempIns= appDao.findInstructorById(theId);
		System.out.println("temp instructor is: "+tempIns);
		System.out.println("course is"+tempIns.getCourses());
		System.out.println("done!!!!!!");
	}

	private void createInstructorWithCourse(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Test9","Rahman","test9@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test9@youtube.com","swimming");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		Course course1=new Course("CSE-801");
		Course course2=new Course("CSE-802");
		Course course3=new Course("CSE-803");
		//associate the obj
		tempInstructor.add(course1);
		tempInstructor.add(course2);
		tempInstructor.add(course3);
		appDao.save(tempInstructor);


		System.out.println(tempInstructor);
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		appDao.save(tempInstructor);


		System.out.println("done");


	}

	private void deleteInstructorDetails(AppDao appDao) {
		int theId=1;
		appDao.deleteInstructorDetails(theId);
	}

	private void findInstructorDetails(AppDao appDao) {
		int theId=1;
	InstructorDetails tempInatructorsDetails=	appDao.findInstructoDetailsById(theId);
		System.out.println(tempInatructorsDetails);
		//System.out.println(tempInatructorsDetails.getInstructor());

	}

	private void deleteInstructor(AppDao appDao) {
		int theId=1;
		appDao.deleteInstructorById(theId);
	}

	private void findInstructor(AppDao appDao) {
		int theId=2;
	Instructor tempInsTructor=	appDao.findInstructorById(theId);
		System.out.println(tempInsTructor);
		//System.out.println("instructor detils is: "+tempInsTructor.getInstructorDetails());
	}

	private void createConstructor(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Test1","Rahman","test5@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test1@youtube.com","swimming");
		//associate the obj
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		System.out.println(tempInstructor);
		appDao.save(tempInstructor);


		System.out.println("done");
		//save the instructor details
	}

}
