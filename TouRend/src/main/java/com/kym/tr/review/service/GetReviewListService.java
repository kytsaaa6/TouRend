package com.kym.tr.review.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kym.tr.review.dao.ReviewSessionDao;
import com.kym.tr.review.domain.Review;
import com.kym.tr.review.domain.ReviewListView;

@Service("RlistService")
public class GetReviewListService implements ReviewService {

	@Autowired
	private SqlSessionTemplate template;

	private ReviewSessionDao dao;

	private static final int REVIEW_COUNT_PER_PAGE = 3;

	public ReviewListView getReviewListView(int pageNumber) {

		// dao 생성
		dao = template.getMapper(ReviewSessionDao.class);

		// 2. 현재 페이지 번호
		int currentPageNumber = pageNumber;

		ReviewListView view = null;

		int reviewTotalCount = dao.selectCount();

		// 게시물 내용 리스트, DB 검색에 사용할 start_row, end_row
		List<Review> reviewList = null;
		
		int firstRow = 0;
		int endRow = 0;

		if (reviewTotalCount > 0) {

			firstRow = (pageNumber - 1) * REVIEW_COUNT_PER_PAGE + 1;
			endRow = firstRow + REVIEW_COUNT_PER_PAGE - 1;

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("firstRow", firstRow);
			params.put("endRow", endRow);
			reviewList = dao.selectList(params);

		} else {
			currentPageNumber = 0;
			reviewList = Collections.emptyList();
		}

		view = new ReviewListView(
						reviewTotalCount,
						currentPageNumber, 
						reviewList, 
						REVIEW_COUNT_PER_PAGE, 
						firstRow, 
						endRow);

		return view;

	}

}
