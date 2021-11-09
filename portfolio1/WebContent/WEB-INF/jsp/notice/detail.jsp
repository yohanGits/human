<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common/head.jsp" />
<style>
.detail table{width: 80%; margin: 25px auto; border-collapse: collapse; border-radius: 3px;}
.detail td{padding: 8px;border:1px solid #bbb; border-bottom: 1px solid #bbb;}
.detail td + td{width: 20%}
.detail tr:last-child td{height: 300px; vertical-align: top; white-space: pre-line;}
.button {height: 100px; margin-bottom: 20px;}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<main class="detail">
<div class="container" style="position: relative">
<table class="table table-striped">
	<tr></tr>
	<tr>
		<td>${board.title}</td>
		<td style="text-align: center;">${board.regDate}</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:forEach items="${board.attachs}" var="attach">
			<p><a href="${pageContext.request.contextPath}/download?filename=${attach.path}/${attach.uuid}">${attach.origin}</a></p>
			</c:forEach>
		</td>
	</tr>
	<tr>
		<td colspan="2">${board.content}</td>
	</tr>
</table>
	<div class="button" style="float: right; margin-right: 100px">
	<c:if test="${member.id == board.id}">
        <button type="submit" class="btn btn-danger btn-sm mx-1" id="deleteBD" style="width:60px; font-family: 'BBTreeGB';">삭제</button>
		<button type="submit" class="btn btn-primary btn-sm mx-1" onclick="location.href='${pageContext.request.contextPath}/notice/modify?bno=${board.bno}'" style="width:60px; border-color: #052387; font-family: 'BBTreeGB';background-color: #052387;">수정</button>
	</c:if>	
        <button type="submit" class="btn btn-primary btn-sm mx-1" onclick="location.href='${pageContext.request.contextPath}/notice/list'" style="width:60px; border-color: #052387; font-family: 'BBTreeGB';background-color: #052387;">목록</button>
	</div>
<c:if test="${not empty member}">
<div class="col-10 mx-auto" style="clear: both;">
	<div class="form-group clearfix">
		<p>${member.name}</p>
		<form id="frmReplyWrite">
  		<input type="text" class="form-control" placeholder="댓글 제목을 입력하세요" name="title" id="title">
  		<textarea class="form-control my-1" placeholder="댓글을 입력하세요" name="content" id="content"></textarea>
  		<input type="hidden" name="bno" value="${board.bno}">
  		<input type="hidden" name="id" value="${member.id}">
  		<button class="btn btn-primary btn-sm float-right disabled" id="btnReplyWrite" style="width:60px; font-family: 'BBTreeGB';">등록</button>
  		</form>
  	</div>
</div>
</c:if>

<div class="container col-10 mx-auto reply-wrapper">
</div>
</div>
</main>
<script>
var cp = "${pageContext.request.contextPath}";
var bno = '${param.bno}';
var id = '${member.id}';
$(function(){
	showList();
	function showList() {
		var url = cp + "/reply/list?bno=" + bno;
		console.log(url);
	
		$.getJSON(url).done(function(data){
			console.log(data);
			var str = "";
			for(var i in data){
				str += '<p id="repid">' + data[i].id + '</p>'
				str += '<div class="card my-3 border-right-0 border-left-0 rounded-0 shadow bg-white" data-rno="' + data[i].rno + '">'
				str += '	<div class="card-header" style="font-weight:bold">' + data[i].title +'</div>'
				str += '	<div class="card-body" style="font-size:15px">' + data[i].content + '</div>'
				str += '</div>'
			}
			$(".reply-wrapper").html(str);
			
			if(data[i].id == null){
				$("#repid").text("탈퇴회원");
			}
		})
	}
		// 이벤트 위임 댓글 상세 이벤트
		$(".reply-wrapper").on("click", ".card", function(){
			var url = cp + "/reply?rno=" + $(this).data("rno");
			$.getJSON(url).done(function(data) {
			if(id != data.id){
				return false;
			}
				$("#myModal")
					.data("rno", data.rno)
						.find(".modal-title").text(data.title)
					.end()
						.find(".modal-body").text(data.content)
					.end()
					.modal("show");
			});
	});
	
	$("#btnRm").click(function(){
// 		alert($(this).closest(".modal").data("rno"));
// 		alert($(this).closest(".modal").data("id"));
		var rno = $(this).closest(".modal").data("rno");
		var url = cp + "/reply?rno=" + rno;
		
		$.ajax(url, {
			method:"delete",
			success : function(data){
				console.log(data);
				// 성공적으로 종료
				showList();
				$("#myModal").modal("hide");
			}
		});
	});
		
	$("#title, #content").keyup(function(){
		var titleLen = $("#title").val().trim().length;
		var contentLen = $("#content").val().trim().length;
		
		if(titleLen && contentLen){
			$("#btnReplyWrite").removeClass("disabled");
		}		
		else{
			$("#btnReplyWrite").addClass("disabled")
		}
	});
		
	$("#frmReplyWrite").submit(function(){
		event.preventDefault();
		if($("#frmReplyWrite").is(".disabled"))return;
		
		var reply = {};
		reply.title = $(this.title).val();
		reply.content = $(this.content).val();
		reply.id = $(this.id).val();
		reply.bno = $(this.bno).val();
		
		var data = JSON.stringify(reply);
		
		console.log(reply);
		console.log(data);
		
		var frm = this;
		var url = cp + "/reply"
		$.ajax(url,{
			method:"post",
			data : {"jsonData" : data},
			success : function(data){
				showList();
				frm.reset();
				$("#btnReplyWrite").addClass("disabled");
			}
		})
	});
	
	$(function(){
		$("#btnReplyWrite").click(function(){
			var title = $("#title").val();
			var content = $("#content").val();
			if(title == ""){
				alert("댓글 제목을 입력하세요");
				$("#title").focus();
				return false;
			}
			if(content == ""){
				alert("댓글 내용을 입력하세요");
				$("#content").focus();
				return false;
			}
			return confirm("댓글을 작성하시겠습니까?");
		});
	});
	
		$("#deleteBD").click(function(){
			var bno = ${param.bno};
			var url = cp + "/board/detail?bno=" + bno;
			
			// ajax
			var msg = confirm("게시글을 삭제하시겠습니까?");
			if(msg == true) {
				$.ajax(url, {
					method : "delete",
					success : function(data){
						alert("삭제되었습니다.");
						location.href="list"
					}
				})
			} else {
				return false;
			}
		});
		
		$("#btnmd").click(function(){
			var rno = $(this).closest(".modal").data("rno");
			var title = $("#title1").val();
			var content = $("#content1").val();
			var url = cp + "/reply?rno=" + rno + "&title=" + title + "&content=" + content;
			
			if(title == "") {
	        	 alert("수정할 제목을 입력하세요");
	        	 $("#title1").focus();
	        	 return false;
	         }
			if(content == "") {
	        	 alert("수정할 내용을 입력하세요");
	        	 $("#content1").focus();
	        	 return false;
	         }
			// ajax
			var msg = confirm("댓글을 수정하시겠습니까?");
			if(msg == true) {
				$.ajax(url, {
					method : "put",
					success : function(data){
						alert("수정되었습니다.");
						showList();
						$("#myModal").modal("hide");
					}
				})
			} else {
				return false;
			}
		});
});

</script>
<!-- The Modal -->
<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
	  
	  <div class="modal-header">
	  <input id="title1" type="text" class="form-control" style="width:500px" placeholder="수정할  제목을 입력하세요">
	  </div>
      
      <!-- Modal body -->
      <div class="modal-body">
        Modal body..
      </div>
	  
	  <div class="modal-header">
	  <textarea id="content1" class="form-control" name="content" id="content" placeholder="수정할  내용을 입력하세요"></textarea>
	  </div>
	  
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger btn-sm mx-1" id="btnmd" style="width:60px; font-family: 'BBTreeGB'; border-color: #052387; background-color: #052387;">수정</button>
        <button type="button" class="btn btn-danger btn-sm mx-1" id="btnRm" style="width:60px; font-family: 'BBTreeGB';">삭제</button>
      </div>

    </div>
  </div>
</div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>