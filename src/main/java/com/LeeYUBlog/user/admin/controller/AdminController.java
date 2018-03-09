package com.LeeYUBlog.user.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value="/admin")
	public String initAdmin() {
		return "admin";
	}
}
