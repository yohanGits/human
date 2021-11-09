<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>2021. 10. 18.오후 2:20:09</title>
</head>
<body>
	<h4>all</h4>
	<a href="member">member</a>
	<a href="admin">admin</a>
	
	<hr>
	<p>principal : <sec:authentication property="principal"/></p>
	<sec:csrfInput/>
	<sec:authorize access="isAuthenticated()">
		<p>memberVo : <sec:authentication property="principal.memberVo"/></p>
		<p>userName : <sec:authentication property="principal.memberVo.userName"/></p>
		<p>username : <sec:authentication property="principal.username"/></p>
		<p>auths : <sec:authentication property="principal.memberVo.auths"/></p>
	</sec:authorize>
	
</body>
</html>