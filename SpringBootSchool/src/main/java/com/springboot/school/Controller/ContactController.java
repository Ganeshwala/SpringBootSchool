package com.springboot.school.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.school.entity.Contact;
import com.springboot.school.services.ContactService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {

	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contact")
	public String displayContactPage() {
		return "contact.html";
	}
	
	/*@PostMapping("/saveMsg")
	public ModelAndView saveMessage(@RequestParam String name,@RequestParam String mobileNum,@RequestParam String email,@RequestParam String subject,@RequestParam String message) {
		log.info("Name "+name);
		log.info("Mobile Number"+mobileNum);
		log.info("Email "+email);
		log.info("Subject "+ subject);
		log.info("Message "+message);
		return new ModelAndView("redirect:/contact");
	}*/
	
	@PostMapping("/saveMsg")
	public ModelAndView saveMessage(Contact contact) {
		log.info("Name "+contact.getName());
		log.info("Mobile Number"+contact.getMobileNum());
		log.info("Email "+contact.getEmail());
		log.info("Subject "+ contact.getSubject());
		log.info("Message "+contact.getMessage());
		contactService.saveContactMessage(contact);
		return new ModelAndView("redirect:/contact");
	}
}
