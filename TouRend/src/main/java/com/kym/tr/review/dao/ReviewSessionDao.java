package com.kym.tr.review.dao;

import java.util.List;
import java.util.Map;

import com.kym.tr.review.domain.Review;

public interface ReviewSessionDao {

	public int insert(Review review);
	
	public Review select(int reviewid);
	
	public int selectCount();
	
	public List<Review> selectList(Map<String, Object> params);
	
	public int deleteReview(int reviewid);

}
