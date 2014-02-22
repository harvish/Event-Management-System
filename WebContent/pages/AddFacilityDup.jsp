<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>ADD FACILITY</title>

<link rel="stylesheet" href="css/tables.css">

</head>

<body>

	<script language="JavaScript" src="js/dropDownAjax.js"></script>
  	
	<div id="body" >
	
	<h2 ALIGN="center" style="color:white">ADD FACILITY</h2>

		<form id="form1"  onsubmit="return validate()">

			<table id="table" align="center" style="width: 100px;"  class="well table-hover table-bordered"  >
				<tr>

					<td>DESCRIPTION</td>

					<td><select id="facilityDropDown" name="facility1"><option
								value=''>select an option</option>
					</select>
					</td>

					<td>COST</td>

					<td><input type="text" id="cost1" name="faciltyCost1">
					</td>

				</tr>

				<tr  style="border: hidden; border-left: none; border-right: none; border-bottom: thin;">

					<td class="valfields"></td>

					<td class="valfields"  id="sd0"></td>

					<td class="valfields"></td>

					<td class="valfields" id="td0"></td>

				</tr>


			</table>
			
			<div style="text-align:center;">
			
			<input type="button" id="addMore" value="ADD MORE" class="btn btn-primary"><br><br>
			
			<input type="button" id="submit" value="REGISTER" class="btn btn-success">
			
			<input type="button" id="reset" value="RESET" class="btn btn-warning">
			
			</div>
		

		</form>

	</div>

</body>

</html>