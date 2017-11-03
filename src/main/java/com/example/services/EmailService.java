package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Users;

@Service
@Transactional
public class EmailService {
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void forgotPassword(String to) {
		
		List<Users> listUsers = userService.getUserByEmail(to);
		
		if (to.isEmpty() || listUsers == null || listUsers.isEmpty()) {
			return;
		}
		
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setText(listUsers.get(0).getPassword());
        try {
        	mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	}

}
