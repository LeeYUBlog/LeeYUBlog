package com.LeeYUBlog.admin.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	
	@RequestMapping("/contact.html")
	public String displayContact(){
		return "contact";
	}
}
