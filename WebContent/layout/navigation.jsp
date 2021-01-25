<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<title>장바구니</title>

<script src="https://code.jquery.com/jquery-3.5.1.slim.js"
	integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM="
	crossorigin="anonymous"></script>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/clean-blog.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/loginForm.css" rel="stylesheet">

<!-- 자동 스크롤 업 버튼 css -->
<!-- Vendor CSS Files -->
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">케이크를 예약해보자</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<c:choose>
				<c:when test="${sessionScope.principal != null}">
					<div class="collapse navbar-collapse" id="navbarResponsive">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="list.jsp">케이크목록</a></li>
							<li class="nav-item"><a class="nav-link" href="myPage.jsp">마이페이지
							</a></li>
							<li class="nav-item"><a class="nav-link" href="cart.jsp">장바구니</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/user?cmd=logout">로그아웃</a></li>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="collapse navbar-collapse" id="navbarResponsive">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/user?cmd=loginForm">로그인</a></li>
							<li class="nav-item"><a class="nav-link"
								href="<%=request.getContextPath()%>/user?cmd=joinForm">회원가입</a></li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>