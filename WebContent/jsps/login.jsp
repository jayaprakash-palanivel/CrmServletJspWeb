<html>
<head>
<title>www.crm.com/User Login</title>
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script type="text/javascript">

	function myFunction() {
		  var x = document.getElementById("myInput");
		  if (x.type === "password") {
		    x.type = "text";
		  } else {
		    x.type = "password";
		  }
		}
	</script>
</head>
<body>


	<form action="login" method="post">
		<table width="900" align=center>
			<tr>
				<td colspan="2"><%@ include file="../jsps/header.jsp"%></td>
			</tr>
			<tr>
				<td colspan="2">
					<table border="0" align="center">
					<tr>
							<td colspan="2" ><h3 style="text-align:center;color:green"><b>${errorMessage}</b></h3></td>
							</tr>
					
						<br>
						<br>
						<br>
						<tr>
							<td><h1>Login</h1></td>
							<br>
							<tr>
							<td colspan="2" ><b>User Name:</b></td>
							</tr>
							<tr>
							<td colspan="2"><input type="text" name="userName"
								id="userName" value="" size="26" style="font-size:13pt;"/>
							</td>
						</tr>
						
						<tr>
						<td colspan="2" ><b>Password:</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="forgotPassword">Forgot Password?</a></td>
							</tr>
							<tr>
							<td colspan="2"><input type="password" name="password"
								id="myInput" value="" size="26" style="font-size:13pt;"/>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="checkbox"
								onclick="myFunction()">Show Password</td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						<tr>
							<td ><input type="submit" name="submit"
								id="submit" value="Login"
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
