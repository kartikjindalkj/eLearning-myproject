package com.project.springboot.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springboot.model.Feedback;
import com.project.springboot.repository.FeedbackRepository;
import com.project.springboot.service.FeedbackService;

@Service
public class FeedbackServiceImp implements FeedbackService{

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return feedbackRepository.findAll();
	}

	@Override
	public void saveFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		this.feedbackRepository.save(feedback);
		
	}

	@Override
	public Feedback getFeedbackbyId(int id) {
		// TODO Auto-generated method stub
		Optional<Feedback> optional=feedbackRepository.findById(id);
		Feedback feedback=null;
		if(optional.isPresent()) {
			feedback=optional.get();
		}
		else {
			throw new RuntimeException("Feedback Not Available for id:"+id);
		}
		return feedback;
	}

	@Override
	public void deleteFeedbackbyId(int id) {
		// TODO Auto-generated method stub
		this.feedbackRepository.deleteById(id);
	}
	
	
}
