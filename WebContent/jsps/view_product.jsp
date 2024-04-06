<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>www.crm.com/View Product</title>
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
				<p>&nbsp;</p> <u><b>View Product</b></u> <br> <%
 	
 %>


				<hr width=100% color=#1c4966>
				<table border="0" align="top" width=100%>


					<tr>

						<td><b>ProductName</b></td>
						<td align='left'>:<c:out value="${productBo.productName}"></c:out></td>
						<td><b>Specification</b></td>
						<td align='left'>:<c:out value="${productBo.productSpecification}"></c:out>
						</td>

					</tr>
					<tr>
						<td><b>MinimumStocks</b></td>
						<td align='left'>:<c:out value="${productBo.minimumStocks}"></c:out></td>
						<td><b>MaximumStocks</b></td>
						<td align='left'>:<c:out value="${productBo.maximumStocks}"></c:out>
						</td>
					</tr>
					<tr>
						<td><b>AvailableStocks</b></td>
						<td align='left'>:<c:out value="${productBo.availableStocks}"></c:out>
						</td>
						<td><b>price</b></td>
						<td align='left'>:<c:out value="${productBo.price}"></c:out>
						</td>
					</tr>
					
					<tr>
					</tr>
				</table>
				<h3 style="text-align: center;">
						<button style="background-color: #1c4966; color: white">
							<a href='listProduct' style="text-decoration: none;background-color: #1c4966; color: white">Back
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