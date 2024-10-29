package com.springboot.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springboot.school.entity.Contact;

@Service
public class ContactService {
	
	private static Logger log = LoggerFactory.getLogger(ContactService.class);

	public boolean saveContactMessage(Contact contact) {
		log.info(contact.toString());
		return true;
	}
}
