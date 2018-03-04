package com.LeeYUBlog.common.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class ArchiveController {
	
	@RequestMapping("archive.html")
	public String displayArchive(){
		return "archive";
	}
}
