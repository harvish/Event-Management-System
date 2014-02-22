<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%/* if(session.getAttribute("username")==null)
	response.sendRedirect("login.jsp?redirect="); */%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration</title>
<link rel="stylesheet" href="css/ui-lightness/jquery-ui.min.css" />
<script src="js/customervalidate.js"></script>
</head>
<body>
<div id="load">
<div style="padding-left: 400px;padding-right:400px">
<br><br><br><br>
<form class="well" style="background-color:transparent;">
<table class="well table" align="center">
<tr><td>Name</td><td><input type="text" id="cname" name="cname"/><div id="c1"  class="error"></div></td></tr>
<tr><td>Address</td><td><input type="text" id="caddress" name="caddress"/><div id="c2" class="error"></div></td></tr>
<tr><td>Member</td><td><input type="radio" value="Y" id="yes" name="member"/>Y
					<input type="radio" value="N" id="no" name="member"/>N<div id="c3"  class="error"></div></td></tr>
<tr><td><p id="exp">Expiry Date</p></td><td><input type="text" id="edate" name="edate"/><div id="c4"  class="error"></div></td></tr>
<tr><td>City</td><td><input type="text" id="ccity" name="ccity"/><div id="c5"  class="error"></div></td></tr>
<tr><td>Email</td><td><input type="text" id="cemail" name="cemail"/><div id="c6"  class="error"></div></td></tr>
<tr><td>Contact No.</td><td><input type="text" id="ccontact" name="ccontact"/><div id="c7"  class="error"></div></td></tr>
<tr><td><div id="disp"></div></td></tr>
<tr><td><input class="btn btn-primary" type="button" value="Register"  id="register" name="register" /></td>
<td><input class="btn btn-danger" type="reset" value="Reset" id = "reset" name="reset"/></td></tr>
</table>
</form>
</div>
</div>
</body>
</html>