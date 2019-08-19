package com.kym.tr.review.domain;

public class RequestReview {

	
	private String title;
	private String contents;
	private String photo;
	private float star;
	private int member_id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	@Override
	public String toString() {
		return "RequestReview [title=" + title + ", contents=" + contents + ", photo=" + photo + ", star=" + star
				+ ", member_id=" + member_id + "]";
	}
	
	public Review toReview() {
		
		Review review = new Review(0, title, contents, photo, star, member_id);
		
		return review;
	}

	
	
}
