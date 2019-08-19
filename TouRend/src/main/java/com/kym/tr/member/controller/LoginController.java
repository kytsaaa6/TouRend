package com.kym.tr.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kym.tr.member.service.MemberLoginService;


@Controller
@RequestMapping("member/login")
public class LoginController {

	@Autowired
	private MemberLoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String LoginForm(HttpServletRequest request) {
		
		String view = "member/loginForm";
		
		// 현재 세션을 가지고 있으면 저장, 없으면 null 값으로 변환
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("loginInfo") != null) {
			view = "redirect:/";
		}
		
		return view;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("uId") String id, @RequestParam("uPw") String pw, HttpServletRequest request) {
		
		String view = "member/loginfail";
		
		boolean loginChk = loginService.login(id, pw, request);
		
		
		if(loginChk) {
			view = "redirect:/";
		}
		
		return view;
		
	}
	
}
