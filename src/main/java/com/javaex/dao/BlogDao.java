package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;
import com.javaex.vo.MainDto;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public void insertBlog(BlogVo blVo) {
		
		sqlSession.insert("blog.insert", blVo);
	}
	
	
	public MainDto selectBlog(String id) {
		
		
		return sqlSession.selectOne("blog.selectBlog", id);
	}
	
	
	public BlogVo selectBasicInfo(String id) {
		
		
		return sqlSession.selectOne("blog.selectInfo", id);
		
	}
	
	
	public void updateBasicInfo(BlogVo modiVo) {
		
		sqlSession.update("blog.updateBasicInfo", modiVo);
	}
	
	
	
	
	
	
	
}
