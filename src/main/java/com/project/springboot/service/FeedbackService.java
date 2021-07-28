package com.project.springboot.service;

import java.util.List;

import com.project.springboot.model.Feedback;

public interface FeedbackService {

	List<Feedback> getAllFeedbacks();
	void saveFeedback(Feedback feedback);
	Feedback getFeedbackbyId(int id);
	void deleteFeedbackbyId(int id);
}
