<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.crm.com/View Employee</title>
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" />
</head>
<body>
	<table width="900" border="0" align="center">
		<tr>
			<td colspan="2"><%@ include file="../jsps/header.jsp"%></td>
		</tr>
		<tr>
			<td width="150"><%@ include file="../jsps/main_menu.jsp"%>
			</td>
			<td width="750" valign="top" align="center">
				<p>&nbsp;</p> <u><b>View Employee</b></u> <br> <%
 	if (session.getAttribute("lErrorMsg") != null) {
 		out.println("<b>" + session.getAttribute("lErrorMsg") + "!!!</b>");

 	}
 %>


				<hr width=100% color=#1c4966>
				<table border="0" align="top" width=100%>


					<tr>

						<td><b>First Name</b></td>
						<td align='left'>:<c:out value="${employeeBo.firstName}"></c:out></td>
						<td><b>Last Name</b></td>
						<td align='left'>:<c:out value="${employeeBo.lastName}"></c:out>
						</td>

					</tr>
					<tr>
						<td><b>EmailId</b></td>
						<td align='left'>:<c:out value="${employeeBo.emailAddress}"></c:out></td>
						<td><b>MobileNumber</b></td>
						<td align='left'>:<c:out value="${employeeBo.mobileNumber}"></c:out>
						</td>
					</tr>
					<tr>
						<td><b>DOB</b></td>
						<td align='left'>:<c:out value="${employeeBo.dateofBirth}"></c:out>
						</td>
						<td><b>Address</b></td>
						<td align='left'>:<c:out value="${employeeBo.address}"></c:out>
						</td>
					</tr>
					<tr>
						<td><b>City</b></td>
						<td align='left'>:<c:out value="${employeeBo.city}"></c:out>
						</td>
						<td><b>Country</b></td>
						<td align='left'>:<c:out value="${employeeBo.country}"></c:out></td>
					</tr>
					<tr>
					</tr>
				</table>
				<h3 style="text-align: center;">
						<button style="background-color: #1c4966; color: white">
							<a href='listEmployee' style="text-decoration: none;background-color: #1c4966; color: white">Back
								To List</a>
						</button>



					</h3>

				<hr width=100% color=#1c4966>
			</td>
		</tr>
		<tr>
			<td colspan="2"><%@include file="../jsps/footer.jsp"%></td>
		</tr>
	</table>
</body>
</html>