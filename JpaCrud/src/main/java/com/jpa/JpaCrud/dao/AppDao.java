package com.jpa.JpaCrud.dao;

import com.jpa.JpaCrud.entity.Course;
import com.jpa.JpaCrud.entity.Instructor;
import com.jpa.JpaCrud.entity.InstructorDetails;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetails findInstructoDetailsById(int theId);
    void deleteInstructorDetails(int theId);
    List<Course> findCourseByInstructor(int theId);
    Instructor findInstructorJoinFetch(int theId);
    void update(Instructor tempInstructor);
    void update(Course theCourse);
    Course findCourseById(int theId);
    void  deleteCourseById(int theId);
    void save(Course theCourse);
    Course findCourseByReview(int theId);

}
