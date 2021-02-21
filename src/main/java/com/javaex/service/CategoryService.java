package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao caDao;
	@Autowired
	private BlogDao blDao;
	
	public List<CategoryVo> getInfo(String id) {
		
		
		
		return caDao.selectInfo(id);
	}
	
	
	
}
