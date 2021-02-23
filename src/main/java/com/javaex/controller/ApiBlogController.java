package com.javaex.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping(value="api/category")
public class ApiBlogController {
		
		@Autowired
		private BlogService blService;
		
		
		@ResponseBody
		@RequestMapping(value="info", method= {RequestMethod.GET, RequestMethod.POST})
		public Map<String, Object> getInfo(@RequestBody String id, Model model) {
			
			model.addAttribute("blVo", blService.getBasicInfo(id));
			
			return blService.getCateInfo(id);
			
		}
		
		@ResponseBody
		@RequestMapping(value="add", method= {RequestMethod.GET, RequestMethod.POST})
		public int add(@RequestBody CategoryVo caVo) {
			
			return blService.addCategory(caVo);
			
		}

		
		@RequestMapping(value="delete", method= {RequestMethod.GET, RequestMethod.POST})
		public void delete(@RequestBody int cateNo) {
			
			
		}
		
		
		
		
		
	
}
