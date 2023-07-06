<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Site Title -->
    <title>Medical Support</title>
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
    <!-- Start Header -->
    <header id="header">
        <!-- Start Header Top Section -->
        <div id="hdr-top-wrapper">
            <div class="layer-stretch hdr-top">
                <div class="hdr-top-block hidden-xs">
                    <div id="hdr-social">
                        <ul class="social-list social-list-sm">
                            <li><a class="width-auto font-13">Theo dõi chúng tôi : </a></li>
                            <li><a href="https://www.facebook.com/" target="_blank" id="hdr-facebook" ><i class="fa fa-facebook" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-facebook">Facebook</span></li>
                            <li><a href="https://www.google.com.vn/?hl=vi" target="_blank" id="hdr-google" ><i class="fa fa-google" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-google">Google</span></li>
                            <li><a href="https://www.youtube.com/" target="_blank" id="hdr-youtube" ><i class="fa fa-youtube" ></i></a><span class="mdl-tooltip mdl-tooltip--bottom" data-mdl-for="hdr-youtube">Youtube</span></li>
                        </ul>
                    </div>
                </div>
                <div class="hdr-top-line hidden-xs"></div>
                <div class="hdr-top-block hdr-number">
                    <div class="font-13">
                        <i class="fa fa-mobile font-20 tbl-cell"> </i> <span class="hidden-xs tbl-cell"> Số điện thoại : </span> <span class="tbl-cell">0123.456.115</span>
                    </div>
                </div>
                <div class="hdr-top-line"></div>
                <div class="hdr-top-block">
                    <div class="theme-dropdown">
                        <c:set var="isLoggedIn" value="false" />
								<c:set var="email" value="" />
								<c:if test="${not empty cookie.userIsLoggedIn}">
									<c:set var="isLoggedIn" value="${cookie.userIsLoggedIn.value}" />
								</c:if>
								<c:if test="${not empty cookie.userEmail}">
									<c:set var="email" value="${cookie.userEmail.value}" />
								</c:if>
								<c:choose>
									<c:when test="${isLoggedIn}">
											<a id="profile-menu" class="mdl-button mdl-js-button mdl-js-ripple-effect font-13"><i class="fa fa-user-o color-black"></i> ${email}</a>
											<ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect metarial-menu" data-mdl-for="profile-menu">
                            					<li class="mdl-menu__item"><a href="<%=request.getContextPath()%>/showProfile?email=${email}"><i class="fa fa-info"></i>Thông tin tài khoản</a></li>
                            					<li class="mdl-menu__item"><a href="<%=request.getContextPath()%>/showMyAppointment?email=${email}"><i class="fa fa-calendar"></i>Lịch đã hẹn</a></li>
                            					<li class="mdl-menu__item"><a href="<%=request.getContextPath()%>/logout"><i class="fa fa-user-o"></i>Đăng xuất</a></li>
                        					</ul>
									</c:when>
									<c:otherwise>
											<a id="profile-menu" class="mdl-button mdl-js-button mdl-js-ripple-effect font-13"><i class="fa fa-user-o color-black"></i> My Account</a>
                        					<ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect metarial-menu" data-mdl-for="profile-menu">
                            					<li class="mdl-menu__item"><a href="<%=request.getContextPath()%>/login"><i class="fa fa-sign-in"></i>Đăng nhập</a></li>
                            					<li class="mdl-menu__item"><a href="<%=request.getContextPath()%>/getToRegister"><i class="fa fa-user-o"></i>Đăng ký</a></li>
                        					</ul>
									</c:otherwise>
								</c:choose>
                    </div>
                </div>
            </div>
        </div><!-- End Header Top Section -->
        <!-- Start Main Header Section -->
        <div id="hdr-wrapper">
            <div class="layer-stretch hdr">
                <div class="tbl">
                    <div class="tbl-row">
                        <!-- Start Header Logo Section -->
                        <div class="tbl-cell hdr-logo">
                            <a href="index.html"><img src="<c:url value="/resources/images/eevee.png" />" alt=""></a>
                        </div><!-- End Header Logo Section -->
                        <div class="tbl-cell hdr-menu">
                            <!-- Start Menu Section -->
                            <ul class="menu">
                             	<li><a href="<%=request.getContextPath()%>/" id="menu-shortcodes" class="mdl-button mdl-js-button mdl-js-ripple-effect">Trang chủ</a></li>
                                <li>
                                    <a id="menu-blog" class="mdl-button mdl-js-button mdl-js-ripple-effect">Thông tin<i class="fa fa-chevron-down"></i>
                                    </a>
                                    <ul class="menu-dropdown">
                                        <li><a href="<%=request.getContextPath()%>/getToAbout">Về chúng tôi</a></li>
                                        <li><a href="<%=request.getContextPath()%>/getToContact">Liên hệ</a></li>
                                        <li><a href="<%=request.getContextPath()%>/getToPolicy">Điều kiện và điều khoản khi đặt lịch </a></li>
                                        <li><a href="<%=request.getContextPath()%>/getToContidion">Điều kiện và điều khoản khi đăng ký</a></li>
                                    </ul>
                                </li>
                                <li><a href="<%=request.getContextPath()%>/showAllDepartment" id="menu-shortcodes" class="mdl-button mdl-js-button mdl-js-ripple-effect">Khoa</a></li>
								<li><a href="<%=request.getContextPath()%>/showAllService" id="menu-shortcodes" class="mdl-button mdl-js-button mdl-js-ripple-effect">Dịch vụ</a></li>
                                <li><a href="<%=request.getContextPath()%>/showAllDoctor" id="menu-shortcodes" class="mdl-button mdl-js-button mdl-js-ripple-effect">Danh sách bác sĩ</a></li>
                                <li><a href="<%=request.getContextPath()%>/showAllBlogs" id="menu-blog" class="mdl-button mdl-js-button mdl-js-ripple-effect">Tin tức</a></li>
								<li><a id="menu-shortcodes" class="mdl-button mdl-js-button mdl-js-ripple-effect">Lịch hẹn khám bệnh<i class="fa fa-chevron-down"></i> </a>
								<ul class="menu-dropdown">
                                        <li><a href="<%=request.getContextPath()%>/showDepartmentForAppointment">Đặt lịch khám</a></li>
                                        <li><a href="<%=request.getContextPath()%>/showMoreInfo">Tra cứu thông tin lịch hẹn</a></li>
                                    </ul></li>
                                <li><a href="<%=request.getContextPath()%>/getToChat" id="menu-shortcodes" class="mdl-button mdl-js-button mdl-js-ripple-effect">Tư vấn miễn phí</a></li>
                                <li>
                                </li>
                                <li class="mobile-menu-close"><i class="fa fa-times"></i></li>
                            </ul><!-- End Menu Section -->
                            <div id="menu-bar"><a><i class="fa fa-bars"></i></a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- End Main Header Section -->
    </header><!-- End Header -->
    <!-- Start Page Title Section -->
    <div class="page-ttl">
        <div class="layer-stretch">
            <div class="page-ttl-container">
                <h1>Điều khoản &#38; Điều kiện khi đăng ký</h1>
                <p><a href="<%=request.getContextPath()%>/">Trang chủ</a> &#8594; <span>Điều khoản &#38; Điều kiện khi đăng ký</span></p>
            </div>
        </div>
    </div><!-- End Page Title Section -->
    <!-- Start Terms and Condition Section -->
    <div class="layer-stretch">
        <div class="layer-wrapper">
            <div class="layer-fixed">
                <p class="paragraph-medium paragraph-black text-justify">
                    Thông tin tài khoản:
                </p>
                <ul class="theme-list-basic text-justified text-justify">
                    <li>Khách hàng phải cung cấp thông tin cá nhân cần thiết một cách đầy đủ và chính xác càng sớm càng tốt khi đăng ký tài khoản thành viên.</li>
                    <li>Thông tin cá nhân bao gồm tên, ngày sinh, địa chỉ, số điện thoại, và địa chỉ email.</li>
                </ul>
				 <p class="paragraph-medium paragraph-black text-justify">
                    Quyền và trách nhiệm của thành viên:
                </p>
                <ul class="theme-list-basic text-justified text-justify">
                    <li>Thành viên có quyền truy cập và sử dụng các dịch vụ và tiện ích mà bệnh viện cung cấp cho thành viên.</li>
                    <li>Thành viên phải tuân thủ các quy định, quyền lợi và trách nhiệm được quy định bởi bệnh viện.</li>
                </ul>
                 <p class="paragraph-medium paragraph-black text-justify">
                    Bảo mật thông tin:
                </p>
                <ul class="theme-list-basic text-justified text-justify">
                    <li>Bệnh viện cam kết bảo vệ thông tin cá nhân của thành viên theo quy định pháp luật và chính sách bảo mật của bệnh viện.</li>
                    <li>Thông tin cá nhân chỉ được sử dụng cho mục đích nội bộ của bệnh viện và không được tiết lộ cho bên thứ ba mà không có sự đồng ý của thành viên.</li>
                </ul>
                 <p class="paragraph-medium paragraph-black text-justify">
                    Quyền hạn và giới hạn:
                </p>
                <ul class="theme-list-basic text-justify">
                    <li>Bệnh viện có quyền hủy bỏ tài khoản thành viên nếu thành viên vi phạm các điều khoản và điều kiện đã được quy định.</li>
                    <li>Bệnh viện có quyền thay đổi hoặc chấm dứt dịch vụ thành viên mà không cần thông báo trước.</li>
                </ul>
                 <p class="paragraph-medium paragraph-black text-justify">
                    Quyền lợi và ưu đãi:
                </p>
                <ul class="theme-list-basic text-justified text-justify">
                    <li>Thành viên có thể được hưởng các quyền lợi và ưu đãi đặc biệt do bệnh viện cung cấp cho thành viên.</li>
                    <li>Các quyền lợi và ưu đãi có thể bao gồm giảm giá dịch vụ, ưu tiên đặt lịch khám, hoặc các chương trình chăm sóc sức khỏe đặc biệt.</li>
                </ul>
                <div class="theme-quote">
                    <i class="fa fa-quote-left"></i> Tôi sẽ kê toa vì lợi ích của bệnh nhân, tùy theo khả năng và thẩm định của tôi và không bao giờ làm hại ai. - Hippocrates - 
                </div>
                <div class="theme-quote theme-quote-colored text-justify">
                    <i class="fa fa-quote-left"></i> Ở đây không chỉ có dịch vụ, ở đây còn có sự chăm sóc tận tình bằng cả thể xác, con tim và linh hồn <br>
                    Sự hài lòng của quý khách hàng là niềm hạnh phúc của chúng tôi
                </div>  
            </div>
        </div>
    </div><!-- End Terms and Condition Section -->
    <!-- Start Emergency Section -->
    <div id="emergency">
        <div class="layer-stretch">
            <div class="layer-wrapper">
                <div class="layer-ttl">
                    <h3>Khẩn cấp</h3>
                </div>
                <div class="layer-container">
                    <div class="paragraph-medium paragraph-black">
                        Trong trường hợp khẩn cấp hoặc cần hỗ trợ <br/>
                        Làm ơn gọi số điện thoại này:
                    </div>
                    <div class="emergency-number">0123.456.115</div>
                </div>
            </div>
        </div>
    </div><!-- End Emergency Section -->
    <!-- Start Make an Appointment Modal -->
    <div id="appointment" class="modal fade" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
               <form action="<%=request.getContextPath()%>/setAppointment" class="form-horizontal" enctype="multipart/form-data" method = "post" onsubmit = "return(validate());">
        <div class="container">
            <div class="schedule-container">
                <div class="schedule-form">
                <div class="p-2 text-center">
                    <h1 style=" text-align: center;text-transform: uppercase;">Đặt lịch khám</h1>
                     <div class="paragraph-medium paragraph-black">Quý khách vui lòng điền đầy đủ thông tin. Chúng tôi sẽ liên hệ lại sớm nhất</div>
                      <div class="login-condition">Khi nhấp vào nút "Đặt lịch khám", bạn đã đồng ý với<br /><a href="<%=request.getContextPath()%>/getToPolicy">điều khoản &#38; điều kiện khi đặt lịch</a></div>
                        <div class="schedule-row row">
                         <div class="col-md-6">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-user-o"></i>
                                <input class="mdl-textfield__input" type="text" pattern="[\\p{L}\\p{M}\\s]*" id="name" name = "name">
                                <label class="mdl-textfield__label" for="appointment-name">Tên *</label> 
                                <span class="mdl-textfield__error">Làm ơn nhập tên hợp lệ!</span>
                                <span id="name-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Vui lòng nhập tên của bạn</span>
                            </div>
                        </div>
                           <div class="col-md-6">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-phone"></i>
                                <input class="mdl-textfield__input" type="text" pattern="[0-9]{10,11}" id="phone" name = "phone">
                                <label class="mdl-textfield__label" for="appointment-mobile">Số điện thoại *</label>
                                <span class="mdl-textfield__error">Làm ơn nhập số điện thoại hợp lệ!</span>
                                <span id="phone-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Vui lòng nhập số điện thoại</span>
                            </div>
                        </div>
                            <div class="col-md-6">
							    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
							        <i class="fa fa-calendar-o"></i>
							        <input class="mdl-textfield__input" type="datetime-local" id="date" name = "date" min="" max="" value="">
							        <span class="mdl-textfield__error">Làm ơn nhập ngày và giờ từ 8h SA đến 4 CH</span>
							        <span id="date-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Vui lòng chọn ngày giờ</span>
							    </div>
							</div>
                            <div class="col-md-6">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
                                <i class="fa fa-envelope-o"></i>
                                <input class="mdl-textfield__input" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" id="email" name = "email">
                                <label class="mdl-textfield__label" for="appointment-email">Email</label>
                                <span class="mdl-textfield__error">Làm ơn nhập email hợp lệ!</span>
                                <span id="email-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Vui lòng nhập email</span>
                            </div>
                        </div>
                            <div class="col-md-6">
                                <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon">
                                    <i class="fa fa-angle-double-down"></i>
                                    <select class="mdl-selectfield__select" id="gender" name = "gender">
                                    	<option value = "" disabled selected>--Chọn giới tính--</option>
                                        <option value="Nam">Nam</option>
                                        <option value="Nữ">Nữ</option>
                                        <option value="Khác">Khác</option>
                                    </select>
                                    <span id="gender-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Vui lòng chọn giới tính</span>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="mdl-selectfield mdl-js-selectfield mdl-selectfield--floating-label form-input-icon">
                                    <i class="fa fa-hospital-o"></i>
                                    <select class="mdl-selectfield__select" id="department" name = "idDepartment">
                                        <option value = "" disabled selected>--Chọn khoa--</option>
                                        <c:forEach items="${department}" var="item">
                                        <option value="<c:out value="${item.idDepartment}"/>">${item.departmentName }</option>
                                        </c:forEach>
                                    </select>
                                    <span id="department-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Vui lòng chọn khoa</span>
                                </div>
                            </div>
                            <div class="col-md-12">
							        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label form-input-icon">
							            <i class="fa fa-paper-plane"></i>
							            <textarea class="mdl-textfield__input" rows="5" id="note" name = "note"></textarea>
							            <label class="mdl-textfield__label" for="sample-message-1">Mô tả triệu chứng sơ bộ *</label>
							            <span class="mdl-textfield__error">Làm ơn miêu tả triệu chứng sơ bộ của bạn để chúng tôi có thể sắp xếp tốt hơn ( Nếu như dùng dịch vụ không phải khám bệnh có thể ghi "Không có")</span>
							            <span id="note-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường này không được để trống.</span>
							        </div>
							    </div>
                            </div>

                            <div class="schedule-col col-xl-12">
                                <div style = "padding-top: 30px; "class="form-submit">
                    				<button class="mdl-button mdl-js-button mdl-js-ripple-effect button button-primary">Đặt lịch khám</button>
                				</div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
    </form>
                <div class="modal-body">
                    <div class="appointment-error"></div>
                </div>
            </div>
        </div>
    </div><!-- End Make an Appointment Modal -->
    <!-- Fixed Appointment Button at Bottom -->
    <div id="appointment-button" class="animated fadeInUp">
        <button id="appointment-now" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--colored mdl-button--raised"><i class="fa fa-plus"></i></button>
        <div class="mdl-tooltip mdl-tooltip--top" data-mdl-for="appointment-now">Make An Appointment</div>
    </div><!-- End Fixed Appointment Button at Bottom -->
    <!-- Start Footer Section -->
    <footer id="footer">
        <div class="layer-stretch">
            <!-- Start main Footer Section -->
            <div class="row layer-wrapper">
                <div class="col-md-4 footer-block">
                    <div class="footer-ttl"><p>Thông tin cơ bản</p></div>
                    <div class="footer-container footer-a">
                        <div class="tbl">
                            <div class="tbl-row">
                                <div class="tbl-cell"><i class="fa fa-map-marker"></i></div>
                                <div class="tbl-cell">
                                    <p class="paragraph-medium paragraph-white">
                                        Việt Nam, Đà Nẵng<br />
                                        quận Liên Chiểu<br/> 
                                        phường Hòa Khánh Nam<br />
                                        đường Ngô Thì Nhậm
                                    </p>
                                </div>
                            </div>
                            <div class="tbl-row">
                                <div class="tbl-cell"><i class="fa fa-phone"></i></div>
                                <div class="tbl-cell">
                                    <p class="paragraph-medium paragraph-white">0123.456.789</p>
                                </div>
                            </div>
                            <div class="tbl-row">
                                <div class="tbl-cell"><i class="fa fa-envelope"></i></div>
                                <div class="tbl-cell">
                                    <p class="paragraph-medium paragraph-white">Rainie@Medical.com</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 footer-block">
                    <div class="footer-ttl"><p>Truy cập nhanh</p></div>
                    <div class="footer-container footer-b">
                        <div class="tbl">
                            <div class="tbl-row">
                                <ul class="tbl-cell">
                                    <li><a href="event-1.html">Về chúng tôi</a></li>
                                    <li><a href="contact.html">Liên lạc</a></li>
                                    <li><a href="gallery.html">Trang chủ</a></li>
                                    <li><a href="terms-conditions.html">Điều kiện và điều khoản</a></li>
                                </ul>
                                <ul class="tbl-cell">
                                    <li><a href="login.html">Đăng nhập</a></li>
                                    <li><a href="register.html">Đăng ký</a></li>
                                    <li><a href="myappointment.jsp">Đặt lịch hẹn</a></li>
                                    <li><a href="myprofile.html">Tài khoản</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 footer-block">
                    <div class="footer-ttl"><p>Theo dõi chúng tôi tại</p></div>
                    <div class="footer-container footer-c">
                        <ul class="social-list social-list-colored footer-social">
                            <li>
                                <label style = 'color: white'>Facebook:</label>
                                <a href="https://www.facebook.com/" target="_blank" id="footer-facebook" class="fa fa-facebook"></a>
                                <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-facebook">Facebook</span>
                            </li>
                            <li>
                            	<label style = 'color: white'>Youtube:</label>
                                <a href="https://www.youtube.com/" target="_blank" id="footer-youtube" class="fa fa-youtube"></a>
                                <span class="mdl-tooltip mdl-tooltip--top" data-mdl-for="footer-youtube">Youtube</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!-- End main Footer Section -->
        <!-- Start Copyright Section -->
        <div id="copyright">
            <div class="layer-stretch">
                <div class="paragraph-medium paragraph-white">2023 - ALL RIGHTS RESERVED.</div>
            </div>
        </div><!-- End of Copyright Section -->
    </footer><!-- End of Footer Section -->

    <!-- **********Included Scripts*********** -->

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
 // Lấy ngày hiện tại và giờ hiện tại
    var today = new Date();
    var currentHour = today.getHours();
    var currentMinute = today.getMinutes();

    // Lấy ngày tối thiểu
    var minDate;

    if ((currentHour >= 0 && currentHour < 12) || (currentHour === 12 && currentMinute === 0)) {
        // Nếu giờ hiện tại từ 12:00 SA đến 11:59 SA, ngày tối thiểu là hôm nay
        var currentDay = today.getDate();
        var currentMonth = today.getMonth() + 1; // Tháng tính từ 0 đến 11
        var currentYear = today.getFullYear();
        minDate = currentYear + "-" + formatNumber(currentMonth) + "-" + formatNumber(currentDay);
    } else if (currentHour >= 12) {
        // Nếu giờ hiện tại từ 12:00 CH trở đi, ngày tối thiểu là hôm nay
        var currentDay = today.getDate();
        var currentMonth = today.getMonth() + 1; // Tháng tính từ 0 đến 11
        var currentYear = today.getFullYear();
        minDate = currentYear + "-" + formatNumber(currentMonth) + "-" + formatNumber(currentDay);
    }

    // Cập nhật giá trị tối thiểu (min) của trường ngày
    document.getElementById("appointment-date").setAttribute("min", minDate + "T08:00");

    // Hàm để định dạng số thành chuỗi có 2 chữ số (vd: 01, 02, ..., 09)
    function formatNumber(number) {
        return number < 10 ? "0" + number : number;
    }

    </script>
    <script>
    	function validate() {
    		let check = true;
			if( document.getElementById("name").value == "" ) {
	            document.getElementById("name-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("name-invalid").style.display = "none";
	         }
			
			if( document.getElementById("phone").value == "" ) {
	            document.getElementById("phone-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("phone-invalid").style.display = "none";
	         }
			if( document.getElementById("email").value == "" ) {
	            document.getElementById("email-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("email-invalid").style.display = "none";
	         }
			if( document.getElementById("date").value == "" ) {
	            document.getElementById("date-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("date-invalid").style.display = "none";
	         }
			if( document.getElementById("gender").value == "" ) {
	            document.getElementById("gender-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("gender-invalid").style.display = "none";
	         }
			if( document.getElementById("department").value == "" ) {
	            document.getElementById("department-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("department-invalid").style.display = "none";
	         }
			if( document.getElementById("note").value == "" ) {
	            document.getElementById("note-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("note-invalid").style.display = "none";
	         }
			
			return check;
    	}
    </script>
</body>
</html>