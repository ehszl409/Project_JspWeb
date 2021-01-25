<%@page import="com.park.reservation.config.DB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연결 테스트 페이지 입니다.</title>
</head>
<body>
<%
DB.getConnection();
%>
</body>
</html>