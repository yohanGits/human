<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
</head>
<style>	.text-on-pannel {
  background: #fff none repeat scroll 0 0;
  height: auto;
  margin-left: 20px;
  padding: 3px 5px;
  position: absolute;
  margin-top: -47px;
}
</style>
<body>
	<jsp:include page="../common/header.jsp" />
	<main class="login p-5 my-5">
	<form method="post" class="form-group">
			<h3 class="text-on-pannel" style="margin-left: 140px; color: #052387;"><strong> 회원탈퇴 </strong></h3>
		<fieldset>
			<h5><label class="id m-1" style="font-family: 'BBTreeGB';">회원 ID : ${member.id}</label></h5>
			<h5><label for="pwd" class="m-1" style="font-family: 'BBTreeGB';">비밀번호</label></h5>
			<input class="pwd m-2 form-control" type="password" name="pwd" id="pwd" placeholder="비밀번호를 입력하세요">
			<p><button class="btn btn-danger m-2" id="out" style="font-family: 'BBTreeGB';">회원탈퇴</button></p>
		</fieldset>
	</form>
			<a href="index.html" class="btn btn-primary btn-sm" style="font-family: 'BBTreeGB'; float: right; margin-right: 237px; background-color: #052387; border-color:  #052387;">취소</a>
	</main>
	<jsp:include page="../common/footer.jsp" />
	<script>
		$(function(){
			$("#out").click(function(){
				var password = $("#pwd").val()
				
				if(password == ""){
					alert("비밀번호를 입력하세요");
					$("#pwd").focus();
					return false;
				}
				if(password != member.pwd){
					alert("비밀번호가 틀렸습니다");
					$("#pwd").focus();
					return false;
				} else {
					return confirm("회원탈퇴 하시겠습니까?");
				}
				
			})
		})
	</script>
</body>
</html>