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
    <form action = "<%=request.getContextPath()%>/adminUpdateAppointment" onsubmit = "return(validate());">
    <div id="profile-page" class="layer-stretch">
        <div class="layer-wrapper">
            <div class="theme-material-card text-center">
            <p style = "text-align: center;"class="font-16">Thông tin lịch hẹn</p>
                <div class="row">
                    <div class="col-md-6">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-user-o"></i>
                            <input style = "display:none;" name  = "id" value = "${appointment.id }">
                            <input class="mdl-textfield__input" type="text" id="profile-name" readonly value = "${appointment.name }">
                            <label class="mdl-textfield__label" for="profile-name">Tên khách hàng</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-envelope-o"></i>
                            <input class="mdl-textfield__input" type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" id="profile-email" readonly value = "${appointment.email }">
                            <label class="mdl-textfield__label" for="profile-email">Email</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-phone"></i>
                            <input class="mdl-textfield__input" type="text" pattern="[0-9]*" id="profile-mobile" readonly value = "${appointment.phone }">
                            <label class="mdl-textfield__label" for="profile-mobile">Số điện thoại</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-calendar"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-birthdate" readonly value = "${appointment.appointmentDate }">
                            <label class="mdl-textfield__label" for="profile-birthdate">Ngày giờ hẹn</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-venus-mars"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-address-1" readonly value = "${appointment.gender }">
                            <label class="mdl-textfield__label" for="profile-address-1">Giới tính</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-building-o"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-address-2" readonly value = "${appointment.department.departmentName }">
                            <label class="mdl-textfield__label" for="profile-address-2">Khoa</label>
                            <span class="mdl-textfield__error">Please Enter Valid Address!</span>
                        </div>
                    </div>
                    <div class="col-md-6">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-lock"></i>
                            <input class="mdl-textfield__input" type="text" id="profile-address-2" readonly value = "${appointment.token }">
                            <label class="mdl-textfield__label" for="profile-address-2">Token</label>
                        </div>
                </div>
               <div class="col-md-6">
				    <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon">
				        <i class="fa fa-check-square-o"></i>
				        <select class="mdl-selectfield__select" id="status" name = "status">
				            <option value="Đã lên lịch" ${appointment.appointmentStatus == 'Đã lên lịch' ? 'selected' : ''}>Đã lên lịch</option>
				            <option value="Đã hủy" ${appointment.appointmentStatus == 'Đã bị hủy' ? 'selected' : ''}>Đã bị hủy</option>
				            <option value="Đã xong" ${appointment.appointmentStatus == 'Đã xong' ? 'selected' : ''}>Đã xong</option>
				        </select>
				    </div>
				</div>
            </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-sticky-note-o"></i>
                            <textarea class="mdl-textfield__input" rows="5" id="profile-about" readonly >${appointment.note }</textarea>
                            <label class="mdl-textfield__label" for="profile-about">Ghi chú</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                            <i class="fa fa-bullhorn"></i>
                            <textarea class="mdl-textfield__input" rows="5" id="profile-allergies" name = "information"> ${appointment.information }</textarea>
                            <label class="mdl-textfield__label" for="profile-allergies">Thông báo</label>
                            <span id="annouce-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường này không được để trống.</span>
                        </div>
                    </div>
                </div>
                <div class="form-submit">
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

</html>