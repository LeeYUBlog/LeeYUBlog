package com.LeeYUBlog.common.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class AboutController {
	
	/*@Autowired
	GridFsOperations operations;*/
	
	@RequestMapping("/about.html")
	public String displayAbout(){
		
		/*FileSystemResource files = new FileSystemResource("C:/danish-image-header.jpg");
		try {
			operations.store(files.getInputStream(), "danish-image-header.jpg");
			System.out.println("yes successful");
		} catch (IOException e) {
			e.printStackTrace();
		}
		GridFsResource resource = operations.getResource("danish-image-header.jpg");
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
