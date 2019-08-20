package com.kym.tr.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kym.tr.member.domain.MemberInfo;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String page() {
		
		MemberInfo info = null;
		
		System.out.println(info.getIdx());
		
		return "list";
	}

	
}
