package com.springboot.school.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {

	 @RequestMapping(value="/dashboard",method = {RequestMethod.GET, RequestMethod.POST})
	    public String displayDashboard(Model model,Authentication authentication) {
	        model.addAttribute("username", authentication.getName());
	        model.addAttribute("roles", authentication.getAuthorities().toString());
	        return "dashboard.html";
	    }
}
