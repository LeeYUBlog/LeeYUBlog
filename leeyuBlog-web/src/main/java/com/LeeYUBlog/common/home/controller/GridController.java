package com.LeeYUBlog.common.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class GridController {
	
	@RequestMapping("/index-grid-fullwidth.html")
	public String displayGridFullwidth(){
		return "index-grid-fullwidth";
	}
	
	@RequestMapping("/index-grid-sidebar.html")
	public String displayGridSidebar(){
		return "index-grid-sidebar";
	}
}
