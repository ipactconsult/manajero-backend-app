package com.stock.main.business.businessimpl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderBusiness {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail, String subject, String htmlMsg) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		boolean multipart = true;
                MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
		message.setFrom("manazello.supplier.mng@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		message.setContent(htmlMsg, "text/html");
		mailSender.send(message);
	}

}
