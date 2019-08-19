package com.kym.tr.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kym.tr.review.domain.RequestReview;
import com.kym.tr.review.service.WriteReviewService;

@Controller
@RequestMapping("/review/write")
public class ReviewWriteController {

	@Autowired
	private WriteReviewService writeService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String writeForm() {
		
		return "review/writeForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String write(RequestReview requestReview, Model model) {
		
		int rCnt = writeService.write(requestReview.toReview());
		
		model.addAttribute("resultCnt", rCnt);
		
		return "review/write";
	}
}
