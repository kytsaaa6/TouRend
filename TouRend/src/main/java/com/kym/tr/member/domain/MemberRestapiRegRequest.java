package com.kym.tr.member.domain;

public class MemberRestapiRegRequest {

	private String uId;
	private String uPw;
	private String uName;
	

	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}


	public String getuPw() {
		return uPw;
	}


	public void setuPw(String uPw) {
		this.uPw = uPw;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}
	
	
	@Override
	public String toString() {
		return "MemberRestApiRequest [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + "]";
	}


	public MemberInfo toMemberInfo() {
		MemberInfo member = new MemberInfo();
		member.setuId(uId);
		member.setuName(uName);
		member.setuPw(uPw);
		return member;
	}
}
