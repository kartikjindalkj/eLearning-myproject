package com.project.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.project.springboot.model.Feedback;
import com.project.springboot.service.FeedbackService;

@Controller
public class FeedbackControl {

	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/ViewallFeedbacks")
	public String viewallFeedbacks(Model model) {
		model.addAttribute("listFeedbacks",feedbackService.getAllFeedbacks());
		return "ViewAllFeedbacks";
	}
	
	@GetMapping("/ViewUserFeedbacks/{id}")
	public String viewOneUserFeedbacks(@PathVariable(value="id") int id, Model model) {
		
		
//		List<Integer> ids=new ArrayList<Integer>();
//		ids.add(id);
		//ids.add(2);
//		System.out.println("UserID"+id);
		model.addAttribute("OneUserFeedbacks",feedbackService.getFeedbackbyUserId(id));
//		System.out.println("part1:"+model.getAttribute("OneUserFeedbacks"));
//		System.out.println("part2:"+feedbackService.getFeedbackbyUserId(id));
		return "ViewOneUserFeedbacks";
		
	}
	@GetMapping("/feedbackRegistrationForm/{id}")
	public String AdminRegistrationForm(@PathVariable(value="id") int userid,Model model) {
		Feedback feedback=new Feedback();
		feedback.setUser_id(userid);
		model.addAttribute("feedback",feedback);
		
		return "feedbackRegistration";
		
	}
	
	@PostMapping("/saveFeedback")
	public String SaveFeedback( @ModelAttribute("feedback") Feedback feedback) {
		//feedback.setUser_id(userid);
		//System.out.println(feedback.getId());
		//System.out.println(feedback.getUser_id());
//		System.out.println(feedback.getFeedback());
		
		
		feedbackService.saveFeedback(feedback);
		return "redirect:/";
	}
	
	@GetMapping("showFeedbackforUpdate/{id}")
	public String ShowfeedbackforUpdate(@PathVariable(value="id") int id,Model model) {
		//Get user from Service
		Feedback feedback=feedbackService.getFeedbackbyId(id);
		
		//set feedback as model attribute to prepopulate the form data
		model.addAttribute("feedback",feedback);
		return "update_feedback";
	}
	
	@GetMapping("/deleteFeedback/{id}")
	public String deleteFeedback(@PathVariable(value="id")int id,Model model) {
		//call delete feedback method from service
		this.feedbackService.deleteFeedbackbyId(id);
		return "redirect:/";
	}
	
}
