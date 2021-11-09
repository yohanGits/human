<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
<style>
.detail table{width: 80%; margin: 40px auto; border-collapse: collapse;}
.detail td{padding: 8px; border-top:3px solid #bbb; border-bottom: 3px solid #bbb;}
.detail textarea{width: 100%; height: 300px;}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<main class="detail">
<form method="post" enctype="multipart/form-data">
<table class="table table-striped" style="border: 1px solid #dddddd">
	<tr>
		<td><input type="text" name="title" class="form-control"></td>
	</tr>
	<tr>
		<td><input type="file" name="file1" accept="image/png, image/jpeg, image/gif"></td>
	</tr>
	<tr>
		<td><input type="file" name="file2" accept="image/png, image/jpeg, image/gif"></td>
	</tr>
	<tr>
		<td><input type="file" name="file3" accept="image/png, image/jpeg, image/gif"></td>
	</tr>
	<tr>
		<td><button class="btn btn-primary btn-sm" style="float: right; width:60px; font-family: 'BBTreeGB';background-color: #052387; border-color: #052387;"">작성</button></td>
	</tr>
</table>
</form>
</main>
<jsp:include page="../common/footer.jsp" />
</body>
</html>