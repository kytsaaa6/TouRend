package com.kym.tr.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kym.tr.member.dao.MemberSessionDao;
import com.kym.tr.member.domain.ListViewData;
import com.kym.tr.member.domain.MemberInfo;
import com.kym.tr.member.domain.SearchParam;

@Service("MlistService")
public class MemberListService implements MemberService {
	
	@Inject
	private SqlSessionTemplate template;
	
	private MemberSessionDao dao;

	final int MEMBER_CNT_List = 3;

	public ListViewData getListData(
			int currentPageNumber, 
			SearchParam searchParam) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberSessionDao.class);
		
		
		ListViewData listData = new ListViewData();
		

			// 현재 페이지 번호
			listData.setCurrentPageNumber(currentPageNumber);
			
			// 전체 게시물의 개수
			int totalCnt = dao.selectTotalCount(searchParam);
			
			int totalPageCnt = 0;
			// 전체 페이지 개수
			if(totalCnt>0) {
				totalPageCnt = totalCnt/MEMBER_CNT_List;
				if(totalCnt%MEMBER_CNT_List>0) {
					totalPageCnt++;
				}
			}
			listData.setPageTotalCount(totalPageCnt);
			
			
			// 구간 검색을 위한 index
			// 1 -> 0 , 2 -> 3, 3 -> 6, 4 -> 9
			int index = (currentPageNumber-1)*MEMBER_CNT_List;
			
			
			// 회원 정보 리스트 
			List<MemberInfo> memberList = null;
			
			
			// 1. 검색 조건이 없는경우  selectList -> 전체 회원의 리스트
			// 2. id 로 검색 : where  like uid '%?%'
			// 3. name 으로 검색 : where like uname '%?%'
			// 4. id 또는 name :  where like uname '%?%' or like uid '%?%'

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("search", searchParam);
			params.put("index", index);
			params.put("count", MEMBER_CNT_List);
			
			memberList = dao.selectList(params);
			System.out.println("사이즈 : : : : " + totalCnt);
			System.out.println("리스트 사이즈 : : : : " + memberList.size());
			
			listData.setMemberList(memberList);
			for(MemberInfo m : memberList) {
				System.out.println(m);
			}
			
			// 1 -> 9-0 =9, 2 -> 9-3=6
			int no = totalCnt - index;
			listData.setNo(no);
			
			listData.setTotalCount(totalCnt);
			

		
		return listData;
		
	}

	
	
	public List<MemberInfo> getAllList() {
		
		dao = template.getMapper(MemberSessionDao.class);
		
		List<MemberInfo> list = dao.selectAllList();
		
		return list;
	}
}
