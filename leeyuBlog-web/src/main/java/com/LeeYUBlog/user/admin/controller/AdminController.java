package com.LeeYUBlog.user.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping()
	public String initAdmin() {
		return "admin";
	}
	
	//admintest页面
	@RequestMapping("/dashboard.html")
	public String testAdmin(){
		return "dashboard";
	}
}
