<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-dark text-white sidebar sidebar-dark " id="accordionSidebar" style="height: 1000px">
			
			<div style="background-color: rgb(11, 42, 73); height: 70px; text-align: center; padding: 20px" >
				<a style="font-weight: bold; font-size: 20px;">ADMINISTRATOR</a>
			</div>
			
            <!-- Sidebar - Brand -->
            <div style="background-color: black; height: 130px; text-align: center; padding: 25px">
                <i class="fas fa-user-tie fa-3x"></i>
                <div class="sidebar-brand-text mx-2 my-2">관리자님 안녕하세요</div>
			</div>
			
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/mProductList" style="text-align: center; padding: 10px; margin-bottom: 12px; margin-top: 12px">
                    <span>상품목록</span>
                </a>
            </li>
			
			 <hr class="sidebar-divider d-none d-md-block">
			
            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/mTrade" style="text-align: center; padding: 10px; margin-bottom: 12px">
                    <span>거래관리</span></a>
            </li>

			 <hr class="sidebar-divider d-none d-md-block">
			
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/mRegisterProduct" style="text-align: center; padding: 10px; margin-bottom: 12px;">
                    <span>상품등록</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            
                        <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/year/2021" style="text-align: center; padding: 10px; margin-bottom: 12px;">
                    <span>매출관리</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            
                        <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/mNoticeList1" style="text-align: center; padding: 10px; margin-bottom: 12px;">
                    <span>공지사항</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

        </ul>
        <!-- End of Sidebar -->