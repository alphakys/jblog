package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.UserService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;


@Controller
@RequestMapping
public class BlogController {
	
	@Autowired
	private UserService usService;
	@Autowired
	private BlogService blService;
	@Autowired
	private CategoryService caService;
	
	
	@RequestMapping(value="/{id}", method= {RequestMethod.POST, RequestMethod.GET})
	public String myBlog(@PathVariable("id") String id) {
		
		String uid = usService.getId(id);
		
		if(uid==null || uid.equals("")) {
			
			return "error/403";
		}
		
		else {
			
			BlogVo blVo = blService.getBlog(uid);
			CategoryVo caVo = caService.getCategory(uid);
			
			return "blog/blog-main";
		}
		
	}
	
	
	
	
	
	
	
	
	
}
