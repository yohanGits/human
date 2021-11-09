<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
<style type="text/css"></style>

</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<main class="findID my-5">
	<div class="container p-5 my-3" style="height: 150px; border: 1px solid #b8c2e3; width: 300px; border-radius: 5px; text-align: center;">
	<div id="userName" style="font-family: 'BBTreeGB';">${member.name}님의 비밀번호는</div>
	<div id="userId" style="font-family: 'BBTreeGB';">[${member.pwd}] 입니다</div>
	</div>
	<div class="container" style="margin-left: 450px">
	<a href="login" class="btn btn-primary btn-sm" style="font-family: 'BBTreeGB'; background-color: #052387; border-color: #052387;">로그인</a>
	</div>
	</main>
	
	<jsp:include page="../common/footer.jsp" />
	<script>
	</script>
</body>
</html>