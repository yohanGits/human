<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<main class="findPwd p-5 my-5">

		<div style="margin-left: 350px">
			<h4 style="font-family: 'BBTreeGB'; margin-left: 30px">인증번호 확인</h4>
			<table>
				<tr>
					<td><input type="text" id="code" onkeyup="checkCode()" name="code" class="form-control" placeholder="인증번호를 입력하세요">
					<p class="checkCode"></p>
				</tr>
				<tr>
					<td><input type="hidden" readonly="readonly" 
					id="codecheck" name="codecheck" value="<%=request.getAttribute("code")%>"></td>
				</tr>
			</table>
			<button id="certi2" class="btn btn-primary" onclick="next()" style="height:30px;width:70px; border-color: #052387; margin-left:130px; font-family: 'BBTreeGB'; background-color: #052387; padding: 1px 1px 2px 1px">인증하기</button>
		</div>
	</main>
	<jsp:include page="../common/footer.jsp" />
	<script>
		function checkCode(){
			var v1 = $("#codecheck").val();
			var v2 = $("#code").val();
			if(v1!=v2){
				 $("#code").next().text("인증번호가 일치하지 않습니다.").css("color","red");
				 
			} else {
				$("#code").next().text("인증 되었습니다").css("color","green");
			}
		}
		
		function next() {
		var id = '${param.id}';
		var v1 = $("#codecheck").val();
		var v2 = $("#code").val();
			if(v1 != v2){
				alert("인증번호가 일치하지 않습니다")
				return false;
			} else {
			location.href="checkPwd?id="+id;
			}
		}	
		

	</script>
</body>
</html>