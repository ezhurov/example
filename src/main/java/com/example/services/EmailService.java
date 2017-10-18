package com.example.services;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Users;

@Service
public class EmailService {
	
	@Autowired
	private UsersService userService;
	
	public void forgotPassword(String to, final String from, final String password) {
		
		if (from.isEmpty() || password.isEmpty() || to.isEmpty()) {
			return;
		}
		
		List<Users> listUsers = userService.getUserByEmail(to);
		
		if (listUsers == null || listUsers.isEmpty()) {
			return;
		}
		
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.mail.ru");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject("Восстановление пароля");
            msg.setSentDate(new Date());
            msg.setText("Пароль: " + listUsers.get(0).getPassword());

            Transport.send(msg);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
		
	}

}

