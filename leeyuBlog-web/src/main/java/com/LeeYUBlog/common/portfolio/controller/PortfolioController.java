package com.LeeYUBlog.common.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
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
