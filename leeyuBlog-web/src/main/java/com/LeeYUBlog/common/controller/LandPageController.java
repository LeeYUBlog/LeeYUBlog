package com.LeeYUBlog.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandPageController {
	
	@RequestMapping(value={"/home","/","/index.html"})
	public String displayLanding(HttpServletRequest request){
		request.getSession(true);
		return "index";
	}
}
