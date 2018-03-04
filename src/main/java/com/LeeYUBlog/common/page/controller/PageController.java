package com.LeeYUBlog.common.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class PageController {

	@RequestMapping("/page.html")
	public String displayPage(){
		return "page";
	}
}
