<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <!-- Full Carlendar CSS -->
    <link href='<c:url value="/resources/css/fullcalendar.min.css" />' rel="stylesheet" type="text/css">
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
    <!-- Start Event Calendar Section -->
    <div class="layer-stretch">
        <div class="layer-wrapper">
            <div class="theme-material-card">
                <div id="calendar" class="font-13"></div>
            </div>
        </div>
    </div><!-- End Event Calendar Section -->

<!-- Start Modal for event -->
<form action = "<%=request.getContextPath()%>/adminShowAppointmentInfo">
<div id="event-popup" class="modal fade" role="dialog">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title font-20"></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                    <p class="paragraph-medium paragraph-black event-ttl">
                        <span class="theme-dropcap primary-color"></span>
                    </p>
                     <p class="paragraph-medium paragraph-black event-gender">
                    </p>
                    <p class="paragraph-medium paragraph-black event-phone">
                    </p>
                    <p class="paragraph-medium paragraph-black event-email">
                    </p>
                    <p class="paragraph-medium paragraph-black event-note">
                    </p>
                    <p class="paragraph-medium paragraph-black event-status">
                    </p>
                    <input style = "display: none;" class="paragraph-medium paragraph-black event-id" type="text" name = "id"></input>
                    <p class="font-16 color-orange event-date text-right ">
					    <fmt:formatDate value="" pattern="dd/MM/yyyy HH:mm" />
					</p>

            </div>
            <div class="modal-footer">
               	<button type="submit" class="mdl-button mdl-js-button mdl-js-ripple-effect button button-primary">Sửa</button>
                <button type="button" class="mdl-button mdl-js-button mdl-button--colored mdl-js-ripple-effect button button-danger m-1" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>
</form>
<!-- End Modal for event -->

    </section>
</body>
	<script src = '<c:url value="/resources/js/moment.min.js" />' ></script>
	<script src = '<c:url value="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/locale/vi.min.js" />' ></script>
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
    <!-- Full Calendar JavaScript -->
    <script src='<c:url value="/resources/js/fullcalendar.min.js" />'></script>
    <!-- WayPoint Plugin JavaScript-->
    <script src='<c:url value="/resources/js/jquery.waypoints.min.js" />'></script>
    <!-- CounterUp Plugin JavaScript-->
    <script src='<c:url value="/resources/js/jquery.counterup.js" />'></script>
    <!-- SmoothScroll Plugin JavaScript-->
    <script src='<c:url value="/resources/js/smoothscroll.min.js" />'></script>
    <!--Custom JavaScript for Klinik Template-->
    <script src='<c:url value="/resources/js/custom.js" />'></script>
     <script>
    var todayDate = moment().startOf('day'),
        YM = todayDate.format('YYYY-MM'),
        YESTERDAY = todayDate.clone().subtract(1, 'day').format('YYYY-MM-DD'),
        TODAY = todayDate.format('YYYY-MM-DD'),
        TOMORROW = todayDate.clone().add(1, 'day').format('YYYY-MM-DD'),
        colorOrange = '#EfA752',
        colorBlue = '#32C1CE',
        colorPurple = '#A675D4',
        colorGreen = '#54C798';

    // Đoạn mã JSP để tạo danh sách sự kiện từ danh sách appointment
  var events = [
    <c:forEach items="${appointmentlist}" var="item">
        {
            title: '${item.name}',
            start: '${item.appointmentDate}', 
            note: 'Mô tả: ${item.note}',
            phone: 'Số điện thoại: ${item.phone}',
            email: 'E-mail: ${item.email}',
            gender: 'Giới tính: ${item.gender}',
            department: '${item.department.departmentName}',
            status: 'Trạng thái: ${item.appointmentStatus}',
            id: '${item.id}',
            backgroundColor:
            	'${item.appointmentStatus}' == "Đã bị hủy" ? colorOrange :
                moment('${item.appointmentDate}').isSameOrBefore(YESTERDAY, 'day') ? colorPurple : 
                moment('${item.appointmentDate}').isSame(TODAY, 'day') ? colorGreen :
                colorBlue,
               	
        },
    </c:forEach>
];
    
    



    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay,listWeek'
        },
        editable: true,
        eventLimit: true,
        navLinks: true,
        events: events,
        eventClick: function(event, jsEvent, view) {
            if (event.url) {
                window.open(event.url);
                return false;
            }
            $('#event-popup .modal-title').text(event.department);
            $('#event-popup .event-ttl').text(event.title);
            $('#event-popup .event-note').text(event.note);
            $('#event-popup .event-gender').text(event.gender);
            $('#event-popup .event-email').text(event.email);
            $('#event-popup .event-phone').text(event.phone);
            $('#event-popup .event-status').text(event.status);
            $('#event-popup .event-date').text(event.start);
            $('#event-popup .event-id').val(event.id);
            $('#event-popup').modal('show');
        }

    });
</script>


</html>