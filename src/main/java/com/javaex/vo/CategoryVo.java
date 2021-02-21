package com.javaex.vo;

public class CategoryVo {
	
	//오라클의 Category 테이블과 동일한 속성을 가진 필드들로 구성된 VO이며
	//insert, update, delete등과 같은 User 테이블 그 자체의 정보 변경을 위해서 
	//고안된 Vo
	
	
	private int cateNo;
	private String id, cateName, description, regDate;
	
	
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", description=" + description
				+ ", regDate=" + regDate + "]";
	}
	
	
	
	
	
	
	
	
}
