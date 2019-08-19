package com.kym.tr.review.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kym.tr.review.dao.ReviewSessionDao;
import com.kym.tr.review.domain.Review;

@Service("RdeleteService")
public class DeleteReviewService implements ReviewService {

	@Autowired
	private SqlSessionTemplate template;

	private ReviewSessionDao dao;

	@Transactional
	public int deleteReview(int reviewId, String password)
			throws ReviewNotFoundException, InvalidReviewPasswordException {
		int resultCnt = 0;

		dao = template.getMapper(ReviewSessionDao.class);

		try {

			// 1. 전달받은 게시물 아이디로 게시물 확인
			Review review = dao.select(reviewId);

			// 2. 게시물이 존재 하지 않으면 예외 처리
			if (review == null) {
				throw new ReviewNotFoundException("리뷰가 존재하지 않습니다. : " + reviewId);
			}

			// 3. 게시물이 존재 하면 비밀번호 확인 -> 사용자가 입력한 비밀번호와 비교
			// 4. 비밀번호가 존재하지 않거나 사용자 비밀번호가 틀린경우 예외처리
			// 5. 비밀번호가 일치하면 정상 처리(삭제) -> commit

			resultCnt = dao.deleteReview(reviewId);

		} catch (ReviewNotFoundException e) {
			e.printStackTrace();
			throw e;
		} 

		return resultCnt;

	}
}
