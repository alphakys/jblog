package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping(value="api/category")
public class CategoryController {
		
		@Autowired
		private CategoryService caService;
		
		
		@ResponseBody
		@RequestMapping(value="info", method= {RequestMethod.GET, RequestMethod.POST})
		public List<CategoryVo> getInfo(@RequestBody String id) {
			

			return caService.getInfo(id);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
}
