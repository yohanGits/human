<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp" />
	<style>
	.msg .pwdckmsg{height:20px;}
	
	.text-on-pannel {
  background: #fff none repeat scroll 0 0;
  height: auto;
  margin-left: 20px;
  padding: 3px 5px;
  position: absolute;
  margin-top: -47px;
  border: 1px solid #1c0075;
  border-radius: 8px;
}
	</style>
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<main class="info col-md-3 my-5 p-4" style="border: 1px solid black; border-radius:5px;">
	      <h4 class="text-on-pannel" style="margin-left: 80px; color: #1c0075;"><strong class="text-uppercase"> 회원정보 </strong></h4>
		<fieldset>
			<p></p>
			<p class="msg" style="font-weight: bold">ID : ${member.id}</p>
		
			<p class="msg" style="font-weight: bold">Email : ${member.email}</p>
			
			<p class="msg" style="font-weight: bold">이름 : ${member.name}</p>
			
			<div style="float:right; margin-top: 30px">
			<a href="index.html" class="btn btn-primary btn-sm" style="font-family: 'BBTreeGB'; background-color: #052387; border-color:  #052387">뒤로</a>
			<a href="changeInfo" class="btn btn-primary btn-sm" style="font-family: 'BBTreeGB'; background-color: #052387; border-color:  #052387">정보수정</a>
			<a href="memberOut" class="btn btn-danger btn-sm" style="font-family: 'BBTreeGB';">회원탈퇴</a>
			</div>
		</fieldset>
		
	</main>
	<script>

	</script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>