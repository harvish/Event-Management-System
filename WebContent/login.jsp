 	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Event Management System</title>
<script src="js/jquery.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
 <script src="js/jquery.js"></script>
  <script src="js/bootstrap/bootstrap.min.js"></script>
	 
<style>
.error {
	 display:block;
	 color: red;
	 font-size: 10px;
}
#log {
margin-left:300px;
margin-top:200px;
}
#myCarousel {
 	z-index: -10;
 	position:absolute;
 	left:0px;
 	top:0px;
 	width:100%;
 	height:700px;
 	opacity :0.8;
 }
</style>
<script>
$(document).ready(function(){
	 $('.carousel').carousel({
	        interval: 3000
	    });

	    $('.carousel').carousel('cycle');
	    $("#login").on("click",function(){
		
		var uname = $("#uname").val();
		var pwd = $("#pwd").val();
		//alert(''+uname+pwd);
		var check = nullcheck(uname,pwd);		
		if(check==1)
			{
			//alert("hi");
			callAjax();
			}	
	});
});

function nullcheck(field1,field2)
{var f1=0,f2=0;
	if(field1=="")
	{
		f1=0;
	document.getElementById("un").innerHTML="<span class=\"error\">UserName is empty</span>";
	}
else
	{
	f1=1;
	document.getElementById("un").innerHTML="";
	}

if(field2=="")
	{
	f2=0;
	document.getElementById("pw").innerHTML="<span class=\"error\">Password  is empty</span>";
	}
else
	{
	f2=1;
	document.getElementById("pw").innerHTML="";
	}
var f = f1&&f2;
//alert(f);
return f;
	}

function callAjax()
{
	$.ajax({ 
		url:'LoginController',
		type:'post',
		data:{uname:$("#uname").val(),pwd:$("#pwd").val()},
		success:function()
		{
			window.location.href = "home.html";
		},
		error:function(){
			window.location.href = "login.jsp";
		} 
	});
}
	
</script>
</head>
<body>
<!-- Carousel -->
		<div id="myCarousel" class="carousel slide" > 

		<div class="carousel-inner" >
		
		<div class="active item"><img src="images/img1.jpg" alt="Partners" style="height: 900px;width: 100%" /></div>
		
		<div class="item"><img src="images/screen-shot-2013-08-30-at-9.41.13-am.jpg" alt="Airtel" style="height: 900px;width: 100%"/></div>
		
		<div class="item"><img src="images/slide2.jpg" alt="TNEB" style="height: 900px;width: 100%"/></div>
		
		<div class="item"><img src="images/img2.jpg" alt="Reliance" style="height: 900px;width: 100%" /></div>
		
		</div>
		
		<a class="carousel-control left" data-slide="prev"> &lt;</a>
		
		<a class="carousel-control right" data-slide="next">&gt;</a>
		</div>

<div class="page-header"><h1  style="color:white">Event management System</h1></div>
<div id="log">
<form class="well well-lg" style="width:30%">
<div class="input-group input-group-lg" style="width:100%">
  <input type="text" class="form-control" id='uname' name="uname" placeholder="Username" style="width:100%">
  <div id="un" style="margin-top:10px;"></div>
</div>
<br>
<div class="input-group input-group-lg" style="width:100%">
  <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
  <div id="pw" style="margin-top:10px;"></div>
</div>
<br />
<div class="input-group input-group-lg" >

<input class="btn btn-primary" type="button" value="Login" name="login" id="login" style="margin-left:40px"/>
<input class="btn" type="reset" value="Reset" name="reset" id="reset" style="margin-left:50px"/>
</div>
<!-- <table>
<tr><td>UserName</td><td><input class="span3" type="text" name="uname" id="uname"/></td></tr>
<tr><td>Password</td><td><input class="span3" type="password" name="pwd" id="pwd"/></td></tr>
<tr><td><input class="btn btn-primary" type="button" value="Login" name="login" id="login"/></td>
<td><input class="btn" type="reset" value="Reset" name="reset" id="reset"/></td>
</tr>
</table>
 --></form>
</div>
</body>
</html>