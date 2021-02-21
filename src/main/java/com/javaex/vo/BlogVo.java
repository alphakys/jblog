package com.javaex.vo;

public class BlogVo {
	
	//오라클의 Blog 테이블과 동일한 속성을 가진 필드들로 구성된 VO이며
	//insert, update, delete등과 같은 User 테이블 그 자체의 정보 변경을 위해서 
	//고안된 Vo
	
	
	private String id, blogTitle, logoFile;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(String logoFile) {
		this.logoFile = logoFile;
	}

	
	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", blogTitle=" + blogTitle + ", logoFile=" + logoFile + "]";
	}
	
	
		
	
}
