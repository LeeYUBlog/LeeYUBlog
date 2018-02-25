package com.LeeYUBlog.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping(value={"/home","/"})
	public String displayLanding(){
		return "index";
	}
}
