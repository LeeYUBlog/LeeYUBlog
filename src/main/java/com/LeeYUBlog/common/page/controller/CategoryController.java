package com.LeeYUBlog.common.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CategoryController {
	
	@RequestMapping("/category.html")
	public String displayCategory(){
		return "category";
	}
}
