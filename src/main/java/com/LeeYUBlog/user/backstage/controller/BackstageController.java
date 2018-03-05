package com.LeeYUBlog.user.backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackstageController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
