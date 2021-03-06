<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
<style>
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<main class="modify">
<form method="post" enctype="multipart/form-data" style="margin-left: 150px">
<table class="table table-striped my-5 mx-1" style="border: 1px solid #dddddd; width: 80%; ">
	<tr>
		<td><input type="text" class="form-control" name="title" id="title" value="${board.title}"></td>
	</tr>
	<tr>
		<td><input type="file" class="form-control-file" name="file1"></td>
	</tr>
	<tr>
		<td><input type="file" class="form-control-file" name="file2"></td>
	</tr>
	<tr>
		<td><input type="file" class="form-control-file" name="file3"></td>
	</tr>
	<tr>
		<td><textarea class="form-control" name="content" id="content" style="height: 200px">${board.content}</textarea></td>
	</tr>
	<tr>
		<td><button class="btn btn-primary btn-sm" id="btnModify" style="width:60px; border-color: #052387; float: right; font-family: 'BBTreeGB';background-color: #052387;">수정</button></td>
	</tr>
</table>
</form>
</main>
<script>
	$(function(){
		$("#btnModify").click(function(){
			var title = $("#title").val();
			var content = $("#content").val();
			if(title == ""){
				alert("제목을 입력하세요");
				$("#title").focus();
				return false;
			}
			if(content == ""){
				alert("내용을 입력하세요");
				$("#content").focus();
				return false;
			}
			return confirm("게시글을 수정하시겠습니까?");
		});
	});
</script>
<jsp:include page="../common/footer.jsp" />
</body>
</html>