package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int insertCategory(CategoryVo caVo) {
		 	
		return sqlSession.insert("category.insert", caVo);
		
	}
	
	public List<Integer> selectPostCnt(String id){
		
		
		return sqlSession.selectList("category.selectPostCnt", id);
	}
	
	
	//카테고리 리스트 가져오는 메소드
	public List<CategoryVo> selectCateNameList(String id) {
			
		return sqlSession.selectList("category.selectCateName", id);
	}
	
	
	public List<CategoryVo> selectInfo(String id) {
		
		return sqlSession.selectList("category.selectInfo", id);
	}
	
	
	
	
}
