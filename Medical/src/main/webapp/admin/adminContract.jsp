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
    <div id="profile-page" class="layer-stretch">
        <div style = "width: 794px; margin:auto; overflow-y:auto;" class="layer-wrapper">
            <div class="theme-material-card text-center">
            <p style = "text-align: center; margin-top: 30px;"class="font-16"><strong>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM</strong></p>
            <p style = "text-align: center;"class="font-16"><strong>Độc lập - Tự do - Hạnh phúc</strong></p>
            <p style = "text-align: right;"class="font-16">Đà Nẵng, ngày ${contract.cDay } tháng ${contract.cMonth } năm ${contract.cYear }</p>
            <p style = "text-align: center; font-size: 20px; margin-top: 50px"><strong>HỢP ĐỒNG HỢP TÁC</strong></p>
            <p style = "text-align: center;"class="font-16"><strong>(V/v: hợp tác với bác sĩ)</strong></p>
            <p style = "text-align: center;"class="font-16">Số: ${contract.idContract }</p>
            <div style = "margin-left:20px;" class = "col-md-12">
	            <ul>
		           	<li><p class="font-16 text-justify">Căn cứ Bộ luật Dân sự năm 2015;</p></li>
		            <li><p class="font-16 text-justify">Căn cứ Bộ luật Lao động năm 2012;</p></li>
		            <li><p class="font-16 text-justify">Căn cứ Luật Thương mại năm 2005;</p></li>
		            <li><p class="font-16 text-justify">Căn cứ Luật khám bệnh, chữa bệnh năm 2009;</p></li>
		            <li><p class="font-16 text-justify">Căn cứ Nghị định số 109/2016/NĐ-CP quy định về cấp chứng chỉ hành nghề đối với người hành nghề và cấp giấy phép hoạt động đối với cơ sở khám bệnh, chữa bệnh;<p></li>
		            <li><p class="font-16 text-justify">Căn cứ Thông tư số 41/2015/TT-BYT sửa đổi Thông tư 41/2011/TT-BYT quy định cấp chứng chỉ hành nghề đối với người hành nghề và cấp giấy phép hoạt động đối với cơ sở khám bệnh, chữa bệnh;<p></li>
		            <li><p class="font-16 text-justify">Căn cứ khả năng và nhu cầu các bên.</p></li>
	            </ul>
            </div>
            <div class = "col-md-12">
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>A/ BÊN SỬ DỤNG LAO ĐỘNG – BÊN A</strong></p>
	            <p style = "font-size: 16px;" class="font-16 text-justify"><strong>PHÒNG KHÁM: Phòng khám đa khoa MedicSupport</strong></p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Địa chỉ: đường Ngô Thì Nhậm, phường Hòa Khánh Nam, quận Liên Chiểu, thành phố Đà Nẵng</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Số điện thoại: 0123.456.115</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Đại diện: Ông/Bà Nguyễn Nhật Trường &nbsp &nbsp Chức vụ: Giám đốc</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Số điện thoại: 0987654321</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Email: Rainie@Gmail.com</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Số tài khoản: 1234567898765 &nbsp Ngân hàng: BIDV &nbsp Chi nhánh: Hải Vân, Đà Nẵng</p>
	            <p style = "font-size: 18px;" class="font-16 text-justify"><strong>B/ BÊN LAO ĐỘNG – BÊN B</strong></p>
	            <p style = "font-size: 16px;" class="font-16 text-justify"><strong>BÁC SĨ: ${contract.name } &nbsp Chuyên khoa: ${contract.department.departmentName }</strong></p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Sinh ngày: ${contract.birthDay }&nbsp Quốc tịch: ${contract.nationality } &nbsp Trình độ học vấn: ${contract.graduate.graduate }</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">CMND/CCCD số: ${contract.identityNumber } &nbsp Nơi cấp: ${contract.identityPlace } &nbsp Ngày cấp: ${contract.identityDay }</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Hộ khẩu thường trú: ${contract.address1 }</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Nơi ở hiện nay: ${contract.address2 }</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Số điện thoại: ${contract.phone }</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">Số tài khoản: ${contract.bankNumber } &nbsp Ngân hàng: ${contract.bank }</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify"><strong>Hai bên thống nhất thoả thuận và ký kết “Hợp đồng lao động về việc thuê bác sĩ” (sau đây gọi chung là “Hợp đồng”) bao gồm những điều khoản sau:</strong></p>
	            <p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 1. NỘI DUNG HỢP TÁC</strong></p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">- Bên B tham gia hợp tác với bên A trong việc khám, chữa bệnh cho các bệnh nhân tại bệnh viện MedicSupport với vị trí ${contract.position.positionName } thuộc chuyên khoa ${contract.department.departmentName } của bên B.</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">- Bên B tham gia hợp tác, hỗ trợ và làm việc với đội ngũ bác sĩ chuyên khoa của bên A trong các công việc liên quan đến chuyên môn của bên B.</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">- Các công việc do hai bên phối hợp sao cho phù hợp với khả năng, điều kiện và nguyện vọng của nhau.</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">- Thời gian hợp tác: Từ ngày ${contract.cDay } tháng ${contract.cMonth } năm ${contract.cYear } đến ngày ${contract.eDay } tháng ${contract.eMonth } năm ${contract.eYear }</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">- Gia hạn hợp tác: Hết thời hạn hai bên có thể thỏa thuận thêm thời hạn của hợp đồng hoặc thỏa thuận ký kết hợp đồng mới tùy vào ý chí các bên.</p>
	            <p style = "font-size: 16px;" class="font-16 text-justify">- Địa điểm làm việc: Phòng khám đa khoa MedicSupport đường Ngô Thì Nhâm, phường Hòa Khánh Nam, quận Liên Chiểu, thành phố Đà Nẵng.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 2. NỘI DUNG CÔNG VIỆC</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Bên B tiến hành tham gia hợp tác từ ngày ${contract.cDay } tháng ${contract.cMonth } năm ${contract.cYear }.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Bên A có đầy đủ giấy phép hoạt động theo quy định của pháp luật.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Bên B có chứng chỉ hành nghề phạm vi chuyên môn khám và bên A có trách nhiệm kiểm tra tính hợp lệ cảu chứng chỉ này.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Thời gian làm việc: ${contract.workTime } giờ/ngày</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Chế độ nghỉ ngơi: ${contract.restTime } giờ/ngày</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Chế độ nghỉ phép: ${contract.leaveTime } ngày/tháng</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Phương tiện di chuyển: Bên B tự túc</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên B thực hiện khám, tư vấn và điều trị các bệnh lý liên quan đến chuyên môn của mình.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên B được sử dụng các trang thiết bị có sẵn của phòng khám liên quan đến chuyên môn của mình trong quá trình làm việc.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên A cung cấp hồ sơ, thông tin của những ca bệnh liên quan đến phạm vi hoạt động chuyên môn cho bên B.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên A cung cấp thuốc theo phác đồ điều trị và chỉ định kê đơn thuốc của bên B.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên A cung cấp đầy đủ trang phục, thiết bị y tế, cơ sở vật chất tại phòng khám và đảm bảo điều kiện an toàn, vệ sinh lao động tại nơi làm việc theo đúng quy định của pháp luật hiện hành.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 3. TIỀN LƯƠNG VÀ THANH TOÁN</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên B sẽ được hưởng mức lương chính thức: ${contract.salary } VND</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Bên B được hưởng thêm 10% trên tổng số chi phí khám, chữa bệnh của mỗi ca khám bệnh mà bên B tham gia hợp tác với bên A.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên A sẽ thanh toán cho bên B theo kết quả làm việc và hợp tác của hai bên.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Hình thức thanh toán: ${contract.payment.payment }</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Thời gian thanh toán: Ngày 10 mỗi tháng.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Trong trường hợp thanh toán chậm, bên B được hưởng lãi suất 5% tính từ ngày quá hạn thanh toán đến ngày thực thanh toán.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 4. QUYỀN VÀ NGHĨA VỤ CÁC BÊN</strong></p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>4.1 Quyền và nghĩa vụ của bên A</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Được điều hành bác sĩ bên B tham gia các cuộc hội chuẩn khi cần thiết;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Được yêu cầu bên B thực hiện công tác khám, chữa bệnh theo chuyên môn của bên B tại phòng khám;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Có đầy đủ giấy phép hoạt động hợp pháp của cơ sở;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Kiểm soát nhiễm khuẩn trong cơ sở khám, chữa bệnh;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bảo đảm chất lượng trang thiết bị, cơ sở vật chất tại phòng khám để công tác khám, chữa bệnh được diễn ra thuận lợi và hiệu quả;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bảo đảm chất lượng và số lượng thuốc được kê theo phác đồ điều trị của bên B;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Thanh toán đầy đủ và đúng hạn các khoản tiền đã được hai bên thoả thuận.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>4.2 Quyền và nghĩa vụ của bên B</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bảo đảm thực hiện đúng và đầy đủ các công việc liên quan đến công tác khám, chữa bệnh thuộc chuyên môn của mình tại phòng khám;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Cung cấp hồ sơ bệnh án và các tài liệu liên quan đến việc khám, chữa bệnh cho bên A khi có yêu cầu;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Đảm bảo tính bảo mật các thông tin người bệnh trước khi được sự cho phép của bên A;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên B chịu trách nhiệm cung cấp chứng chỉ hành nghề hợp lệ khi có yêu cầu của bên A hoặc cơ quan chức năng có thẩm quyền kiểm tra;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Đảm bảo sức khoẻ hành nghề, an toàn khi hành nghề và cập nhật kiến thức y khoa liên tục;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Bên B chịu trách nhiệm thực hiện đúng quy định chuyên môn kỹ thuật và chịu trách nhiệm về việc khám bệnh, chữa bệnh của mình;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Không được kê đơn, chỉ định sử dụng các dịch vụ khám bệnh, chữa bệnh, gợi ý chuyển người bệnh tới cơ sở khám bệnh, chữa bệnh khác vì vụ lợi;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Được từ chối khám bệnh, chữa bệnh nếu trong quá trình khám bệnh, chữa bệnh mà tiên lượng bệnh vượt quá khả năng hoặc trái phạm vi hoạt động chuyên môn và phải thông báo ngay cho bên A để thoả thuận phương án giải quyết. Tuy nhiên, vẫn phải thực hiện việc sơ cứu, cấp cứu, theo dõi, chăm sóc, điều trị cho người bệnh cho đến khi đã thống nhất được với bên A;</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Được từ chối khám bệnh, chữa bệnh nếu việc khám bệnh, chữa bệnh đó trái với quy định của pháp luật hoặc đạo đức nghề nghiệp.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 5. BỒI THƯỜNG THIỆT HẠI</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Trường hợp bên B gây ra thiệt hại do sai sót trong quá trình khám, chữa bệnh của mình thì bên B phải chịu trách nhiệm bồi thường những thiệt hại mà hành vi này trực tiếp gây ra. Trường hợp bên B đã thực hiện đúng các yêu cầu kỹ thuật cần thiết mà vẫn xảy ra tai biến trong khám chữa bệnh thì bên B không phải chịu trách nhiệm bồi thường thiệt hại.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Trường hợp thiệt hại xảy ra do chất lượng thuốc không đạt yêu cầu hay cơ sở vật chất không đạt chuẩn chất lượng hoặc do lỗi bên A gây ra thì bên A phải chịu trách nhiệm bồi thường những thiệt hại xảy ra.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Trường hợp một trong các bên vi phạm một trong các nghĩa vụ được quy định trong hợp đồng thì phải chịu trách nhiệm bồi thường các thiệt hại do hành vi đó trực tiếp gây ra.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Trong vòng 15 ngày, các bên thực hiện thanh toán khoản tiền bồi thường thiệt hại, nếu như quá hạn thanh toán bồi thường mà bên vi phạm chưa thực hiện nghĩa vụ của mình thì bên còn lại được gửi đơn yêu cầu cơ quan có thẩm quyền giải quyết.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 6. BỒI THƯỜNG THIỆT HẠI</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">Trường hợp xảy ra tranh chấp, các bên ưu tiên giải quyết tranh chấp thông qua thương lượng, hoà giải. Trường hợp không thể thương lượng thì một trong các bên có quyền yêu cầu Toà án nhân dân có thẩm quyền giải quyết.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 7. CHẤM DỨT HỢP ĐỒNG</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Hợp đồng chấm dứt khi hợp đồng hết hiệu lực, các bên hoàn thành quyền và nghĩa vụ của mình.</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Hợp đồng có thể chấm dứt trước thời hạn khi có thoả thuận bằng văn bản của hai bên về việc chấm dứt này.</p>
            	<p style = "font-size: 18px;" class="font-16 text-justify"><strong>ĐIỀU 8. HIỆU LỰC HỢP ĐỒNG</strong></p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">– Hợp đồng có hiệu lực từ ngày ${contract.cDay } tháng ${contract.cMonth } năm ${contract.cYear } đến ngày ${contract.eDay } tháng ${contract.eMonth } năm ${contract.eYear }</p>
            	<p style = "font-size: 16px;" class="font-16 text-justify">- Hợp đồng được lập thành 2 bản, mỗi bên giữ 1 bản có giá trị pháp lý tương đương nhau.</p>
            </div>
            <div style = "margin-left: 10px; margin-right: 10px; "class ="row">
            <div style = "border: 2px solid; margin-bottom: 5px;" class = "col-md-6 text-center">
            	<p style = "font-size: 18px;"> <strong>Bên A</strong></p>
            	<p style = "font-size: 16px;">(ký và ghi rõ họ tên)</p>
            </div> 
            <div style = "border: 2px solid; margin-bottom: 5px;" class = "col-md-6 text-center">
            	<p style = "font-size: 18px;"> <strong>Bên B</strong></p>
            	<p style = "font-size: 16px;">(ký và ghi rõ họ tên)</p>
            </div> 
            <div class = "col-md-6">
                 <p style = "font-size: 16px; margin-top: 70px;"><strong>${contract.name }</strong></p>
            </div>
            <div class = "col-md-6">
                 <p style = "font-size: 16px; margin-top: 70px;"><strong>Nguyễn Nhật Trường</strong></p>
            </div>
            </div>        
            </div>  
        </div>
    </div><!-- End My Profile Section -->
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
    <script src='<c:url value="/resources/js/invoice.js" />'></script>

</html>