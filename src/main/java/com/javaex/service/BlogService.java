package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class BlogService {
		
	@Autowired
	private BlogDao blDao;
	@Autowired
	private CategoryDao caDao;
	@Autowired
	private PostDao poDao;
	
	public Map<String, Object> getBlogMain(String id, int cateNo, int postNo) {
		
		//url로 블로그 요청시 해당 아이디가 존재하는 지 확인하기 위한 메서드 selectBlog
		//그리고 존재할시 id와 이름 blogTitle, logoFile로 구성된 MainDto --> checkId
		BlogVo checkId = blDao.selectBasicInfo(id);
		
		Map<String, Object> blMap = new HashMap<>();
		
		if(checkId==null) {
			//<checkId가 null시 (id가 존재하지 않을 시) BlogVo를 null로 보냄>
			
			blMap = null;
		
			return blMap;
		}
		else {
			//<checkId가 null이 아닐 시 blogMain에 뿌려줄 data들을 담을 Vo를 생성>
			
			
			//블로그 메인에 뿌려줄 로고 파일과 블로그 타이틀 cateName리스트
			blMap.put("caList", caDao.selectCateNameList(id));
			
			List<CategoryVo> caList = caDao.selectCateNameList(id);
			caList.get(0);
			
			blMap.put("blVo", checkId);
			blMap.put("poList", poDao.selectPostList(id, cateNo));
			blMap.put("postVo", poDao.selectPost(postNo));
			
			return blMap;
		}
		
		
	}
	
	
	public void addPost(PostVo poVo) {
		
		poDao.insertPost(poVo);
	
	}
	
	

	
	public BlogVo getBasicInfo(String id) {
		
		return blDao.selectBasicInfo(id);
		
	}
	
	
	public List<CategoryVo> getCateName(String id) {
		
		return caDao.selectCateNameList(id);
			
	}
	

	
	public void modifyBasicInfo(BlogVo modiVo, MultipartFile mulFile) {
		
		//오리지널 img 이름
		String orgName = mulFile.getOriginalFilename();
		//exName(확장자)
		String exName = orgName.substring(orgName.lastIndexOf("."));
		//saveDir --> img 저장할 파일 위치
		String saveDir = "C:\\Users\\gys11\\Desktop\\JavaStudy\\upload";
		//saveName --> img 파일 서버측에서 저장할 중복되지 않는 이름 할당
		String logoFile = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		////**********파일이 사이트측 서버에 저장된 경로와 중복 방지를 위해 명명한 이름을 같이 붙여 만듬**********
		String filePath = saveDir +"\\"+ logoFile;
		
		try {
			
			byte[] fileData = mulFile.getBytes();
			
			FileOutputStream fos = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			bos.write(fileData);
			bos.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
	
		modiVo.setLogoFile(logoFile);
		
		blDao.updateBasicInfo(modiVo);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
