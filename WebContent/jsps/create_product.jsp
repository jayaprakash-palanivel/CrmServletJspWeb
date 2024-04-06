<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><title>www.crm.com/Create products</title>
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
<b>Enter Details for New product.</b>
<br>
<% if(session.getAttribute("lErrorMsg")!=null){
	out.println("<b>"+session.getAttribute("lErrorMsg")+"!!!</b>");
	}
%>
<hr width=100% color=#1c4966>
<table  border="0" align="top" width=100% >
 <form action="createProduct" method="post">
 <tr>
	<td bgcolor ='#1c4966' colspan='4' align=left height=20><b style="color:white"> product Information</b></td>
</tr>
	<tr>
	 <td>ProductName :</td>
	  <td align='left'><input type='text' name='productName' id='productName' size ='15' value=''/></td>
	  <td>ProductSpecification :</td>
	  <td align='left'><input type='text' name='productSpecification' id='productSpecification' size ='15' value=''/> </td>
	  
  </tr>
  <tr>
	 <td>MinimumStocks :</td>
	  <td align='left'><input type='text' name='minimumStocks' id='minimumStocks' size ='15' value=''/></td>
	  <td>MaximumStocks :</td>
	  <td align='left'><input type='text' name='maximumStocks' id='maximumStocks' size ='15' value=''/> </td>
	  
  </tr>
  <tr>
	 <td>AvailableStocks :</td>
	  <td align='left'><input type='text' name='availableStocks' id='availableStocks' size ='15' value=''/></td>
	  <td>Price :</td>
	  <td align='left'><input type='text' name='price' id='price' size ='15' value=''/> </td>
	  
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