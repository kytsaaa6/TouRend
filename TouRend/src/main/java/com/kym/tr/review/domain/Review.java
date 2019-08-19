package com.kym.tr.review.domain;

public class Review {
	
	private int id;
	private String title;
	private String contents;
	private String photo;
	private float star;
	private int member_id;
	
	public Review() {}

	public Review(int id, String title, String contents, String photo, float star, int member_id) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.photo = photo;
		this.star = star;
		this.member_id = member_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	

}
