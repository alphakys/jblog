package com.javaex.vo;

public class UserVo {
	
	//오라클의 User 테이블과 동일한 속성을 가진 필드들로 구성된 VO이며
	//insert, update, delete등과 같은 User 테이블 그 자체의 정보 변경을 위해서 
	//고안된 Vo
	
	private int userNo;
	private String id, userName, password, joinDate;
	
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", userName=" + userName + ", password=" + password
				+ ", joinDate=" + joinDate + "]";
	}
	
	
	
}
