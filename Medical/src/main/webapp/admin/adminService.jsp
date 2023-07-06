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

    <section style = "height: auto;" class="home">
        		    <!-- Start Doctor List Section -->
    <!-- Start My Profile Section -->
    <form method="POST" action="<%=request.getContextPath()%>/adminEditService" enctype="multipart/form-data">
    <div id="profile-page" class="layer-stretch">
        <div class="layer-wrapper text-center">
            <div class="theme-material-card">
            <p style = "text-align: center;"class="font-16">Thông tin dịch vụ ${serviceInfo.name}</p>
            <div id="doctor-page" class="layer-stretch">
        	<div class="layer-wrapper layer-bottom-5">
                        <div class="theme-img theme-img-scalerotate"><img src="/Medical<c:out value="${serviceInfo.image1}" />" alt=""></div>
                        <p class = "text-center">Ảnh tiêu đề</p>
                        <div class = "row">
                        <div style = "margin-left: 15px;" class = "col-md-6">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-heart"></i>
                            <input style = "display:none;" id = "id" name = "id" value = " ${serviceInfo.id }">
                            <textarea class="mdl-textfield__input" rows="1" maxLength = "200" name = "name" id="profile-about">${serviceInfo.name}</textarea>
                            <label class="mdl-textfield__label" for="profile-about">Tên dịch vụ</label>               
                        </div>
                        </div>
                        <div style = "margin-left: 150px; margin-top:20px;" class = "col-md-4"><input type = "file" id = "img1" name = "img1">
                        </div>
                        </div>
                        
							<div class = "row">
                            <div class="col-md-8">
                   		<div style = "margin-left: 14px;" class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-sticky-note-o"></i>
                            <textarea class="mdl-textfield__input" rows="4" maxLength = "200" name = "intro" id="profile-about">${serviceInfo.intro }</textarea>
                            <label class="mdl-textfield__label" for="profile-about">Giới thiệu</label>
                        </div>
                        </div>
                        <div class="col-md-4">
				    <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon">
				        <i class="fa fa-building-o"></i>
				        <select class="mdl-selectfield__select" id="idDepartment" name = "idDepartment">
				        	<c:forEach items="${department}" var="item">
				            <option value="${item.idDepartment }" <c:out value = "${item.departmentName.equals(serviceInfo.department.departmentName)? 'selected' : ''}"/>>${item.departmentName}</option>
				            </c:forEach>
				        </select>
				    </div>
				    </div>
				    </div>
                            <div class="row">
                                <div style = "margin-left: 15px;" class="col-md-6">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
			                            <i class="fa fa-info"></i>
			                            <textarea class="mdl-textfield__input" rows="12" name = "description1" id="profile-about">${serviceInfo.description1 }</textarea>
			                            <label class="mdl-textfield__label" for="profile-about">Mô tả thứ nhất</label>
			                        </div>
                                </div>
                                <div style = "margin-left: 70px;" class="col-md-5">
                                    <div class="theme-img theme-img-scalerotate">
                                        <img src="/Medical<c:out value="${serviceInfo.image2}" />" alt="">
                                    </div>
                                    <p class = "text-center">Ảnh thứ nhất</p>
                                    <input style = "margin-left:150px;" type = "file" name = "img2">
                                </div>
                                 
                            </div>
                            <p></p>
                           <div class="col-md-12">
		                   	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
		                            <i class="fa fa-info"></i>
		                            <textarea class="mdl-textfield__input" rows="4" name = "description2" id="profile-about">${serviceInfo.description2 }</textarea>
		                            <label class="mdl-textfield__label" for="profile-about">Mô tả thứ 2</label>
		                        </div>
                        </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="theme-img theme-img-scalerotate">
                                        <img src="/Medical<c:out value="${serviceInfo.image3}" />" alt="">
                                    </div>
                                    <p class = "text-center">Ảnh thứ ba</p>
                                    <input style = "margin-left:400px;" type = "file" name = "img3">
                                </div>
                            </div>
                            <p></p>
                            <div class="col-md-12">
		                   	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
		                            <i class="fa fa-info"></i>
		                            <textarea class="mdl-textfield__input" rows="4" name = "description3" id="profile-about">${serviceInfo.description3 }</textarea>
		                            <label class="mdl-textfield__label" for="profile-about">Mô tả thứ 3</label>
		                        </div>
                        </div>
                                <div class="col-md-12">
				                   	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
				                            <i class="fa fa-dot-circle-o"></i>
				                            <textarea class="mdl-textfield__input" rows="2" name = "advantage" id="profile-about">${serviceInfo.advantage }</textarea>
				                            <label class="mdl-textfield__label" for="profile-about">Lợi ích của dịch vụ</label>
				                        </div>
		                        </div>
                            <p></p>
                                <div class="col-md-12">
			                   	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
			                            <i class="fa fa-flag"></i>
			                            <textarea class="mdl-textfield__input" rows="2" name = "endline" id="profile-about">${serviceInfo.endline }</textarea>
			                            <label class="mdl-textfield__label" for="profile-about">Lời kết thúc</label>
			                        </div>
                        	</div> 
             </div>
         </div>
                <div class="form-submit text-center">
                    <button type = "submit" class="mdl-button mdl-js-button mdl-js-ripple-effect button button-primary">Lưu thay đổi</button>
                </div>
            </div>  
        </div>
          
    </div><!-- End My Profile Section -->
</form>
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

</html>