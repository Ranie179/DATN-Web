<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type ="text/css"> 
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <!-- Meta Description Tag -->
    <meta name="Description" content="Hỗ trợ y tế">
    <!-- Favicon Icon -->
    <link href='<c:url value="/resources/images/eevee.png" />' rel="icon" type="image/x-icon">
    <!-- Font Awesoeme Stylesheet CSS -->
    <link href='<c:url value="/resources/font-awesome/css/font-awesome.min.css" />' rel="stylesheet" type="text/css">
    <!-- Google web Font -->
    <link href='<c:url value="https://fonts.googleapis.com/css?family=Montserrat:400,500,600" />' rel="stylesheet" type="text/css">
    <!-- Bootstrap core CSS -->
    <link href='<c:url value="/resources/css/bootstrap.min.css" />' rel="stylesheet" type="text/css">
    <!-- Material Design Lite Stylesheet CSS -->
    <link href='<c:url value="/resources/css/material.min.css" />' rel="stylesheet" type="text/css">
    <!-- Material Design Select Field Stylesheet CSS -->
    <link href='<c:url value="/resources/css/mdl-selectfield.min.css" />' rel="stylesheet" type="text/css">
    <!-- Owl Carousel Stylesheet CSS -->
    <link href='<c:url value="/resources/css/owl.carousel.min.css" />' rel="stylesheet" type="text/css">
    <!-- Animate Stylesheet CSS -->
    <link href='<c:url value="/resources/css/animate.min.css" />' rel="stylesheet" type="text/css">
    <!-- Magnific Popup Stylesheet CSS -->
    <link href='<c:url value="/resources/css/magnific-popup.css" />' rel="stylesheet" type="text/css">
    <!-- Flex Slider Stylesheet CSS -->
    <link href='<c:url value="/resources/css/flexslider.css" />' rel="stylesheet" type="text/css">
    <!-- Custom Main Stylesheet CSS -->
    <link href='<c:url value="/resources/css/style.css" />' rel="stylesheet" type="text/css">
</head>
<body>
    <nav class="sidebar close">
        <header>
            <div class="image-text">
                <span class="image">
                	<img src = '<c:url value="/resources/images/eevee.png"></c:url>'>
                </span>

                <div class="text logo-text">
                    <span class="name">Rainie</span>
                    <span class="profession">Admin Site</span>
                </div>
            </div>

            <i class='bx bx-chevron-right toggle'></i>
        </header>
        <div class="menu-bar">
            <div class="menu">
                <ul class="menu-links">
                <li class="nav-link">
                        <a href="<%=request.getContextPath()%>/showUpcomingAppointment">
                            <i class='bx bx-home-alt icon'></i>
                            <span class="text nav-text">Home</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="<%=request.getContextPath()%>/adminShowAllAppointment">
                            <i class='bx bx-calendar-check icon' ></i>
                            <span class="text nav-text">Quản lý lịch hẹn</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="<%=request.getContextPath()%>/adminShowDoctor">
                            <i class='fa fa-user-md icon' ></i>
                            <span class="text nav-text">Quản lý bác sĩ</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="Inventory.jsp">
                            <i class='bx bxs-user-account icon'></i>
                            <span class="text nav-text">Quản lý tài khoản</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="<%=request.getContextPath()%>/adminShowBlog">
                            <i class='fa fa-newspaper-o icon'></i>
                            <span class="text nav-text">Quản lý bài viết</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="<%=request.getContextPath()%>/adminShowDepartment">
                            <i class='fa fa-building-o icon' ></i>
                            <span class="text nav-text">Quản lý khoa</span>
                        </a>
                    </li>
					<li class="nav-link">
                        <a href="<%=request.getContextPath()%>/adminShowService">
                            <i class='bx bx-donate-heart icon' ></i>
                            <span class="text nav-text">Quản lý dịch vụ</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="bottom-content">
                <li class="">
                    <a href="<%=request.getContextPath()%>/logout">
                        <i class='bx bx-log-out icon' ></i>
                        <span class="text nav-text">Logout</span>
                    </a>
                </li>
                <li class="mode">
                    <div class="sun-moon">
                        <i class='bx bx-moon icon moon'></i>
                        <i class='bx bx-sun icon sun'></i>
                    </div>
                    <span class="mode-text text">Dark mode</span>

                    <div class="toggle-switch">
                        <span class="switch"></span>
                    </div>
                </li>
                
            </div>
        </div>

    </nav>

    <section style = "height:auto;"  class="home">
        		    <!-- Start Doctor List Section -->
    <!-- Start My Profile Section -->
    <form action = "<%=request.getContextPath()%>/adminEditAccount" method="POST" enctype="multipart/form-data" onsubmit = "return(validate());">
    <div id="profile-page" class="layer-stretch">
        <div class="layer-wrapper">
            <div class="theme-material-card text-center">
            <p style = "text-align: center;"class="font-16">Thông tin của tài khoản</p>
             <c:if test="${not empty successMessage}">
						   <div class="alert alert-success" role="alert">
						        <strong>Thông báo</strong> Đã cập nhật thành công!!!
						        <button type="button" class="close" data-dismiss="alert">×</button>
						    </div>
						</c:if>
                <div class="row">
                   	<div class="col-md-8">
                   		<input style = "display: none;" class="mdl-textfield__input" type="text" id="id" name = "id" value = "${department.idDepartment }">
                   		<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-envelope-o"></i>
                            <input class="mdl-textfield__input" type="text" id="name" name = "name" value = "${account.email }">
                            <label class="mdl-textfield__label" for="profile-address-2">Email</label>
                            <span id="name-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường này không được để trống</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-key"></i>
                            <input class="mdl-textfield__input" type="password" id="name" name = "name" value = "${account.pass }">
                            <label class="mdl-textfield__label" for="profile-about">Mật khẩu</label>
                            <span id="intro-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường này không được để trống</span>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-user-circle-o"></i>
                             <select class="mdl-selectfield__select" id="status" name = "idDepartment">
				            <option value="" >user</option>
				            <option value="" >admin</option>
				        </select>
                            <span id="information-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường này không được để trống</span>
                        </div>
                        </div>
                    </div>
                <div class="form-submit">
                    <button type = "submit" class="mdl-button mdl-js-button mdl-js-ripple-effect button button-primary">Lưu</button>
                </div>
            </div>  
        </div>
    </div>
 </form><!-- End My Profile Section -->
    </section>
</body>
    <script src = '<c:url value="/resources/js/js-page-admin.js" />' ></script>
        <!-- Jquery Library 2.1 JavaScript-->
    <script src='<c:url value="/resources/js/jquery-2.1.4.min.js" />'></script>
    <!-- Popper JavaScript-->
    <script src='<c:url value="/resources/js/popper.min.js" />'></script>
    <!-- Bootstrap Core JavaScript-->
    <script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
    <!-- Material Design Lite JavaScript-->
    <script src='<c:url value="/resources/js/material.min.js" />'></script>
    <!-- Material Select Field Script -->
    <script src='<c:url value="/resources/js/mdl-selectfield.min.js" />'></script>
    <!-- Flexslider Plugin JavaScript-->
    <script src='<c:url value="/resources/js/jquery.flexslider.min.js" />'></script>
    <!-- Owl Carousel Plugin JavaScript-->
    <script src='<c:url value="/resources/js/owl.carousel.min.js" />'></script>
    <!-- Scrolltofixed Plugin JavaScript-->
    <script src='<c:url value="/resources/js/jquery-scrolltofixed.min.js" />'></script>
    <!-- Magnific Popup Plugin JavaScript-->
    <script src='<c:url value="/resources/js/jquery.magnific-popup.min.js" />'></script>
    <!-- WayPoint Plugin JavaScript-->
    <script src='<c:url value="/resources/js/jquery.waypoints.min.js" />'></script>
    <!-- CounterUp Plugin JavaScript-->
    <script src='<c:url value="/resources/js/jquery.counterup.js" />'></script>
    <!-- SmoothScroll Plugin JavaScript-->
    <script src='<c:url value="/resources/js/smoothscroll.min.js" />'></script>
    <!--Custom JavaScript for Klinik Template-->
    <script src='<c:url value="/resources/js/custom.js" />'></script>
    
     <script>
    	function validate() {
    		let check = true;
			if( document.getElementById("name").value == "" ) {
	            document.getElementById("name-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("name-invalid").style.display = "none";
	         }
			if( document.getElementById("intro").value == "" ) {
	            document.getElementById("intro-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("intro-invalid").style.display = "none";
	         }
			if( document.getElementById("information").value == "" ) {
	            document.getElementById("information-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("information-invalid").style.display = "none";
	         }
			
			return check;
    	}
    </script>

</html>