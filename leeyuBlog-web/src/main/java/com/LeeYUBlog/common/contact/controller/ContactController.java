package com.LeeYUBlog.common.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class ContactController {
	
	@RequestMapping("/contact.html")
	public String displayContact(){
		return "contact";
	}
}
