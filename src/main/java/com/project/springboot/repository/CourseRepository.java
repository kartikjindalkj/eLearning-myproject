package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
