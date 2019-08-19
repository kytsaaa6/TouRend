package com.kym.tr.review.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kym.tr.review.dao.ReviewSessionDao;
import com.kym.tr.review.domain.Review;

@Service("RwriteService")
public class WriteReviewService implements ReviewService{

	
	@Autowired
	private SqlSessionTemplate template;
	
	private ReviewSessionDao dao;
	
	
	public int write(Review review) {
		
		dao = template.getMapper(ReviewSessionDao.class);
		
		int rCnt = 0;
		
		rCnt = dao.insert(review);
		
		return rCnt;
		
	}
}
