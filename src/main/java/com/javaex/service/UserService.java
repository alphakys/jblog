package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao usDao;
	@Autowired
	private BlogDao blDao;
	@Autowired
	private CategoryDao caDao;
	
	
	public void join(UserVo usVo) {
		
		int result = usDao.insertUser(usVo);
		
		if(result==1) {
			
			//회원가입 성공시 blog에 기본 정보 insert
			BlogVo blVo = new BlogVo();
			
			blVo.setId(usVo.getId());
			blVo.setBlogTitle(usVo.getUserName()+"의 블로그입니다");
			blVo.setLogoFile("spring-logo.jpg");
			
			blDao.insertBlog(blVo);
			
			//회원가입 성공시 blog category에 기본 정보 insert
			
			CategoryVo caVo = new CategoryVo();
			
			caVo.setCateName("미분류");
			caVo.setId(usVo.getId());
			caVo.setDescription("기본으로 만들어지는 카테고리입니다");
			
			caDao.insertCategory(caVo);
		}
		
		
	}
	
	
	public UserVo login(UserVo usVo) {
		
		//로그인 성공시 session에 넘겨줄 기본정보 가져옴
		
		
		return usDao.selectUser(usVo);
	}
	
	
	public String getId(String id) {
		
		return usDao.selectId(id);
	}
	
	
	
	
	
}
