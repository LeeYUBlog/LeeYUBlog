package com.LeeYUBlog.admin.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {
	
	@RequestMapping("/index-list-fullwidth.html")
	public String displayListFullwidth(){
		return "index-list-fullwidth";
	}
	
	@RequestMapping("/index-list-sidebar.html")
	public String displayListSideBar(){
		return "index-list-sidebar";
	}
}
