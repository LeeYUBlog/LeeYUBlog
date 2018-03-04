package com.LeeYUBlog.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping(value="/login")
	public String login(Model model){
		//model.addAttribute("user_flag","1");
		return "index";
	}
}
