package com.project.springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.model.Course;
import com.project.springboot.repository.CourseRepository;
import com.project.springboot.service.CourseService;

@Service
public class CourseServiceImp implements CourseService{

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		this.courseRepository.save(course);
	}

	@Override
	public Course getCoursebyId(int id) {
		// TODO Auto-generated method stub
		Optional<Course> optional=courseRepository.findById(id);
		Course course=null;
		if(optional.isPresent()) {
			course=optional.get();
		}
		else {
			throw new RuntimeException("Course Not Available for id:"+id);
		}
		return course;
	}

	@Override
	public void deleteCoursebyId(int id) {
		// TODO Auto-generated method stub
		this.courseRepository.deleteById(id);
	}
	
	
}
