<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
</head>

<body>
	<jsp:include page="../common/header.jsp" />
	<main class="findPwd  p-5 my-5">
	<%! public int getRandom(){
		int random = 0;
		random = (int)Math.floor((Math.random()*(99999-10000+1)))+10000;
		return random;
		} %>
	<form method="post" style="margin-left: 280px">
		<fieldset>
			<legend style="font-family: 'BBTreeGB'; margin-left: 90px">비밀번호 찾기</legend>
			<table>
				<tr>
					<td>아이디</td>
					<td></td>
					<td></td>
					<td><input type="text" id="id" name="id" class="form-control" placeholder="아이디를 입력하세요"; autofocus></td>	
				</tr>
				<tr>
				<td>
				</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td></td>
					<td></td>
					<td><input type="email" id="email" name="email" class="form-control" placeholder="이메일을 입력하세요"></td>
					<td><input type="submit" id="submit" style="font-family: 'BBTreeGB';background-color: #052387; border-color: #052387; margin-left: 10px" class="btn btn-primary btn-sm" value="인증번호 발송"></td>
					<td><input type="hidden" readonly="readonly" 
					id="codecheck" name="codecheck" value="<%=getRandom()%>"></td>
				</tr>
			</table>
				<h6 style="margin-left: 70px; margin-top:20px; color: red"><%=request.getParameter("msg") == null? "" : request.getParameter("msg") %></h6>
		</fieldset>
	</form>
	</main>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>