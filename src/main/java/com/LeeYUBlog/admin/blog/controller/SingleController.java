package com.LeeYUBlog.admin.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SingleController {
	
	@RequestMapping("/single.html")
	public String displaySingle(){
		return "single";
	}
	
	@RequestMapping("/single-quote.html")
	public String displaySingleQuote(){
		return "single-quote";
	}
	
	@RequestMapping("/single-gallery.html")
	public String displaySingleGallery(){
		return "single-gallery";
	}
	
	@RequestMapping("/single-video.html")
	public String displaySingleVideo(){
		return "single-video";
	}
	
	@RequestMapping("/single-audio.html")
	public String displaySingleAudio(){
		return "single-audio";
	}
	
	@RequestMapping("/single-image.html")
	public String displaySingleImage(){
		return "single-image";
	}
}
