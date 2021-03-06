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
		<td><input type="text" name="title" id="title" class="form-control"></td>
	</tr>
	<tr>
		<td><input type="file" name="file1" class="form-control-file"></td>
	</tr>
	<tr>
		<td><input type="file" name="file2" class="form-control-file"></td>
	</tr>
	<tr>
		<td><input type="file" name="file3" class="form-control-file"></td>
	</tr>
	<tr>
		<td><textarea class="form-control" name="content" id="content"></textarea></td>
	</tr>
	<tr>
		<td><button class="btn btn-primary btn-sm" id="btnWrite" style="float: right; margin-right: 30px; width:60px; font-family: 'BBTreeGB';background-color: #052387;">작성</button></td>
	</tr>
</table>
</form>
</main>
<script>
	$(function(){
		$("#btnWrite").click(function(){
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
			return confirm("게시글을 작성하시겠습니까?");
		});
	});
</script>
<jsp:include page="../common/footer.jsp" />
</body>
</html>