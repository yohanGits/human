<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../common/head.jsp" />
	<style>
	.msg .pwdckmsg{height:20px;}
	</style>
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<main class="login p-5">
	<div id="checkType" class="container" style="position: relative">
	<form method="post" class="form-group">
		<fieldset>
			<legend style="font-family: 'BBTreeGB'; margin-left: 150px; margin-bottom: 15px">회원가입</legend>
			<label for="id" style="font-family: 'BBTreeGB';">아이디</label>
			<input type="text" name="id" id="id" class="form-control" placeholder="아이디를 입력하세요" autofocus>
			<p class="msg"></p>
			<button class="btn btn-primary btn-sm float-right" type="button" id="ckbtn" style="width:80px; background-color: #052387; border-color: #052387; position:absolute; top:82px; left:660px; font-family: 'BBTreeGB';">
			중복체크</button>
			
			<label for="pwd" style="font-family: 'BBTreeGB';">비밀번호</label>
			<input type="password" name="pwd" id="pwd" class="form-control" placeholder="비밀번호를 입력하세요">
			<p class="msg"></p>
			
			<label for="pwd" style="font-family: 'BBTreeGB';">비밀번호 확인</label>
			<input type="password" id="pwdck" class="form-control" placeholder="비밀번호를 확인하세요">
			<p class="pwdckmsg"></p>
			
			<label for="email" style="font-family: 'BBTreeGB';">이메일</label>
			<input type="text" name="email" id="email" class="form-control" placeholder="이메일을 입력하세요">
			<p class="msg"></p>
			<button class="btn btn-primary btn-sm float-right" type="button" id="ckbtn1" style="width:80px; background-color: #052387; border-color: #052387; position:absolute; top:350px; left:660px; font-family: 'BBTreeGB';">
			중복체크</button>
			
			<label for="name" style="font-family: 'BBTreeGB';">이름</label>
			<input type="text" name="name" id="name" class="form-control" placeholder="이름을 입력하세요">
			<p class="msg"></p>
			
			<button class="btn btn-primary" id="btnJoin" style="font-family: 'BBTreeGB'; background-color: #052387; border-color: #052387;">회원가입</button>
		</fieldset>
	</form>
	</div>
	</main>
	<script>
		var idcheck =0;
		var member = '${member.id}';
		$(function(){
			$("#ckbtn").click(function(){
				var id = $("#id").val();
		         if(id){
			            $.ajax("idValid?id="+id, {
			               success : function (data) {
			                  if(data/1){
			                     $("#id").next().text("사용 가능한 아이디입니다").css("color","green")
			                     idcheck = 1;
			                  }
			                  else {
			                     $("#id").next().text("이미 가입된 아이디입니다").css("color","red").focus();
			                     idcheck = 0;
							}
						}
					})
				}
			})
		})
		var emailcheck = 0;
		$(function(){
			$("#ckbtn1").click(function(){
				var email = $("#email").val();
		         if(email){
			            $.ajax("emailValid?email="+email, {
			               success : function (data) {
			                  if(data/1){
			                     $("#email").next().text("사용 가능한 이메일입니다").css("color","green")
			                     emailcheck = 1;
			                  }
			                  else {
			                     $("#email").next().text("중복된 이메일입니다").css("color","red").focus();
			                     emailcheck = 0;
							}
						}
					})
				}
			})
		})
	   $(function () {
		      $("#btnJoin").click(function () {
		         var id = $("#id").val();
		         var password1 = $("#pwd").val();
				 var password2 = $("#pwdck").val();
				 var email = $("#email").val();
				 var name = $("#name").val();
				 if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(password1)){            
				        alert('숫자+영문자+특수문자 조합으로 8자리 이상 사용해야 합니다.');
				        $('#pwd').val('').focus();
				        $('#pwdck').val('');
				        return false;
				 }    
		         if(id == "") {
		        	 alert("아이디를 입력하세요");
		        	 $("#id").focus();
		        	 return false;
		         }
		         if(password1 == "") {
		        	 alert("비밀번호를 입력하세요");
		        	 $("#pwd").focus();
		        	 return false;
		         }
		         if(password2 == "") {
		        	 alert("비밀번호를 확인하세요");
		        	 $("#pwdck").focus();
		        	 return false;
		         }
		         if(email == "") {
		        	 alert("이메일을 입력하세요");
		        	 $("#email").focus();
		        	 return false;
		         }
		         if(name == "") {
		        	 alert("이름을 입력하세요");
		        	 $("#name").focus();
		        	 return false;
		         }
		         if(idcheck == 0) {
		        	 alert("중복된 아이디입니다")
		        	 return false;
		         }
		         if(emailcheck == 0) {
		        	 alert("중복된 이메일입니다")
		        	 return false;
		         }
		         if(password1 != password2){
		        	 alert("비밀번호가 일치하지 않습니다.")
		        	 return false;
		         }
		         return confirm("회원가입 하시겠습니까?");
		      })
		   });
	   
	   $(function(){
		   $("#pwdck").keyup(function(){
			   var password1 = $("#pwd").val();
			   var password2 = $("#pwdck").val();
			   if(password1 != password2){
				   $("#pwdck").next().text("비밀번호가 일치하지 않습니다.").css("color","red");
			   } else {
				   $("#pwdck").next().text("").css("color","green");
			   }
		   })
	   })
		
	   
	</script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>