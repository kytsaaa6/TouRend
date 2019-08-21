package com.kym.tr.member.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailSenderService")
public class MailSenderService {
	
	
	@Autowired
	private JavaMailSender sender;
	
	public int send(String email) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			message.setSubject("[안내] 회원가입을 축하합니다.", "UTF-8");
			String htmlMsg = "<h1>회원가입을 축하합니다.</h>";
			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("kytsaaa6@gmail.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(email, "고객님", "utf-8"));
			
			sender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
	}
	
	
	public void send(String getuId, String code) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			message.setSubject("[안내] 회원가입을 축하합니다.", "UTF-8");
			String htmlMsg = "<h1>회원가입을 축하합니다.</h>";
			
			htmlMsg += "<h3>인증을 위해 아래 링크를 클릭해주세요.</h3>";
			htmlMsg += "<h3><a href=\"http://localhost:8080/tr/member/verify?id="+getuId+"&code="+code+"\" >인증하기</a></h3>";
			
			message.setText(htmlMsg, "UTF-8", "html");
			message.setFrom(new InternetAddress("kytsaaa6@gmail.com"));
			message.addRecipient(RecipientType.TO, 
					new InternetAddress(getuId, "고객님", "utf-8"));
			
			sender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		
	}			
	
}
