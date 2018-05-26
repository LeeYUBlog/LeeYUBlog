package com.LeeYUBlog.common.about.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class AboutController {
	
	@Autowired
	GridFsOperations operations;
	
	@RequestMapping("/about.html")
	public String displayAbout(){
		
		/*FileSystemResource files = new FileSystemResource("C:/123.txt");
		try {
			operations.store(files.getInputStream(), "123.txt");
			System.out.println("yes successful");
		} catch (IOException e) {
			e.printStackTrace();
		}
		GridFsResource resource = operations.getResource("123.txt");
		System.out.println("===resource:"+resource);
		try {
			long contentLength = resource.contentLength();
			System.out.println("===contentLength:"+contentLength);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		return "about";
	}
}
