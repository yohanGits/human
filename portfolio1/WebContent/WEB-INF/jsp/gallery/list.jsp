<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp"></jsp:include>
<style>
img:hover{transform: scale(1.04); transition: 0.5s;}
.page-item.active .page-link {
  color: #fff !important;
  border-color:  #052387 !important;
  background:  #052387 !important;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<main class = "list">
<!-- 갤러리 사진부분 윗줄-->
   <div class="container" style="margin-top: 40px; margin-bottom: 40px; border: 1px solid black; text-align: center; border-radius: 4px; box-shadow: 0 0 5px 2px #bbb; background-color: #fff;">
   	<h2 style="font-family: 'Noto Serif KR', serif; margin-top: 15px"><em>Photo</em></h2>
   		<c:set var="endCount" value="${page.cri.amount - (page.cri.amount-1) % 3 + 2}"/>
   		<c:forEach begin="1" end="${endCount}" varStatus="stat">
   			<c:set var="board" value="${list[stat.index-1]}"/>
   			<c:if test="${stat.index % 3 == 1}">
   			<div class="row justify-content-center">
   			</c:if>
   			<div class="col m-4" >
   			<c:if test="${not empty board}">
             	<div><a href="detail?bno=${board.bno}"><img class="border border-secondary w-100" src="${pageContext.request.contextPath}/display?filename=${board.attachs[0].path}/s_${board.attachs[0].uuid}"></a></div>
             	<div class="text-nowrap text-truncate text-center" style="width : 250px">
                	<a href="detail?bno=${board.bno}">${board.title}</a>
             	</div>
        	</c:if>
        	</div>
   			<c:if test="${stat.index % 3 == 0}">
   			</div>
   			</c:if>
   		</c:forEach>
   		<hr>
      
<!--글쓰기버튼 -->
		 <c:if test="${not empty member}">
         <a href="write"><button class = "btn btn-primary btn-sm" style="width:70px; font-family: 'BBTreeGB'; background-color: #052387; border-color: #052387;">글쓰기</button></a>
         </c:if>
<!--         페이지 부분 -->
      <ul class="pagination justify-content-center my-5" style="margin-left: 10px">
           <li class="page-item ${page.prev ? '' : 'disabled'}">
              <a class="page-link" href="list?pageNum=${page.startPage-1}&amount=${page.cri.amount}">Previous</a>
           </li>
           
           <c:forEach begin="${page.startPage}" end="${page.endPage}" var="p">
           <li class="page-item ${p == page.cri.pageNum ? 'active' : ''}">
              <a class="page-link" href="list?pageNum=${p}&amount=${page.cri.amount}">${p}</a>
           </li>
           </c:forEach>
           
           <li class="page-item ${page.next ? '' : 'disabled' }">
              <a class="page-link" href="list?pageNum=${page.endPage+1}&amount=${page.cri.amount}">Next</a>
           </li>
      </ul>
</main>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>