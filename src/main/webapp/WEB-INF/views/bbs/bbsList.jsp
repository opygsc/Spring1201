<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>bbsList</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 목록</h1>
		<table class="list">
			<tr>
				<td colspan="6" style="border: white; text-align: right"><a href="wrForm">게시글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>수정/삭제</th>
			</tr>
			
			<!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
			<c:forEach items="${bList}" var="bVo">
				<tr class='record'>
					<td><a href='bbsView?vNo=${bVo.num}'>${bVo.num}</a></td>
					<td>${bVo.title}</td>
					<td>${bVo.name}</td>
					<td>${bVo.indate}</td>
					<td>${bVo.cnt}</td>
					<td><a href='bbsMod?vNo=${bVo.num}'>M</a>/<a href='bbsDel?vNo=${bVo.num}'>D</a></td>
				</tr>
			</c:forEach>
			
			<!-- 아래 paging -->
			<tr>
				<td colspan=6>
				<c:if test="${pageVo.prev}">
					<a href="bbsList?page=${pageVo.startPage - 1}">[이전페이지그룹]</a>
				</c:if>
				
				<!-- forEach	리스트 순회,	아래처럼 시작과 끝을 지정하여 반복해서 사용하는 것 -->
					<c:forEach begin="${pageVo.startPage}" end="${pageVo.endPage}" var="idx">
						<c:if test="${pageVo.page == idx}">*</c:if>
						<a href="bbsList?page=${idx}">${idx}</a>
					</c:forEach>
					<c:if test="${pageVo.next}">
						<a href="bbsList?page=${pageVo.endPage + 1}">[다음페이지그룹]</a>
				</c:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>