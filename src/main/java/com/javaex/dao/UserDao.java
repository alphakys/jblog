package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int insertUser(UserVo usVo) {
		
		return sqlSession.insert("user.insert", usVo);
		
	}
	
	//로그인!!!을 위한 user 정보 조회 메소드
	public UserVo selectUser(UserVo usVo) {
		
		return sqlSession.selectOne("user.selectUser", usVo);
	}
	
	
	public String selectId(String id) {
		
		return sqlSession.selectOne("user.selectId", id);
	}
	
}
