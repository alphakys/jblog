package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	private UserService usService;
	
	
	@RequestMapping(value="joinForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String joinFrom() {
	
		
		return "user/joinForm";
	}
	
	
	@RequestMapping(value="join", method= {RequestMethod.POST, RequestMethod.GET})
	public String join(@ModelAttribute UserVo usVo) {
		
		usService.join(usVo);
		
		return "user/joinSuccess";
	}
	
	
	@RequestMapping(value="loginForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String loginForm() {
		
		return "user/loginForm";
	}
	
	
	@RequestMapping(value="login", method= {RequestMethod.POST, RequestMethod.GET})
	public String login(@ModelAttribute UserVo usVo, HttpSession session, Model model){
		
		UserVo authUser = usService.login(usVo);
		
		if(authUser== null) {
			
			return "redirect:loginForm?result=fail";
		}
		
		else {
			
			authUser.setId(usVo.getId());
			session.setAttribute("authUser", authUser);
		
			
			//****redirect 기억하자!!! /가 없을 땐 같은 controller로 redirect이고****
			//**** /가 있을 땐 다른 controller로 redirect****
			
			
			return "redirect:/";
		}
		
		
	}
	
	@RequestMapping(value="logout", method= {RequestMethod.POST, RequestMethod.GET})
	public String logout(HttpSession session) {
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	

	
	
	
}
