<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Generation</title>

<!-- 
<script src="js/jquery.js"></script>
<script src="js/jquery-ui-custom.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>

 -->
<script src="js/records.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	$('#button').click(function(){
	       /* var data = $('#txt').val();
	        if(data == '')
	            return;*/
	      //  alert("asdsad");
	        JSONToCSVConvertor(obj1.table, "Vehicle Report", true); 
	        //alert("qqqqqqq");
	    });
	
	$("#from").datepicker ({maxDate: "+0D",dateFormat:"yy/mm/dd"});
	count=0;
	$("#from" ).change(function(){	
	count++;
	if(count>0){
		$('#to').datepicker('destroy');
		$('#to').val("");
	}

	var dateTypeVar = $('#from').datepicker('getDate');
	dateString = $.datepicker.formatDate('yy/mm/dd',dateTypeVar);
	$("#to").datepicker({ maxDate: "0D", minDate: dateString,dateFormat:"yy/mm/dd" });

	});
	});


</script>

</head>
<body>
<div>
<div style="padding-left: 300px;padding-right: 300px;">
<form class="well" >
<table class="well" align="center">

<tr><th>SELECT THE RANGE</th></tr>
<tr><td style="text-shadow: 5px 5px 5px #FF000;">FROM:</td><td><input id="from" name="f" type="text"></td><td>TO:</td>
<td><input id="to" name="t" type="text"></td>
<td><input class="btn btn-primary btn-sm" type="button" value="Get Records" onclick="gett();"></td></tr>
<tr><td id="td1"></td> </tr>
<tr></tr>
<tr><td></td></tr>
</table>
</form>
</div>

</div>
<div id="div"></div>
<input class="btn btn-primary btn-sm" type="button"  style="margin-left:45%" value="SAVE PAGE" id="button">
</body>
 </html>