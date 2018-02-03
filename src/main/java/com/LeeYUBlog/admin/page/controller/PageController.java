package com.LeeYUBlog.admin.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/page.html")
	public String displayPage(){
		return "page";
	}
}
