<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--import JSTL supplied core tag library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>Hello , ${sessionScope.patient_details.name }</h4>

	<h3>Upcoming Appointments</h3>

	<table style="background-color: lightgrey; margin: auto">
		<tr>
			<th>Appointment_id</th>
			<th>Date Time</th>
			<th>Doctors Name</th>
			<th>Action</th>
		</tr>

		<c:forEach var="app" items="${requestScope.appointment_list}">
			<tr>
				<td>${app.appointmentId}</td>
				<td>${app.appointmentTS}</td>
				<td>${app.docName}</td>
				<td> <a href="appointments?action=cancel&id=${app.appointmentId }"><button>Cancel</button></a></td>

			</tr>
		</c:forEach>


	</table>

	<h5>
		<a href="appointments?action=show_form">Book new Appointment </a>
	</h5>
	<h5>
		<a href="logout">Log Out</a>
	</h5>

</body>
</html>