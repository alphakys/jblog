<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="UTF-8">
		
		<title>JBlog</title>
	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
	
	</head>
	
	<body>
		
		<div id="wrap">
			
			<!-- 개인블로그 해더 -->
			<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>
	
			<div id="content">
				<ul id="admin-menu" class="clearfix">
					<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/basic">기본설정</a></li>
					<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/category">카테고리</a></li>
					<li class="tabbtn"><a href="${pageContext.request.contextPath}/${authUser.id}/admin/writeForm">글작성</a></li>
				</ul>
				<!-- //admin-menu -->
				
				<div id="admin-content">
				
					<table id="admin-cate-list">
						<colgroup>
							<col style="width: 50px;">
							<col style="width: 200px;">
							<col style="width: 100px;">
							<col>
							<col style="width: 50px;">
						</colgroup>
			      		<thead>
				      		<tr>
				      			<th>번호</th>
				      			<th>카테고리명</th>
				      			<th>포스트 수</th>
				      			<th>설명</th>
				      			<th>삭제</th>      			
				      		</tr>
			      		</thead>
			      		<tbody id="cateList">
			      			
			      			<!-- 리스트 영역 -->
			      			
						</tbody>
					</table>
	      	
			      	<table id="admin-cate-add" >
			      		<colgroup>
							<col style="width: 100px;">
							<col style="">
						</colgroup>
			      		<tr>
			      			<td class="t">카테고리명</td>
			      			<td><input type="text" name="cateName" value=""></td>
			      		</tr>
			      		<tr>
			      			<td class="t">설명</td>
			      			<td><input type="text" name="description"></td>
			      		</tr>
			      	</table> 
				
					<div id="btnArea">
			      		<button id="btnAddCate" class="btn_l" type="button" >카테고리추가</button>
			      	</div>
				
				</div>
				<!-- //admin-content -->
			</div>	
			<!-- //content -->
			
			
			<!-- 개인블로그 푸터 -->
			
			<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
		
		
		</div>
		<!-- //wrap -->
	</body>
	
		<script type="text/javascript">
		
		//페이지 로드시 카테고리 리스트 테이블 
		$("document").ready(function(){
				
			fetchList();	
				
		});
					
		
			function render(caVo, postCnt){
					
				let table = "<tr>";
					table += 	"<td>"+caVo.cateNo+"</td>";
					table += 	"<td>"+caVo.cateName+"</td>";
					table += 	"<td>"+postCnt+"</td>";
					table += 	"<td>"+caVo.description+"</td>";
					table += 	"<td class='text-center'>";
					table += 	"<a href=''><img class= 'btnCateDel' src='${pageContext.request.contextPath}/img/delete.jpg'></a>";
					table += 	"</td>";
					table += "</tr>";
							
				$("#cateList").append(table);				
			};
				
			
			
			function fetchList(caVo){
				
				let	id= '${authUser.id}';
	
				$.ajax({
					
					url: "${pageContext.request.contextPath}/api/category/info",
					
					type: "post",
					
					//서버로 전송할 데이터 타입
					contentType: "application/json",
					
					//서버로 전송할 데이터가 json이니까 자바스크립트 객체를 json으로 변환해서 보내!
					data: JSON.stringify(id),
						
					dataType: "json",
					
					success: function(caMap){
						
						for(var i=0; i<caMap.caList.length; i++){
							
							if(caMap.postCntList[i] ==undefined){
									caMap.postCntList[i] =0;
							}
							
							render(caMap.caList[i], caMap.postCntList[i]);
						}
						
					},
					
					error: function(XHR, status, error){
						console.log(status+ ":" + error);
						
					}
					
				
					
				});
				
			
				
			};	
			
			
			//카테고리 삭제
			
			$("#btnCateDel").on("click", function(){
				
				
				
				
				
				
			})
		
			//카테고리 추가
			
			$("#btnAddCate").on("click", function(){
				
				let CategoryVo = {
						
					id: '${authUser.id}',
					cateName: $("[name='cateName']").val(),
					description: $("[name='description']").val()
				}
				
				$.ajax({
					
					url: "${pageContext.request.contextPath}/api/category/add",
					
					type: "post",
					
					contentType: "application/json",
					
					data: JSON.stringify(CategoryVo),
					
					dataType: "json",
					
					success: function(result){
						
						if(result==1){
							alert("카테고리를 추가했습니다");
						}
						else{
							alert("다시 시도해주세요");
						}
					},
					
					error: function(XHR, status, error){
						console.log(status+ ":" + error);
					}
					
				});
				
				
				
			});

			

		</script>


</html>