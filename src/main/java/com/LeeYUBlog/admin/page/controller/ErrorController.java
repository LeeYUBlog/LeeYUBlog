package com.LeeYUBlog.admin.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("/404.html")
	public String displayErrorPage(){
		return "404";
	}
}
