package com.sidsalon.styleandcut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class SendEmailImpl implements SendEmail {
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendEmailToUser(String to, String subject,String message) {
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(to);
		email.setSubject(subject);
		email.setText(message);
		try {
			this.mailSender.send(email);
		} catch (MailException ex) {
		
			System.err.println(ex.getMessage());
		}

	}

}
