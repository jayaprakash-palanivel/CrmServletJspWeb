<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><title>www.crm.com/Edit Profile</title>
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" />
</head>
<body>
<table width="900" border="0" align="center"> 
<tr>
	<td colspan="2"><%@ include file="../jsps/header.jsp" %></td>
</tr>
<tr>
<td width="150">
<%@ include file="../jsps/main_menu.jsp" %>
</td>  
<td width ="750" valign="top" align = "center">
<p>&nbsp;</p>
<b><u>Edit Employee</u></b>
<br>
<% if(session.getAttribute("lErrorMsg")!=null){
	out.println("<b>"+session.getAttribute("lErrorMsg")+"!!!</b>");
	
}
	
	%>


<hr width=100% color=#1c4966>
<table  border="0" align="top" width=100% >
  <form action="editEmployee" method="post">
      <input type='hidden' name='employeeId' id='employeeId' size ='15' value='${editEmployee.employeeId }'/>
	  <tr>
	  
	  <td>First Name</td>
	  <td align='left'><input type='text' name='firstName' id='firstName' size ='15' value='${editEmployee.firstName }'/></td>
	  <td>Last Name</td>
	  <td align='left'><input type='text' name='lastName' id='lastName' size ='15' value='${editEmployee.lastName }'/> </td>
	  
  </tr>
  <tr>
	  <td>EmailId</td>
	  <td align='left'><input type='text' name='emailAddress' id='emailAddress' size ='15' value='${editEmployee.emailAddress }'/></td>
	  <td>Password</td>
	  <td align='left'><input type='password' name='password' id='password' size ='15' value='${editEmployee.password }'/> </td>
  </tr>  
  <tr>
	  <td>MobileNumber</td>
	  <td align='left'><input type='text' name='mobileNumber' id='mobileNumber' size ='15' value='${editEmployee.mobileNumber }'/> </td>
	  <td>DOB</td>
	  <td align='left'><input type='date' name='dateofBirth' id='dateofBirth' size ='15' value='${editEmployee.dateofBirth }'/> </td>
  </tr>
  <tr>
	  <td>Address</td>
	  <td align='left'><input type='text' name='address' id='address' size ='15' value='${editEmployee.address }'/> </td>
	  <td>City</td>
	  <td align='left'><input type='text' name='city' id='city' size ='15' value='${editEmployee.city }'/> </td>
  </tr>
  
  
  <tr>
	  <td>Country</td>
	  <td align='left' ><input type='text' name='country' id='country' size ='15' value='${editEmployee.country }'/></td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
  </tr>
  
	  

  <tr>
 
	  <td align='center' colspan='4'>
	  <input type='submit' name='submit' id='submit' size ='15' value='Update' style="background-color:#1c4966; color:white"/>
	
	  
	  </td>
	  
  </tr>
  
  </form>
</table>

<hr width=100% color=#1c4966>
</td>
</tr>
<tr>
    <td colspan="2"><%@include file="../jsps/footer.jsp"%></td>
</tr>
</table>
</body>
</html>