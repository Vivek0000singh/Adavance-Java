<%@page import="java.time.LocalDate" %>
<%@page import="com.pojo.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//jsp declaration block

	HashMap<String, User> users;

	public void jspInit() {
		users = new HashMap<>();
		//populate map

		users.put("rama@gmail.com",
				new User("Ramma Patil", "rama@gmail.com", "rama@123", LocalDate.parse("1990-10-02")));
		users.put("vivek@gmail.com",
				new User("vivek singh", "vivek@gmail.com", "vivek@123", LocalDate.parse("2002-10-12")));
		
		System.out.print("map Populted");

	}%>
<body>


	<%
	System.out.println("validations login -scriptlet");
	
	//validate email

	User user = users.get(request.getParameter("em"));
	
	if(user!=null){
		
		if(user.getPassword().equals(request.getParameter("pass"))){
			
			session.setAttribute("user_dtls", user);
			System.out.print(user);
			response.sendRedirect("details.jsp");
			
		}else{
			//invalid password
			%>
			<h5>Invalid password,please <a href="login.jsp">Retry</a></h5>
			<% 
		}
	}else{
		//invalid email
		%>
		
		<h5>Invalid email,please <a href="login.jsp">Retry</a></h5>
		
		<% 
	}
	%>

</body>
</html>