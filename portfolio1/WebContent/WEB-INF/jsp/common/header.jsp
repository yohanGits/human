<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header>
        <div class="header" style="border-bottom: 1px solid #b8c2e3;">
            <div style="margin-bottom: 20px">
                <a href="<%=request.getContextPath()%>/index.html"><span style="color:#fff; margin: 50px"><i class="fas fa-moon fa-5x"></i></span></a>
                <p>Amazing Nature</p>
            </div>
        </div>
        <nav class="navi" style="border-bottom: 1px solid #b8c2e3;">
            <ul>
                <li><a href="<%=request.getContextPath()%>/notice/list">공지사항</a></li>
                <li><a href="<%=request.getContextPath()%>/board/list">자유게시판</a></li>
                <li><a href="<%=request.getContextPath()%>/gallery/list">갤러리</a></li>
            </ul>
        </nav>
 </header>    