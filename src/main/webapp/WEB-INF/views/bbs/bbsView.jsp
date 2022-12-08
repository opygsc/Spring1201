<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbsView</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 자세히보기</h1>
		<form name="form" method="post" action="wrAction" encType="multipart/form-data"> <!-- encType을 적어줘야 첨부파일이 서버로 전송됨 -->
			<table>
				<tr>
					<th>작성자</th>
					<td>${boardVo.name}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${boardVo.email}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${boardVo.title}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${boardVo.cnt}</td>
				</tr>
				<tr>
					<th>게시일</th>
					<td>${boardVo.indate}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${boardVo.content}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<c:forEach items="${attachList}" var="fName">${fName}<br>
							<%-- <a href="download?fileName=${fName}"></a> --%>
							<img src="download?fileName=${fName}"><br>					
						</c:forEach>
					</td>
				</tr>
		<!--	<tr> 
					<th>첨부파일</th>
					<td>
 						<c:forEach items="${attachList}" var="fName">
							<a href="download?fileName=${fName}">${fName}</a><br>
						</c:forEach>
					</td>  파일 한 개만 올리는 샘플, 여러개 올리면 서버에서 배열 
				</tr> -->
			</table>
			<br><br> 
			<input type="button" value="목록-히스토리백" onclick="history.go(-1)">
			<input type="button" value="목록-컨트롤러호출" onclick="location.href='bbsList'">
		</form>
	</div>
	<script type="text/javascript">
	</script>
</body>
</html>