<%@page import="com.ems.dao.FormGetters,java.util.Map,java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="css/ui-lightness/jquery-ui.min.css">
 <title>Event Booking</title> 
<script> 
var d=new Date();

var startdatefn=function(enddate){

	$( "#start_date" ).datepicker({
		dateFormat: "yy-mm-dd",    
		defaultDate: d.getFullYear()+'-'+(d.getMonth()<9?('0'+(d.getMonth()+1)):d.getMonth())+'-'+d.getDate(),    
		minDate: "2014-01-01",    
		maxDate: enddate ,    
		changeMonth: true,    
		changeYear: true,    
		yearRange: "2014:2025",    
		onClose: function(dateText, inst) {     
			$( "#end_date" ).datepicker('destroy');
			var validDate = $.datepicker.formatDate( "yy-mm-dd", 
					$('#start_date').datepicker('getDate'));            
			$('#start_date').datepicker('setDate', validDate);
			enddatefn(validDate);
		}    
	});
};
var enddatefn=function(startdate){
	$( "#end_date" ).datepicker({
		dateFormat: "yy-mm-dd",    
		defaultDate: d.getFullYear()+'-'+(d.getMonth()<9?('0'+(d.getMonth()+1)):d.getMonth())+'-'+d.getDate(),    
		minDate: startdate,    
		maxDate: "+30D",    
		changeMonth: true,    
		changeYear: true,    
		yearRange: "2014:2025",    
		onClose: function(dateText, inst) {      
			$( "#start_date" ).datepicker('destroy');
			var validDate = $.datepicker.formatDate( "yy-mm-dd", 
					$('#end_date').datepicker('getDate'));            
			$('#end_date').datepicker('setDate', validDate);
			startdatefn(validDate);
		}    
	});
};

  
 $(document).ready(function() {
	 startdatefn("01/01/2015");
	enddatefn("15/01/2014");
	
}); 
</script>
<script>
 	function show_venue() {
 		loadgif();
		    $.getJSON("GetVenue?venue_id="+$("#venue_id").val(), function(result) {
		    	unloadgif();
		    	var popupWin = window.open("","","width=500,height=500");
	   			var res="<center><table width=\"300px\" height=\"300px\" border=\"3px\"><tr><td>Venue ID</td><td>" + result.venue_id + "</td></tr><tr><td>Venue Name</td><td>" + result.venue_name + "</td></tr><tr><td>location</td><td>" + result.location + "</td></tr><tr><td>Cost</td><td>" + result.cost+"</td></tr><tr><td colspan=\"2\"><center><input type=\"button\" value=\"Close Window\" onclick=\"self.close()\" /></center></td></tr></table></center>";
 		        popupWin.document.write(res);
 		    });
 	}
</script>


</head>
<body style="background-color: black;width: 100%">

<div id="1" class="row">

<div id="cen" style="padding-left: 400px;padding-right:400px; padding-top: 10px">

<form class="well" name="myForm" ng-submit="processform()" style="background-color: transparent;opacity:1.0;">

<table class="well table" align="center">
<tr>
<td><input type="radio" ng-model="form.addOrEdit" value="false" />Add Event</td>
<td><input type="radio" ng-model="form.addOrEdit" value="true" />Edit Previous Event
</td>
</tr>
<tr>
<td>Customer ID</td>
<td><input type="text" name="customer_id" ng-model="form.customer_id" ng-blur="checkCustomerId()" ng-minLength="7" required/>
 <span class="error" ng-show="myForm.customer_id.$error.minlength">Too short!</span>
 <span class="error" ng-show="true">{{checkcustomer}}</span>
</td>
</tr>
<tr ng-show="form.addOrEdit">
<td>Event ID</td>
<td><input type="text" name="event_id" ng-model="form.event_id" ng-blur="fetchDetails()" ng-minLength="7"/>
 <span class="error" ng-show="myForm.event_id.$error.minlength">Too short!</span>
 <span class="error" ng-show="true">{{checkevent}}</span>
</td>
</tr>
<tr>
<td>Event Name</td>
<td><input type="text" name="event_name" ng-model="form.event_name" required ng-minLength="4" ng-pattern="/^[A-Za-z ]*$/" />
 <span class="error" ng-show="myForm.event_name.$error.minlength">Too short!</span>
 <span class="error" ng-show="myForm.event_name.$error.pattern">Only Alphabets are allowed</span>
 </td>
</tr>
<tr>
<td>Start Date</td>
<td>
<input type="text" name="start_date" id="start_date" readOnly ng-model="form.start_date" required datepicker/> 
<!--  <div class="form-group date" ng-class="{'has-error': myForm.date.$invalid}">
   <input type="text" id="date" data-date-format="dd/MM/yyyy"  data-autoclose="1" ng-model="form.start_date" data-max-date="{{end_date}}" name="start_date" bs-datepicker width="50%">
  </div>
 -->
   </td>
</tr>
<tr>
<td>End Date</td>
<td>
<input type="text" name="end_date" id="end_date" readOnly ng-model="form.end_date" required datepicker/>
<!-- <div class="form-group " ng-class="{'has-error': Form.date.$invalid}">
   <input type="text" id="date" data-date-format="dd/MM/yyyy" data-autoclose="1" ng-model="form.end_date" data-max-date="{{start_date}}" name="end_date" bs-datepicker width="50%">
  </div>
 -->
 </td>
</tr>
<tr>
<td>Event Type</td>
<td>
<select name="event_type" ng-model="form.event_type" id="event_type" required>
<option value="">-SELECT-</option>
<%!FormGetters f=new FormGetters(); %>
<% Map<String,String> events= f.getEventTypes();
Set<String> event= events.keySet();
for(String s: event)
{
%>
<option value="<%=s%>"><%=events.get(s)%></option>
<% } %>
</select>
</td>
</tr>
<tr>
<td>Venue Name</td>
<!--  <td><input type="text" name="venue_id" /></td> -->
<td><select name="venue_id" ng-model="form.venue_id" id="venue_id" required>
<option value="">-SELECT-</option>
<% Map<String,String> venues= f.getVenues();
Set<String> venue= venues.keySet();
for(String s: venue)
{
%>
<option value="<%=s%>"><%=venues.get(s)%></option>
<% } %>
</select>
<button class="btn btn-primary btn-xs"" onclick="show_venue()">Show</button>
</td>
</tr>
<tr>
<td>Start Time</td>
<td><input type="text" name="start_time" ng-model="form.start_time" class="time" required ng-pattern="/^([1]{1}[0-9]{1}$)|(^[2]{1}[0-4]{1}$)|(^[1-9]{1}$)/"/>
 <span class="error" ng-show="myForm.start_time.$error.pattern">Enter Valid Time! [1-24]</span>
</td>
</tr>
<tr>
<td>End Time</td>
<td><input type="text" name="end_time"  ng-model="form.end_time" required ng-pattern="/^([1]{1}[0-9]{1}$)|(^[2]{1}[0-4]{1}$)|(^[1-9]{1}$)/"/>
<span class="error" ng-show="myForm.end_time.$error.pattern">Enter Valid Time! [1-24]</span>
</td>
</tr>
<tr>
<td>Budget</td>
<td><input type="text" name="budget" ng-model="form.budget" required/>
</td>
</tr>
<tr>
<td><input type="submit" ng-hide="form.addOrEdit" class="btn btn-primary" value="Register" />
<input type="submit" class="btn btn-primary" ng-show="form.addOrEdit" value="Update" /></td>
<td><button class="btn btn-danger" type="reset">Reset</button></td>
</tr>
</table>
</form>
</div>
</div>
</body>
</html>