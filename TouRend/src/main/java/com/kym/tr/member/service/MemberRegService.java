package com.kym.tr.member.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kym.tr.member.dao.MemberSessionDao;
import com.kym.tr.member.domain.MemberInfo;
import com.kym.tr.member.domain.RequestMemberRegist;


@Service("registService")
public class MemberRegService implements MemberService {

	//@Autowired
	//private MemberDao dao;
	
	//@Autowired
	//private MemberJdbcTemplateDao dao;
	
	// 자동 메퍼를 이용해서 생성할 dao 
	private MemberSessionDao dao;
	
	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;
	
	public int memberInsert(
			HttpServletRequest request, 
			RequestMemberRegist regist) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberSessionDao.class);
		
		// 서버 경로
		String path = "/uploadfile/userphoto"; // 리소스 매핑 필요
		// 절대 경로 
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		MemberInfo memberInfo = regist.toMemberInfo();
		
		int resultCnt = 0;
		
		String newFileName = "";
		
		try {
			if(regist.getuPhoto() != null) {
				// 새로운 파일 이름 생성
				//newFileName = memberInfo.getuId()+System.nanoTime();
				newFileName = memberInfo.getuId()+"_"+regist.getuPhoto().getOriginalFilename();
				// 파일을 서버의 지정 경로에 저장
				regist.getuPhoto().transferTo(new File(dir, newFileName));
				// 데이터베이스 저장을 하기위한 파일 이름 set
				memberInfo.setuPhoto(newFileName);
			
			}
			resultCnt = dao.insertMember(memberInfo);
			
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("오류");
			if(regist.getuPhoto() != null) {
				new File(dir,newFileName).delete();
			}
		}
		
		
		return resultCnt;
	}
	
	public char idCheck(String id) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberSessionDao.class);
		
		char chk = dao.selectMemberById(id)==null?'Y':'N' ;
		
		return chk;
	}
	
	public String idCheck1(String id) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberSessionDao.class);
		
		String chk = dao.selectMemberById2(id)==null ? "Y" : "N" ;
		
		return chk;
	}
	
}
