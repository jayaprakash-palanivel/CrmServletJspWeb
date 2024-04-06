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
<b><u>Edit Leads</u></b>
<br>
<% if(session.getAttribute("lErrorMsg")!=null){
	out.println("<b>"+session.getAttribute("lErrorMsg")+"!!!</b>");
	
}
	
	%>


<hr width=100% color=#1c4966>
<table  border="0" align="top" width=100% >
  <form action="editLeads" method="post">
      <input type='hidden' name='leadsId' id='leadsId' size ='15' value='${editLeads.leadsId }'/>
	  <tr>
	  
	  <td>First Name</td>
	  <td align='left'><input type='text' name='firstName' id='firstName' size ='15' value='${editLeads.firstName }'/></td>
	  <td>Last Name</td>
	  <td align='left'><input type='text' name='lastName' id='lastName' size ='15' value='${editLeads.lastName }'/> </td>
	  
  </tr>
  <tr>
	  <td>EmailAddress</td>
	  <td align='left'><input type='text' name='emailAddress' id='emailAddress' size ='15' value='${editLeads.emailAddress }'/></td>
	  <<td>MobileNumber</td>
	  <td align='left'><input type='text' name='mobileNumber' id='mobileNumber' size ='15' value='${editLeads.mobileNumber }'/> </td>
  </tr>  
  <tr>
	  
	  <td>Company Name</td>
	  <td align='left'><input type='text' name='companyName' id='companyName' size ='15' value='${editLeads.companyName }'/></td>
	  <td>Salary</td>
	  <td align='left'><input type='text' name='salary' id='salary' size ='15' value='${editLeads.salary }'/> </td>
	  
  </tr>
  <tr>
	  <td>Address</td>
	  <td align='left'><input type='text' name='address' id='address' size ='15' value='${editLeads.address }'/> </td>
	  <td>City</td>
	  <td align='left'><input type='text' name='city' id='city' size ='15' value='${editLeads.city }'/> </td>
  </tr>
  
  
  <tr>
      <td>State</td>
	  <td align='left'><input type='text' name='state' id='state' size ='15' value='${editLeads.state }'/> </td>
	  <td>Country</td>
	  <td align='left' ><input type='text' name='country' id='country' size ='15' value='${editLeads.country }'/></td>
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