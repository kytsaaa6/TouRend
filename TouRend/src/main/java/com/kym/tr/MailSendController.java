package com.kym.tr;

import java.io.UnsupportedEncodingException;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSendController {

	@Autowired
	MailSender sender;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@ResponseBody
	@RequestMapping("/mail/send")
	public String sendMail() {
		
		// 메일 내용 설정
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo("kytsaaa6@naver.com");
		message.setSubject("Java mail 테스트 제목");
		message.setText("Java mail 테스트 텍스트");
		message.setFrom("kytsaaa6@gmail.com");
		
		SimpleMailMessage m = new SimpleMailMessage(message);
		
		sender.send(message);
		
		return "send Ok";
	}
	
	
	@RequestMapping("/mail/send2")
	public String sendJavaMailSender() throws UnsupportedEncodingException {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			// 메일 제목 설정
			message.setSubject("[안내] JavaMailSender 테스트 입니다.", "UTF-8");
			
			// html 메일 내용
			String htmlStr = "<h1 style=\"color:blue\">안녕하세요</h1><br>" + "<a href=#>naver.com</a>";
			// 내용 설정
			message.setText(htmlStr, "UTF-8", "html");
			message.addRecipient(RecipientType.TO, new InternetAddress("kytsaaa6@naver.com", "권용용민 님", "UTF-8"));
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "send Ok";
	}
	
	@ResponseBody
	@RequestMapping("/mail/send3")
	public String sendFileAttach()  {
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			// 메일 제목 설정
			messageHelper.setSubject("[안내] 파일 첨부 테스트 입니다.");
			
			// 내용 html
			String htmlStr = "<h1>파일첨부, 파일을 다운받으세요.</h1>";
			
			// 내용 설정
			messageHelper.setText(htmlStr, true);
			
			// To 설정
			messageHelper.setTo(new InternetAddress("kytsaaa6@naver.com", "궈뇽민 님","UTF-8"));
			
			// 첨부할 파일 객체 생성
			DataSource dataSource = new FileDataSource("/Users/kwon-yongmin/Desktop/정리1.pdf");
			// MimeMessageHelper 파일 객체를 추가
			messageHelper.addAttachment(MimeUtility.encodeText("정리1.pdf", "UTF-8", "B"), dataSource);
			
			javaMailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "send ok";
	}
}
