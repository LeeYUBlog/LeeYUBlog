package com.LeeYUBlog.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandPageController {
	
	@RequestMapping(value={"/home","/","/index.html"})
	public String displayLanding(){
		return "index";
	}
}
