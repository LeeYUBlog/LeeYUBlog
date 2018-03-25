package com.LeeYUBlog.common.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class ErrorController {

	@RequestMapping("/404.html")
	public String displayErrorPage(){
		return "404";
	}
}
