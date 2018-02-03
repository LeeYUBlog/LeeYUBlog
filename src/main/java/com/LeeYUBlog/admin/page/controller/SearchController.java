package com.LeeYUBlog.admin.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

	@RequestMapping("/search.html")
	public String displaySearch(){
		return "search";
	}
}
