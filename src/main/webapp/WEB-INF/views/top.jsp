<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>top</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css">
</head>
<body>
   <div id="titleDV">
      HomePage
   </div>
   <div id="logininfo">
      Login user : ${login}님 로그인
      <c:if test="${login != null }">
      	<a href="logout">[로그아웃]</a>
      	</c:if>
      <!-- 세션처리 -->
   </div>
   
   <header> 스프링게시판 </header>
   <nav>
      <a href="/cafe1201/">[Home]</a> 
      <a href="wrForm">[Write]</a> 
      <a href="bbsList">[BBSList]</a>
   </nav>
</body>
</html>