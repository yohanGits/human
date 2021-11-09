<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
<style type="text/css"></style>
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<main class="findID p-5 my-4">
	<form method="post" >
		<fieldset>
			<legend style="font-family: 'BBTreeGB'; margin-left: 155px; margin-bottom: 20px">ID 찾기</legend>
			<h5><label for="name" style="font-family: 'BBTreeGB';">이름</label></h5>
			<input type="text" name="name" id="name" class="form-control" style="margin-bottom: 15px" placeholder="이름을 입력해주세요" autofocus>
			<h5><label for="email" style="font-family: 'BBTreeGB';">이메일</label></h5>
			<input type="text" name="email" id="email" class="form-control" placeholder="이메일을 입력해주세요">
			<p><button id="findID" class="btn btn-primary btn-sm" style="font-family: 'BBTreeGB'; margin-top: 15px; background-color: #052387; border-color: #052387;">아이디 찾기</button></p>
			<h6 style="margin-left: 115px; color: red"><%=request.getParameter("msg") == null? "" : request.getParameter("msg") %></h6>
		</fieldset>
	</form>
	<div style="float: right; height: 60px; margin-right: 250px; margin-top: 20px">
	<a href="index.html" class="btn btn-primary btn-sm" style="font-family: 'BBTreeGB'; background-color: #052387; border-color: #052387;">뒤로</a>
	<a href="findPwd" class="btn btn-primary btn-sm" style="font-family: 'BBTreeGB'; background-color: #052387; border-color: #052387;">비밀번호 찾기</a>
	</div>
	</main>
	
	<jsp:include page="../common/footer.jsp" />
	<script>
		$(function(){
			$("#findID").click(function(){
				var name = $("#name").val();
				var email = $("#email").val();
				if(name == "" && email == ""){
					alert("모든 정보를 입력해 주세요");
					return;
				}
			})
		})
	</script>
</body>
</html>