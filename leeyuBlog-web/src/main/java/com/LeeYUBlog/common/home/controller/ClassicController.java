package com.LeeYUBlog.common.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class ClassicController {
	
	@RequestMapping("/index-classic-fullwidth.html")
	public String displayClassFullwidth(){
		return "index-classic-fullwidth";
	}
	
	@RequestMapping("/index-classic-fullwidth-alt.html")
	public String displayClassFullwidthAlt(){
		return "index-classic-fullwidth-alt";
	}
}
