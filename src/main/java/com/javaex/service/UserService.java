package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao usDao;
	@Autowired
	private BlogDao blDao;
	@Autowired
	private CategoryDao caDao;
	@Autowired
	private PostDao poDao;
	
	public void join(UserVo usVo) {
		
		int result = usDao.insertUser(usVo);
		
		if(result==1) {
			
			//회원가입 성공시 blog에 기본 정보 insert
			
			BlogVo joinBlVo = new BlogVo();
			
			joinBlVo.setId(usVo.getId());
			joinBlVo.setBlogTitle(usVo.getUserName()+"의 블로그입니다");
			joinBlVo.setLogoFile("spring-logo.jpg");
			
			blDao.insertBlog(joinBlVo);
			
			//회원가입 성공시 blog category에 기본 정보 insert
			
			CategoryVo joinCaVo = new CategoryVo();
			
			joinCaVo.setCateName("미분류");
			joinCaVo.setId(usVo.getId());
			joinCaVo.setDescription("기본으로 만들어지는 카테고리입니다");
			
			caDao.insertCategory(joinCaVo);
			
			//회원가입 성공시 blog post에 기본 정보 insert
			
			PostVo joinPoVo = new PostVo();
			
			joinPoVo.setCateNo(joinCaVo.getCateNo());
			joinPoVo.setPostTitle("등록된 글이 없습니다.");
			
			poDao.insertPost(joinPoVo);
			
		}
		
		else {
			
		}
	}
	
	
	public UserVo login(UserVo usVo) {
		
		//로그인 성공시 session에 넘겨줄 기본정보 가져옴
		
		
		return usDao.selectUser(usVo);
	}
	
	/*
	public UserVo getId(String id) {
		
		return usDao.selectId(id);
	}
	*/
	
	
	
	
}
