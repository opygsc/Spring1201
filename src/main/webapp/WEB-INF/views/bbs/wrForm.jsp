<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>wrForm</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 등록</h1>
		<form name="form" method="post" action="wrAction" encType="multipart/form-data"> <!-- encType을 적어줘야 첨부파일이 서버로 전송됨 -->
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="file"></td> <!-- 파일 한 개만 올리는 샘플, 여러개 올리면 서버에서 배열 -->
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="file"></td> <!-- 파일 한 개만 올리는 샘플, 여러개 올리면 서버에서 배열 -->
				</tr>
			</table>
			<br> <br> <input type="submit" value="등록">
			<input type="reset" value="다시 작성">
			<a href="/cafe1201/"><input type="button" value="홈"></a>
		</form>
	</div>
</body>
</html>