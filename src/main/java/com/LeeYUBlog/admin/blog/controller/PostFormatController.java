package com.LeeYUBlog.admin.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostFormatController {
	
	@RequestMapping("/post-format.html")
	public String displayPostFormat(){
		return "post-format";
	}
}
