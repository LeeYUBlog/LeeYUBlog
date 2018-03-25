package com.LeeYUBlog.common.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class PostFormatController {
	
	@RequestMapping("/post-format.html")
	public String displayPostFormat(){
		return "post-format";
	}
}
