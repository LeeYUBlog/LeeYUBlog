package com.LeeYUBlog.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LandPageController {
	
	@Autowired
	GridFsOperations operations;
	
	@RequestMapping(value={"/home","/","/index.html"})
	public String displayLanding(HttpServletRequest request){
		request.getSession(true);
		
		return "index";
	}
	
	@RequestMapping(value="/indexFiles/{filename}")
	@ResponseBody
	public GridFsResource queryIndexFiles(@PathVariable String filename){
		GridFsResource resource = operations.getResource(filename);
		
		return resource;
	}
}
