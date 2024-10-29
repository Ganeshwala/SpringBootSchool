package com.springboot.school.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.school.entity.Contact;
import com.springboot.school.services.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {

	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact", new Contact());  // by doing this i will let spring-Boot know that we pass fields Name and also I apply validation on field and than need to apply on UI side as well
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
	public String saveMessage(@Valid @ModelAttribute("contact") Contact contact,Errors errors) {
		
		if(errors.hasErrors()){
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact.html";
        }
		log.info("Name "+contact.getName());
		log.info("Mobile Number"+contact.getMobileNum());
		log.info("Email "+contact.getEmail());
		log.info("Subject "+ contact.getSubject());
		log.info("Message "+contact.getMessage());
		contactService.saveContactMessage(contact);
		return "redirect:/contact";
	}
}
