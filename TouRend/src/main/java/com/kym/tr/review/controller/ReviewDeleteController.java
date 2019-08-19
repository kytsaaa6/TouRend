package com.kym.tr.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kym.tr.review.service.DeleteReviewService;
import com.kym.tr.review.service.InvalidReviewPasswordException;
import com.kym.tr.review.service.ReviewNotFoundException;

@Controller
@RequestMapping("/review/delete")
public class ReviewDeleteController {
	
	
	@Autowired
	public DeleteReviewService deleteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getDeleteForm() {
	
		return "review/deleteForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String delete(@RequestParam("reviewId") int reviewId, @RequestParam("password") String password, Model model) {
	
		boolean chk = false;
		int resultCnt = 0;
		String msg = "";
		
		try {
			resultCnt = deleteService.deleteReview(reviewId, password);
			chk = true;

		} catch (ReviewNotFoundException e) {
			e.printStackTrace();
			msg = e.getMessage();
		} catch (InvalidReviewPasswordException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		
		model.addAttribute("chk", chk);
		model.addAttribute("resultCnt", resultCnt);
		model.addAttribute("msg", msg);
		
		return "review/delete";
	}

}
