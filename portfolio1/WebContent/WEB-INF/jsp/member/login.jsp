<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<main class="login">
	<div style="height: 350px; margin-top: 40px">
	<form method="post">
		<fieldset>
			<h5><label for="id" style="font-family: 'BBTreeGB';">아이디</label></h5>
			<input type="text" name="id" id="id" class="form-control" style="margin-bottom: 15px">
			<h5><label for="pwd" style="font-family: 'BBTreeGB';">비밀번호</label></h5>
			<input type="password" name="pwd" id="pwd" class="form-control" style="margin-bottom: 10px">
			<p><label><input type="checkbox" name="savedID" id = "savedID" style="font-family: 'BBTreeGB';">아이디 저장</label></p>
			<p><button id="login" class="btn btn-primary" style="font-family: 'BBTreeGB'; background-color: #052387; border-color:  #052387;">로그인</button></p>
	<h6 style="margin-left: 85px; color: red"><%=request.getParameter("msg") == null? "" : request.getParameter("msg") %></h6>
		</fieldset>
	</form>
	</div>
	</main>
	<jsp:include page="../common/footer.jsp" />
	<script>
		var msg = ${param.msg}
		$(function(){
			if($.cookie("savedID")){
				$("#id").val($.cookie("savedID"));
				$("#savedID").prop("checked", true);
			}
		});
	</script>
</body>
</html>