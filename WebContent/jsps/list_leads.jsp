<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.crm.com/Create Profile</title>
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%
		int count = 1;
	%>
<table width="900" border="0" align="center">
<tr>
<td colspan="2"><%@ include file="../jsps/header.jsp"%></td>
</tr>
<tr>
<td width="150"><%@ include file="../jsps/main_menu.jsp"%>
</td>
<td width="750" valign="top" align="center">
<p>&nbsp;</p> <b><u>List Leads</u></b>
<hr width=100% color=#1c4966> <br> <c:if
test="${not empty successMessage}">
<h3 style="text-align: center; color: green">${successMessage}</h3>

</c:if> <c:if test="${not empty errorMessage}">
<h3 style="text-align: center; color: green">${errorMessage}</h3>
</c:if>
<form action="searchLeads" method="post">
<input type="text" name="firstName" placeholder="firstName" value="">
<input type="text" name="emailAddress" placeholder="emailAddress" value=""> 
<input type='submit' value='Search'
style="background-color: #1c4966; color: white">
</form> <br>

<table border="1" align="top" width=100%>

					<tr style="background-color: #1c4966; color: white">
						<th>S.No</th>
						<th>FirstName</th>
						<th>LastName</th>
						<th>EmailAddress</th>
						<th>MobileNumber</th>
						<th>CompanyName</th>
						<th>Salary</th>
						<th>Address</th>
						<th>City</th>
						<th>State</th>
						<th>Country</th>
						<th>View</th>
						<th>Edit</th>
						<th>Delete</th>
                   </tr>
     
<c:forEach items="${leadsList}" var="leadsBo">

						<tr style="border: 1px solid black; width: 100%">
							<td><%=count%></td>
							<%
								count++;
							%>

							<td>${leadsBo.firstName}</td>
							<td>${leadsBo.lastName}</td>
							<td>${leadsBo.emailAddress}</td>
							<td>${leadsBo.mobileNumber}</td>
							<td>${leadsBo.companyName}</td>
							<td>${leadsBo.salary}</td>
							<td>${leadsBo.address}</td>
							<td>${leadsBo.city}</td>
							<td>${leadsBo.state}</td>
							<td>${leadsBo.country}</td>
							<td><a href="viewLeads?leadsId=${leadsBo.leadsId}"><i
									class="fa fa-eye" style="color: black"></i></a></td>
							<td><a href="editLeads?leadsId=${leadsBo.leadsId}"><i
									class="fa fa-edit" style="color: black"></i></a></td>
							<td><a
								href="deleteLeads?leadsId=${leadsBo.leadsId}"><i
									class="fa fa-trash-o" style="color: black"></i></a></td>
						 </tr>
</c:forEach>
</table>
				 <c:if test="${empty search }">
				<h3 style="text-align: center;">
					<button style="background-color: #1c4966; color: white">
						<a href='home'style="text-decoration: none; background-color: #1c4966; color: white">Back To Home</a>
					</button>
					</h3> </c:if>
				<c:if test="${not empty search }">
				<h3 style="text-align: center;">
					<button style="background-color: #1c4966; color: white">
						<a href='listLeads'style="text-decoration: none; background-color: #1c4966; color: white">Back To List</a>
					</button>
				</h3> </c:if>
<hr width=100% color=#1c4966>
			</td>
		</tr>
		<tr>
			<td colspan="2"><%@include file="../jsps/footer.jsp"%></td>
		</tr>
	</table>

</body>
</html>