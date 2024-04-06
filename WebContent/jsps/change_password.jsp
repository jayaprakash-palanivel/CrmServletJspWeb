<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	function myFunction() {
		  var x = document.getElementById("myPasswordInput");
		  var y = document.getElementById("myConfirmPasswordInput");
		  if (x.type === "password" || y.type=== "password") {
		    x.type = "text";
		    y.type="text";
		  } else {
		    x.type = "password";
		    y.type="password";
		  }
		}
	</script>
</head>
<body>
<form action="changePassword" method="post">
		<table width="900" align=center>
			<tr>
				<td colspan="2"><%@ include file="../jsps/header.jsp"%></td>
			</tr>
			<tr>
			
			<c:if test="${not empty loggedInUser}">
					<td width="150">
                <%@ include file="../jsps/main_menu.jsp" %>
             </td>  

				</c:if>
			
             
				<td width ="750" valign="top" align = "center">
					<table border="0" align="center">
					<tr>
							<td colspan="2" ><h3 style="text-align:center;color:green"><b>${errorMessage}</b></h3></td>
							</tr>
					
						<br>
						<br>
						<br>
						<tr>
							<td><h1>Change Password</h1></td>
							<br>
							<tr>
							<td colspan="2" ><b>Email Id:</b></td>
							</tr>
							<tr>
							<td colspan="2"><input type="text" name="emailAddress" 
								id="emailAddress" disabled='disabled' value="${email}" size="26" style="font-size:13pt;" readonly/>
							</td>
						</tr>
						<tr>
						<td colspan="2" ><b>New Password:</b> </td>
							</tr>
							<tr>
							<td colspan="2"><input type="password" name="password"
								id="myPasswordInput" value="" size="26" style="font-size:13pt;"/>
							</td>
						</tr>
						<tr>
						<td colspan="2" ><b>Confirm Password:</b> </td>
							</tr>
							<tr>
							<td colspan="2"><input type="password" name="confirmPassword"
								id="myConfirmPasswordInput" value="" size="26" style="font-size:13pt;"/>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="checkbox"
								onclick="myFunction()">Show Password</td>
						</tr>
						
						<tr>
							<td ><input type="submit" name="Verify"
								id="submit" value="Change Password"
								style="background-color: #1c4966; color: white; font-size:15pt;"  /></td>
							
						</tr>


					</table>
				</td>
				
			</tr>
			
			
			<tr>
				<td colspan="2"><%@include file="../jsps/footer.jsp"%></td>
			</tr>
		</table>
	</form>
</body>
</html>