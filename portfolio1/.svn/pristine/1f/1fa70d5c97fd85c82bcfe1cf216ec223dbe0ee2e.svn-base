<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp" />
<style>
	.gall{background-image: url( "${pageContext.request.contextPath}/resources/images/background.png" );}
	.brd{background-image: url( "${pageContext.request.contextPath}/resources/images/background.png" );}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
    <main class="index">
        <section>
            <article>
                <div class="slider">
					<img alt="daisies" src="${pageContext.request.contextPath}/resources/images/bluelava.png">
					<img alt="plant" src="${pageContext.request.contextPath}/resources/images/storm.png">
					<img alt="succulents" src="${pageContext.request.contextPath}/resources/images/hole.png">
                </div>
            </article>
            
            <div class="gall" style="border: 1px solid black; border-radius: 3px; margin-bottom: 10px; font-weight: bold;">
            <h2 class="display-6 p-4" style="text-align: center; font-family:'Noto Serif KR', serif;">Photo</h2>
            <ul class="row justify-content-center y-6">
            <c:forEach items="${list2}" var="b">
                <li class="col-5 m-2">
                	<a href="gallery/detail?bno=${b.bno}" style="color: black;">
                    <div style="background-color: #fafcff; padding: 15px; border-radius: 5px; font-family: 'Noto Serif KR', serif;">
                        <h4 class="text-truncate small" style="text-align: center; font-weight: bold; font-size: 12px"><c:out value="${b.title}" escapeXml="true"/></h4>
                        <hr style="height: 3px">
                        <img style="width:100px; height: 100px; display: block; margin: 0 auto;" class="border border-secondary" src="${pageContext.request.contextPath}/display?filename=${b.attachs[0].path}/s_${b.attachs[0].uuid}">
                        <hr style="height: 3px">
                    </div>
                    </a>
                </li>
             </c:forEach>
      		</div>
      		
      		<div class="brd" style="border: 1px solid black; border-radius: 3px; font-weight: bold;">
            <h2 class="display-6 p-4" style="text-align: center; font-family:'Noto Serif KR', serif;">Article</h2>
            <ul class="row justify-content-center y-6">
            <c:forEach items="${list}" var="b">
                <li class="col-5 m-2">
                	<a href="board/detail?bno=${b.bno}" style="color: black;">
                    <div style="background-color: #fafcff; padding: 15px; height: 110px; border-radius: 5px">
                        <h4 class="text-truncate small" style="margin-top: 5px; font-family: 'Noto Serif KR', serif; font-weight: bold;"><c:out value="${b.title}" escapeXml="true"/></h4>
                        <hr style="height: 3px">
                        <p class="text-truncate text-mute small" style="font-family: 'Noto Serif KR', serif;"><c:out value="${b.content}" escapeXml="true"></c:out></p>
                    </div>
                    </a>
                </li>
             </c:forEach>
             </div>

            </ul>
        </section>
        <aside>
        <c:choose>
        	<c:when test="${empty member}">
        	<form action="login" >
                <input type="submit" value="로그인" style="border-radius: 5px; border: 0;  background-color: #052387; color: white">
            </form>
            <p style="margin-left: 4px"><a href="join" style="text-decoration: none; font-family: 'BBTreeGB'; color: black;">회원가입</a> <a href="findID" style="text-decoration: none; font-family: 'BBTreeGB'; color: black; margin-left: 3px">ID/PW찾기</a></p>
        	</c:when>
        	<c:otherwise>
        	<div style="border: 1px solid #052387; padding: 10px; width:140px; height: 70px; text-align: center; border-radius: 5px">
        	<p>${member.id}님 <br>환영합니다.</p>
        	</div>
        	<div style="margin-top: 7px">
        	<p><a href="memberInfo" style="text-decoration: none; color: black; font-family: 'BBTreeGB'; margin-left: 10px">회원정보</a> <a href="logout" style="text-decoration: none;font-family: 'BBTreeGB'; color: black; margin-left: 3px">로그아웃</a><p>
        	</div>
        	</c:otherwise>
        </c:choose>
        </aside>
    </main>
    <script>
    	$(".slider").bxSlider({
    		mode:'fade',
    		pager:true,
    		controls:false,
    		auto:true,
    		adaptiveHeight:true
    	});
    </script>
 	<jsp:include page="footer.jsp" />
</body>
</html>