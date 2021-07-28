package com.project.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer > {

}
