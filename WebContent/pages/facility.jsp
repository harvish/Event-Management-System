<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Facility Screen</title>
<script src="js/script1.js"></script>
</head>
<body>
<div>
<div align="center" style="border:thick; padding-left: 300px;padding-right: 200px;padding-top: 70px;">
<form id="formh" class="well" method="post" onsubmit="return false;" style="background-color: transparent;">
<br>
<table class="well table" >
<tr>
<td>Customer id</td>
<td><input type="text" id="customer_id" name="customer_id" onblur="loadxml()" required></td>
</tr>
<tr id="tr1"><td>EVENT ID</td><td><select id="select" name="event_id" required></select></td></tr>

</table> 

<table class="well table" id="dataTable">
<tr><td>FACILITY</td><td><select id="select1" name="tfIdName" onfocus="loadxml2()" onchange="loadxml2()" required></select></td>
<td>VENDOR ID</td><td><select id="select2" name="vendor_id" onfocus="loadxml3()" onchange="loadxml3()" required></select></td>
<td>COST</td><td><input type="text" id="myDiv" name="cost" readOnly></td>
<td>QUANTITY</td><td><input type="text" id="quantity" name="quantity" required></td>
<td><INPUT class="btn btn-success btn-xs" type="button" id="admore" value="ADD FACILITY"  /></td>
<td></td>
</table>
<input type="button" value="SUBMIT" class="btn btn-primary btn-default" onclick="submitthis();"/>
</form>
</div>
</div>
</body>
</html>