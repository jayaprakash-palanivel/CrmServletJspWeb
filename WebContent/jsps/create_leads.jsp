<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><title>www.crm.com/Create Profile</title>
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" />
</head>
<body>
<table width=900 border="0" align="center">
<tr>
	<td colspan="2"><%@ include file="../jsps/header.jsp" %></td>
</tr>
<tr>
<td width="150">
<%@ include file="../jsps/main_menu.jsp" %>
</td> 
<td width ="750" valign="top" align = "center">
<p>&nbsp;</p>
<b>Enter Leads Detail for New Employee.</b>
<br>
<% if(session.getAttribute("lErrorMsg")!=null){
	out.println("<b>"+session.getAttribute("lErrorMsg")+"!!!</b>");
	}
%>
<hr width=100% color=#1c4966>
<table  border="0" align="top" width=100% >
 <form action="createLeads" method="post">
    <tr>
	<td bgcolor ='#1c4966' colspan='4' align=left height=20><b style="color:white"> Information</b></td>
	</tr>
	 <tr>
	 <td>First Name</td>
	  <td align='left'><input type='text' name='firstName' id='firstName' size ='15' value=''/></td>
	  <td>Last Name</td>
	  <td align='left'><input type='text' name='lastName' id='lastName' size ='15' value=''/> </td>
	  
  </tr>
  
  <tr>
	  <td>EmailId</td>
	  <td align='left'><input type='text' name='emailAddress' id='emailAddress' size ='15' value=''/></td>
	  <td>MobileNumber</td>
	  <td align='left'><input type='number' name='mobileNumber' id='mobileNumber' size ='15' value=''/> </td>
</tr>

<tr>
	  <td>Company Name</td>
	  <td align='left'><input type='text' name='companyName' id='companyName' size ='15' value=''/></td>
	  <td>Salary</td>
	  <td align='left'><input type='text' name=salary id='salary' size ='15' value=''/> </td>
</tr>

 <tr>
	  <td>Address</td>
	  <td align='left'><input type='text' name='address' id='address' size ='15' value=''/> </td>
	  <td>City</td>
	  <td align='left'><input type='text' name='city' id='city' size ='15' value=''/> </td>
  </tr>
  
  <tr>
  <td>State</td>
   <td align='left'><input type='text' name='state' id='state' size ='15' value=''/> </td>
  <td>Country</td>
	  <td align='left' ><input type='text' name='country' id='country' size ='15' value=''/></td>
	  <td>&nbsp;</td>
	  <td>&nbsp;</td>
  </tr>
  <tr>
 
	  <td align='center' colspan='4'>
	  <input type='submit' name='submit' id='submit' size ='15' value='Submit' style="background-color:#1c4966; color:white"/>
	
	  <button type="reset"  style="background-color:#1c4966; color:white">Reset</button>
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