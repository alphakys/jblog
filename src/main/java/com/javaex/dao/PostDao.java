package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertPost(PostVo poVo) {
		
		sqlSession.insert("post.insertPost", poVo);
	}
	
	
	public List<PostVo> selectPostList(String id, int cateNO){
		
		Map<String, Object> poMap = new HashMap<>();
		
		poMap.put("cateNo", cateNO);
		poMap.put("id", id);
		
		return sqlSession.selectList("post.selectPostList", poMap);
	}
	
	
	public PostVo selectPost(int postNo) {
		
		return sqlSession.selectOne("post.selectPost", postNo);
	}
	
	
	
	
	
}
