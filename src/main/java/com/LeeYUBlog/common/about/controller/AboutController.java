package com.LeeYUBlog.common.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class AboutController {
	
	@RequestMapping("/about.html")
	public String displayAbout(){
		return "about";
	}
}
