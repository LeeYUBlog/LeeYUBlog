package com.LeeYUBlog.admin.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
	
	@RequestMapping("/about.html")
	public String displayAbout(){
		return "about";
	}
}
