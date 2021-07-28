package com.project.springboot.service;

import java.util.List;

import com.project.springboot.model.Course;

public interface CourseService {

	List<Course> getAllCourses();
	void saveCourse(Course course);
	Course getCoursebyId(int id);
	void deleteCoursebyId(int id);
}
