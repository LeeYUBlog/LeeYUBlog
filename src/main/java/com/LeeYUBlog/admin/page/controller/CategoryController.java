package com.LeeYUBlog.admin.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@RequestMapping("/category.html")
	public String displayCategory(){
		return "category";
	}
}
