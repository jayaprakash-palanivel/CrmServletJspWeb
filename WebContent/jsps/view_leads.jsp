<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.crm.com/View Leads</title>
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
<p>&nbsp;</p> <u><b>View Leads</b></u> <br> <%
  %>
<hr width=100% color=#1c4966>

<table border="0" align="top" width=100%>
                    <tr>

						<td><b>firstName</b></td>
						<td align='left'>:<c:out value="${leadsBo.firstName}"></c:out></td>
						<td><b>lastName</b></td>
						<td align='left'>:<c:out value="${leadsBo.lastName}"></c:out>
						</td>

					</tr>
					<tr>

						<td><b>emailAddress</b></td>
						<td align='left'>:<c:out value="${leadsBo.emailAddress}"></c:out></td>
						<td><b>mobileNumber</b></td>
						<td align='left'>:<c:out value="${leadsBo.mobileNumber}"></c:out>
						</td>

					</tr>
					<tr>

						<td><b>companyName</b></td>
						<td align='left'>:<c:out value="${leadsBo.companyName}"></c:out></td>
						<td><b>salary</b></td>
						<td align='left'>:<c:out value="${leadsBo.salary}"></c:out>
						</td>

					</tr>
					<tr>

						<td><b>address</b></td>
						<td align='left'>:<c:out value="${leadsBo.address}"></c:out></td>
						<td><b>city</b></td>
						<td align='left'>:<c:out value="${leadsBo.city}"></c:out>
						</td>

					</tr>
					<tr>

						<td><b>state</b></td>
						<td align='left'>:<c:out value="${leadsBo.state}"></c:out></td>
						<td><b>country</b></td>
						<td align='left'>:<c:out value="${leadsBo.country}"></c:out>
						</td>

					</tr>
					<tr>
					</tr>
				</table>
				<h3 style="text-align: center;">
						<button style="background-color: #1c4966; color: white">
							<a href='listLeads' style="text-decoration: none;background-color: #1c4966; color: white">Back
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