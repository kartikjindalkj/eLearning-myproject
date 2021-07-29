package com.project.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.springboot.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	@Query(value = "Select * from feedbacks where user_id= :userid",nativeQuery = true)
	List<Feedback> findAllByUserId(@Param("userid") int id);
}
