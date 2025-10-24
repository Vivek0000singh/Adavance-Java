<%@page import="java.time.LocalDate"%>
<%@page import="com.pojo.User"%>
<%@page import="java.time.Period"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h5>Hello, ${user_dtls.name }</h5>
	<%
	User user=(User)session.getAttribute("user_dtls");
	
	int ageInyrs=Period.between(user.getDob(), LocalDate.now()).getYears();
	%>
	<h5>Age- <%=ageInyrs %></h5>
	
	<%
	session.invalidate();
	%>
	<h5>You logged out......</h5>
	
	<h5>
	<a href="login.jsp">Visit Again</a></h5>

</body>
</html>