<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
		
		<div id="header" class="clearfix">
			<h1><a href="${pageContext.request.contextPath}/${blMap.blVo.id}">${blMap.blVo.blogTitle }</a></h1>
			
			<ul class="clearfix">
				<!-- 로그인 전 메뉴 -->
				
				<c:choose>
					<c:when test="${authUser.id eq blMap.blVo.id}">
						
						<li><a class="btn_s" href="${pageContext.request.contextPath}/${blMap.blVo.id}/admin/basic">내블로그 관리</a></li>
						<li><a class="btn_s" href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
														
					</c:when>
					<c:otherwise>
									 
						<li><a class="btn_s" href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
			 		
			 		</c:otherwise>
		 		</c:choose>
		 		
		 		<!-- 로그인 후 메뉴 -->
				<!-- 자신의 블로그일때만 관리 메뉴가 보인다. -->
		 		
			</ul>
			
		</div>
		<!-- //header -->
		
