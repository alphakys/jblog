package com.javaex.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;



@Controller
@RequestMapping(value="/{id}", method= {RequestMethod.POST, RequestMethod.GET})
public class BlogController {

	@Autowired
	private BlogService blService;
	
	
	
	@RequestMapping
	public String myBlog(@PathVariable("id") String id, 
						 @RequestParam(value="cateNo", required= false, defaultValue="0") int cateNo,
						 @RequestParam(value="postNo", required=false, defaultValue="0") int postNo,
						 Model model) {
		
		Map<String, Object> blMap = blService.getBlogMain(id, cateNo, postNo);
		
		if(blMap==null) {
			
			return "error/403";
		}
		
		else {
						
			model.addAttribute("blMap", blMap);
			
			return "blog/blog-main";
		}
		
	}
	
	
	@RequestMapping(value="admin/basic", method= {RequestMethod.POST, RequestMethod.GET})
	public String basicInfo(@PathVariable("id") String id, HttpSession session,
							Model model) {
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if(authUser ==null) {
			
			return "redirect:/user/loginForm";
		}
		
		//else {
			
			BlogVo basicInfo = blService.getBasicInfo(id);
			model.addAttribute("basicInfo", basicInfo);
		//}
		
		return "blog/admin/blog-admin-basic";
	}
	
	
	@RequestMapping(value="modifyInfo", method= {RequestMethod.POST, RequestMethod.GET})
	public String modifyInfo(@PathVariable("id") String id, 
						   @RequestParam("blogTitle") String blogTitle,
						   MultipartFile mulFile) {
		
		BlogVo modiVo = new BlogVo();
		modiVo.setId(id);
		modiVo.setBlogTitle(blogTitle);
		
		blService.modifyBasicInfo(modiVo, mulFile);
		
		return "redirect:/"+id;
	}
	
	
	@RequestMapping(value="admin/category", method= {RequestMethod.POST, RequestMethod.GET})
	public String categoryInfo(HttpSession session) {
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		/*
		if(authUser ==null) {
			
			return "redirect:/user/loginForm";
		}
		
		else {
		 */
			return "blog/admin/blog-admin-cate";
		
		
	}
	

	
	@RequestMapping(value="admin/writeForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String writeForm(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("caList", blService.getCateName(id));
		
		return "blog/admin/blog-admin-write";
	}
	
	
	
	@RequestMapping(value="admin/write", method= {RequestMethod.POST, RequestMethod.GET})
	public String write(@ModelAttribute PostVo poVo, @PathVariable("id") String id) {
		
		blService.addPost(poVo);
		
		return "redirect:/"+id+"/admin/writeForm";
	}
	
	
	
	
	
	
	
	
	
}
