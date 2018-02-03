package com.LeeYUBlog.admin.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArchiveController {
	
	@RequestMapping("archive.html")
	public String displayArchive(){
		return "archive";
	}
}
