package com.kym.tr.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kym.tr.member.domain.MemberInfo;
import com.kym.tr.member.domain.RequestMemberEdit;
import com.kym.tr.member.domain.RequestMemberRegist;
import com.kym.tr.member.service.MemberDeleteService;
import com.kym.tr.member.service.MemberEditService;
import com.kym.tr.member.service.MemberListService;
import com.kym.tr.member.service.MemberRegService;

@RestController	// @ResponseBody 생략한다.
@RequestMapping("/rest/members")
public class MemberRestFulController {

	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberDeleteService deleteService;
	
	@Autowired
	private MemberRegService regService;
	
	@Autowired
	private MemberEditService editService;
	
	
	//@RequestMapping(method = RequestMethod.GET) 생략
	//@ResponseBody 생략
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<MemberInfo>> getAllList() {
		
		List<MemberInfo> list = listService.getAllList();
		
		ResponseEntity<List<MemberInfo>> entity = new ResponseEntity<List<MemberInfo>>(list, HttpStatus.OK);
		
		// HttpStatus.OK -> 200
		// HttpStatus.NOT_FOUND -> 404
		// HttpStatus.INTERNAL_SERVER_ERROR -> 500
		
		return entity;
	}
	
	
	@CrossOrigin
	@DeleteMapping("/{id}") // /rest/members/12
	public ResponseEntity<String> deleteMember(@PathVariable("id") int idx) {
		
		int cnt = deleteService.memberDelete(idx);
		
		return new ResponseEntity<String>(cnt>0 ? "success":"fail", HttpStatus.OK);
		
	}
	
	
	//@RequestMapping(method = HttpMethod.POST) 생략
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> regMember(RequestMemberRegist regRequest, HttpServletRequest request) {
		
		int cnt = regService.memberInsert(request, regRequest);
		
		return new ResponseEntity<String>(cnt>0 ? "success":"fail", HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<MemberInfo> getEditMember(@PathVariable("id") int idx) {
		
		MemberInfo info = editService.getEditFormData(idx);
		
		return new ResponseEntity<MemberInfo>(info, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> editMember(@RequestBody RequestMemberEdit edit, HttpServletRequest request) {
		
		int cnt = editService.edit(edit, null, request);
		
		return new ResponseEntity<String>(cnt>0 ? "success":"fail", HttpStatus.OK);
	}
	
	
}
