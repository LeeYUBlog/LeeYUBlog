package com.LeeYUBlog.admin.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

	@RequestMapping("/portfolio.html")
	public String displayPortfolio(){
		return "portfolio";
	}
	
	@RequestMapping("/single-portfolio.html")
	public String displaySinglePortfolio(){
		return "single-portfolio";
	}
	
	@RequestMapping("/archive-portfolio.html")
	public String displayArchivePortfolio(){
		return "archive-portfolio";
	}
}
