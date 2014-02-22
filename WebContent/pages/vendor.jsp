<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Vendor Screen</title>
	<script src="js/vendorValidation.js"></script>
<!-- 	<script src="js/dropDownAjax.js"></script> -->
</head>
<body>
	<div id="loader" align="center">
	<img src="img/loading_icon.gif"  align="middle"></div>
	
	<div id="body">
		<div id="load" style="padding-left: 400px;padding-right: 400px;">
			<br>
			<form class="well" style="background-color:transparent;">
				<table class="well table" id="form2" align="center" style="width: 100%;">
					<tr>
						<td>NAME</td>
						<td><input class="span3 input-medium search-query"
							id="vendorName" type="text" name="vendorName">
						<div class="error" id="vendorCheck"></div>
					</tr>
					<tr>
						<td class="span3">ADDRESS</td>
						<td class="span2"><textarea id="vendorAddress" rows="5"
								cols="23" name="vendorAddress"></textarea>
								<div class="error" id="addressCheck"></div>
						</td>
					</tr>
					<tr>
						<td>CITY</td>
						<td><input class="span3 input-medium search-query"
							id="vendorCity" type="text" name="vendorCity" />
								<div class="error" id="cityCheck"></div>
						</td>
					</tr>
					<tr>
						<td>EMAIL</td>
						<td><input class="span3 input-medium search-query"
							id="vendorEmail" type="text" name="vendorEmail" />
							<div class="error" id="emailCheck"></div>
						</td>
					</tr>
					<tr>
						<td>CONTACT NUMBER</td>
						<td><input class="span3 input-medium search-query"
							id="vendorContact" type="text" name="vendorContact" />
						<div class="error" id="contactCheck"></div>
						</td>
					</tr>
					<tr>
						<td><input class="btn btn-primary btn-default" id="register" type="button"
							value="REGISTER">
						</td>
						<td><input class="btn btn-danger btn-default" id="reset1" type="reset"
							value="RESET">
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
		<div ID="Success" align="center">
		<H1 align="center" style="color:white">ALL DETAILS HAVE BEEN INSERTED SUCCESSFULLY</H1>
		<button  id="addMoreFacility" class="btn btn-success">ADD MORE
			FACILITY</button>

	</div>

	

</body>
</html>