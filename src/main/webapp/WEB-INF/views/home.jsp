<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
   <section>section</section>
   <div id="loginDV">
      <form id="loginForm" action="login" method="post">
         <table>
            <tr>
               <td>ID</td>
               <td><input type="text" id="id" name="id"></td>
            </tr>
            <tr>
               <td>PW</td>
               <td><input type="password" id="pw" name="pw"></td>
            </tr>
            <tr>
               <td colspan=2><input type="submit" value="로그인">
               <input type="button" value="신규가입"></td>
            </tr>
         </table>
      </form>
   </div>
   <div id="zzz">
   div id="zzz"
   </div>
</body>
</html>