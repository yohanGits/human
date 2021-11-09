<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="area">
	<a href="${pageContext.request.contextPath}/common/mypage" class="nuxt-link-exact-active nuxt-link-active" >
		<h2 class="main_title" >마이페이지</h2>
	</a>
	<nav class="snb">
		<div class="snb_list">
			<strong class="snb_title">쇼핑 정보</strong>
			<ul class="snb_menu">
				<li class="menu-item"><a href="${pageContext.request.contextPath}/common/buying?id=<sec:authentication property='principal.member.id'/>" class="menu">구매 내역</a></li>
				<li class="menu-item"><a href="${pageContext.request.contextPath}/common/selling?id=<sec:authentication property='principal.member.id'/>" class="menu">판매 내역</a></li>
				<li class="menu-item"><a href="${pageContext.request.contextPath}/common/wish" class="menu">관심 상품</a></li>
			</ul>
		</div>
		<div class="snb_list">
			<strong class="snb_title">내 정보</strong>
			<ul class="snb_menu">
				<li class="menu-item"><a href="${pageContext.request.contextPath}/common/userModify" class="menu">프로필 정보</a></li>
				<li class="menu-item"><a href="${pageContext.request.contextPath}/common/address" class="menu">주소록</a></li>
				<li class="menu-item"><a href="${pageContext.request.contextPath}/common/payment?mno=<sec:authentication property='principal.member.mno'/>" class="menu">결제 정보</a></li>
				<li class="menu-item"><a href="#" class="menu" onclick="myPage(this)">판매 정산 계좌</a></li>
			</ul>
		</div>
	</nav>
	<script>
	function myPage() {
		event.preventDefault();
		alert("미구현페이지입니다")
		return false;
	}
	</script>
</div>
</body>
</html>