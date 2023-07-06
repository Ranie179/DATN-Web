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
    <form action = "<%=request.getContextPath()%>/addContract" onsubmit = "return(validate());">
    <div id="profile-page" class="layer-stretch">
        <div class="layer-wrapper">
            <div class="theme-material-card text-center">
            <p style = "text-align: center;"class="font-16">Thêm một hợp đồng cho bác sĩ mới</p>
                <div class="row">
                    <div class="col-md-5">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-user-o"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-name" name = "name">
                            <label class="mdl-textfield__label" for="profile-name">Tên bác sĩ</label>
                        </div>
                        </div>
                        <div class = "col-md-4">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-users"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-nationality" name = "nationality">
                            <label class="mdl-textfield__label" for="profile-nationality">Dân tộc</label>
                        </div>
                        </div>
                        <div class = >
                        </div>
                        <div class="col-md-3">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-phone"></i>
                            <input class="mdl-textfield__input" type="text" pattern="[0-9]*" id="profile-mobile" name = "phone">
                            <label class="mdl-textfield__label" for="profile-mobile">Số điện thoại</label>
                        </div>
                        </div>
                        <div class = "col-md-9">
                         <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-map-marker"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-iplace" name ="iplace">
                            <label class="mdl-textfield__label" for="profile-iplace">Nơi cấp CMND</label>
                        </div>
                    </div>
                    <div class="col-md-3">
                         <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-address-card"></i>
                            <input class="mdl-textfield__input" type="text" pattern="[0-9]+" id="identity" name = "identity">
                            <label class="mdl-textfield__label" for="identity">CMND/CCCD</label>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon text-left">
					        <i class="fa fa-venus-mars"></i>
					        <label  for="profile-gender">Giới tính</label>
					        <select class="mdl-selectfield__select text-center" id="profile-gender" name = "gender">
					            <option value="Nam" >Nam</option>
					            <option value="Nữ" >Nữ</option>
					        </select>
					    </div>
                    </div>
                    <div class = "col-md-3">
                         <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon text-left">
				        <i class="fa fa-building-o"></i>
				        <label  for="graduate">Trình độ học vấn</label>
				        <select class="mdl-selectfield__select text-center" id="graduate" name = "idGraduate">
				        <c:forEach items="${graduate}" var="item">
				            <option value="${item.idGraduate }">${item.graduate }</option>
				            </c:forEach>
				        </select>
				    </div>
                    </div>
                        <div class="col-sm-3">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon text-left">
                            <i class="fa fa-calendar"></i>
                            <label  for="profile-birthdate">Ngày sinh</label>
                            <input class="mdl-textfield__input" type="date" id="profile-birthdate" name = "birthday">
                        </div>
						</div>
						<div class="col-md-3">
                         <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon text-left">
                            <i class="fa fa-calendar-o"></i>
                            <label for="profile-idate">Ngày cấp CMND/CCCD</label>
                            <input class="mdl-textfield__input" type="date" id="profile-idate" name = "idate">
                        </div>
						</div>
						<div class="col-md-12">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-location-arrow"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-iplace" name = "address1">
                            <label class="mdl-textfield__label" for="profile-mobile">Địa chỉ thường trú (Ghi rõ tên đường/tổ)</label>
                        </div>
                        </div>
                        <div class="col-md-12">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-location-arrow"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-iplace" name = "address2">
                            <label class="mdl-textfield__label" for="profile-mobile">Địa chỉ liên lạc (Ghi rõ tên đường/tổ)</label>
                        </div>
                        </div>
						<div class="col-md-6">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon text-left">
                            <i class="fa fa-calendar-o"></i>
                            <label for="create-date">Ngày bắt đầu hợp đồng</label>
                            <input class="mdl-textfield__input" type="date" id="create-date" name = "createdate">
                        </div>
						</div>
						<div class="col-md-6">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon text-left">
                            <i class="fa fa-calendar"></i>
                            <label  for="end-date">Ngày kết thúc hợp đồng</label>
                            <input class="mdl-textfield__input" type="date" id="end-date" name = "enddate">
                        </div>
                        </div>
                        <div class= "col-md-4">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-money"></i>
                            <input class="mdl-textfield__input" type="text" pattern = "[0-9]*" id="profile-iplace" name = "salary">
                            <label class="mdl-textfield__label" for="profile-mobile">Lương</label>
                        </div>
                        </div>
                         <div class = "col-md-4">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-credit-card"></i>
                            <input class="mdl-textfield__input" type="text" pattern="[0-9]*" id="bank-number" name = "banknumber">
                            <label class="mdl-textfield__label" for="bank-number">Số tài khoản</label>
                        </div>
                        </div>
                        <div class = "col-md-4">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-university"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-iplace" name = "bank">
                            <label class="mdl-textfield__label" for="profile-mobile">Ngân hàng</label>
                        </div>
                        </div>
                        <div class = "col-md-4">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-clock-o"></i>
                            <input class="mdl-textfield__input" type="text" id="work-time" name = "worktime">
                            <label class="mdl-textfield__label" for="work-time">Giờ làm việc (trên 1 ngày)</label>
                        </div>
                        <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon text-left">
				        <i class="fa fa-building-o"></i>
				        <label  for="status">Khoa</label>
				        <select class="mdl-selectfield__select text-center" id="status" name = "idDepartment">
				        <c:forEach items="${department}" var="item">
				            <option value="${item.idDepartment }">${item.departmentName }</option>
				            </c:forEach>
				        </select>
				    </div>
                    </div>
                    <div class = "col-md-4">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-clock-o"></i>
                            <input class="mdl-textfield__input" type="text" id="rest-time" name = "resttime">
                            <label class="mdl-textfield__label" for="rest-time">Thời gian nghỉ (trên 1 ngày)</label>
                        </div>
                         <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon text-left">
					        <i class="fa fa-user-md"></i>
					        <label for="position">Vị trí làm việc</label>
					        <select class="mdl-selectfield__select text-center" id="position" name = "idPosition">
					             <c:forEach items="${position}" var="item">
					            	<option value="${item.idPosition }">${item.positionName }</option>
					            </c:forEach>
					        </select>
				    </div>
                    </div>
                    <div class = "col-md-4">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-calendar-times-o"></i>
                            <input class="mdl-textfield__input" type="text" id="leave-time" name = "leavetime">
                            <label class="mdl-textfield__label" for="leave-time">Thời gian nghỉ phép (Trên 1 tháng)</label>
                        </div>
                         <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon text-left">
				        <i class="fa fa-user-md"></i>
				        <label for="payment">Hình thức trả lương</label>
				        <select class="mdl-selectfield__select text-center" id="payment" name = "idPayment">
				        <c:forEach items="${payment}" var="item">
				            <option value="${item.idPayment }">${item.payment }</option>
				            </c:forEach>
				        </select>
				    </div>
                    </div>     
            </div>
                <div class="form-submit text-center">
                    <button type = "submit" class="mdl-button mdl-js-button mdl-js-ripple-effect button button-primary">Lưu thay đổi</button>
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
			if( document.getElementById("profile-allergies").value == "" ) {
				console.log("profile-allergies");
	            document.getElementById("annouce-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("annouce-invalid").style.display = "none";
	         }
			
			return check;
    	}
    </script>
    <script>
	    var today = new Date().toISOString().split('T')[0];
	    document.getElementById("create-date").setAttribute("min", today);
	    document.getElementById("end-date").setAttribute("min", today);
	</script>

</html>