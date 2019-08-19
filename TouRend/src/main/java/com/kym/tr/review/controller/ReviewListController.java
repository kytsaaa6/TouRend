package com.kym.tr.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kym.tr.review.domain.ReviewListView;
import com.kym.tr.review.service.GetReviewListService;

@Controller
public class ReviewListController {

	@Autowired
	private GetReviewListService listService;
	
	@RequestMapping("/review/list")
	public String getList(@RequestParam(value = "page", defaultValue = "1") int pageNumber, Model model) {
		
		ReviewListView listView = listService.getReviewListView(pageNumber);
		
		model.addAttribute("viewData", listView);
		
		return "review/list";
	}
	
//	@RequestMapping("/guest/listJson")
//	@ResponseBody
//	public ReviewListView getListJson(
//			@RequestParam(
//					value = "page", 
//					defaultValue = "1") int pageNumber,
//			Model model
//			) {
//		
//		MessageListView listView = 
//				listService.getMessageListView(pageNumber);
//		
//		return listView;
//	}

}
