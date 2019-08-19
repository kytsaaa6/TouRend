package com.kym.tr.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kym.tr.member.domain.RequestMemberRegist;
import com.kym.tr.member.service.MemberRegService;



@Controller
@RequestMapping("/member/regist")
public class MemberRegController {

	
	@Autowired
	private MemberRegService registService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getForm( ) {
		
		return "member/registForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberRegist(RequestMemberRegist regist, HttpServletRequest request, Model model) {
		
		System.out.println(regist);
		
		int rCnt = registService.memberInsert(request, regist);
		
		model.addAttribute("rCnt", rCnt);
		
		return "member/memberRegist";
	}
	
}