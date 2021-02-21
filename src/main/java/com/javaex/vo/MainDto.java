package com.javaex.vo;

public class MainDto {
	
	//insert, update, delete를 제외한 여러 테이블을 합쳐서 필요한 정보를 전달해야하는 목적을 위해 
	//만들어진 data 전달만을 목적으로 만든 객체 BlogMain에 전달한 데이터
	
	
	private String blogTitle, logoFile, id, userName, postTitle, PostContent, regDate;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return PostContent;
	}

	public void setPostContent(String postContent) {
		PostContent = postContent;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MainDto [blogTitle=" + blogTitle + ", logoFile=" + logoFile + ", id=" + id + ", userName=" + userName
				+ ", postTitle=" + postTitle + ", PostContent=" + PostContent + ", regDate=" + regDate + "]";
	}

	
	
	
	
	
}
