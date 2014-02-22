var field1=0;
var field2=0;
var field3=0;
var field4=0;
var field5=0;
var field6=0;
var field7=0;

$(document).ready(function(){
	$("#edate").hide();
	$("#exp").hide();
	$("#cname").blur(function(){
		 field1 = validateCustomerName($(this).val());
			});
	
	$("#caddress").blur(function(){
		 field2 = validateCustomerAddress($(this).val());
	});
	
	$("input").on("click",function(){	
		 validateRadio();			
	});
	
	$(function() { 
		$( "#edate" ).datepicker({minDate:0});
		}); 
	
	$("#ccity").blur(function(){
		field5 = validateCustomerCity($(this).val());
	});
	
	$("#cemail").blur(function(){
		 field6 = validateCustomerEmail($(this).val());
	});
	
	$("#ccontact").blur(function(){
		  field7 = validateCustomerContact($(this).val());
	});
	
	$("#register").on("click",function(){
	submit();
	});
	});

function patterncheck(pattern,checkinput,msg,checkfield)
{var flag=0;
	if(pattern.test(checkinput)==true)
	{
		flag=1;
		checkfield.innerHTML="";	
	}
else
	{	
	flag=0;
		checkfield.innerHTML=msg;
	}
	return flag;
	}

function nullcheck(input,msg,checkfield)
{
	if(input=="")
		{
		checkfield.innerHTML=msg;
		return false;
		}
	else
		{
		checkfield.innerHTML="";
		return true;
		}
	}

function validateCustomerName(name)
{	var flag1 = 0;
	var pattern1=new RegExp("^[a-zA-Z]+[a-z A-Z]*[A-Z a-z]$");
	var msg1="Enter Proper Customer Name";
	var nullmsg1="Enter Customer Name";
	var checkfield1= document.getElementById("c1");
	var custname = name;
	var b1 = nullcheck(custname,nullmsg1,checkfield1);
	if(b1==true)
		{
		flag1 = patterncheck(pattern1,custname,msg1,checkfield1);		
		}
	return flag1;
	}

function validateCustomerAddress(addr)
{ var flag2 = 0;
	var pattern2=new RegExp("^[a-zA-Z0-9]+[a-z A-Z0-9/,]*[A-Z a-z.]$");
	var custadd=addr;
	var msg2="Enter Proper Customer Address";
	var nullmsg2="Enter Customer Address";
	var checkfield2 = document.getElementById("c2");
	var b2 = nullcheck(custadd,nullmsg2,checkfield2);
	if(b2==true)
		{
		flag2 = patterncheck(pattern2,custadd,msg2,checkfield2);		
		}
	return flag2;
	}

function validateCustomerCity(city)
{var flag5=0;
	var pattern5=new RegExp("^[a-zA-Z]+[a-z A-Z]*[A-Z a-z]$");
	var msg5="Enter Proper City";
	var nullmsg5="Enter City";
	var checkfield5= document.getElementById("c5");
	var custcity = city;
	var b5 = nullcheck(custcity,nullmsg5,checkfield5);
	if(b5==true)
		{
		flag5 = patterncheck(pattern5,custcity,msg5,checkfield5);		
		}
	return flag5;
	}

function validateCustomerEmail(email)
{var flag6=0;
	var pattern6=new RegExp("^[a-zA-Z#$*_-]+[@]{1}[a-zA-Z]+[.]{1}([a-zA-Z]+)$");
	var msg6="Enter proper Email id";
	var nullmsg6="Enter Email id";
	var checkfield6= document.getElementById("c6");
	var custemail = email;
	var b6 = nullcheck(custemail,nullmsg6,checkfield6);
	if(b6==true)
		{
		flag6 = patterncheck(pattern6,custemail,msg6,checkfield6);		
		}
	return flag6;
	}

function validateCustomerContact(contact)
{var flag7=0;
	var pattern7=new RegExp("^[0-9]{10}$");
	var msg7="Enter proper Contact No.";
	var nullmsg7="Enter Contact Number";
	var checkfield7= document.getElementById("c7");
	var custcontact = contact;
	var b7 = nullcheck(custcontact,nullmsg7,checkfield7);
	if(b7==true)
		{
		flag7 = patterncheck(pattern7,custcontact,msg7,checkfield7);		
		}
	return flag7;
	}

function validateRadio()
{ var mem=null; 
	if($("input:checked").val()=="Y")
	{
		field3=1;
	$("#edate").show();
	$("#exp").show();
	var ed = $("#edate").val();
	if(ed=="")
		{
		field4=0;
		}
	else
		{
		field4=1;
		}
	document.getElementById("c3").innerHTML="";
	}	
if($("input:checked").val()=="N")
{
	field3=1;
	field4=1;
	$("#edate").hide();
	$("#exp").hide();
	document.getElementById("c3").innerHTML="";
}	
	}

function submit()
{	
       if(field3==1)
		{
    	   document.getElementById("c3").innerHTML="";
		 if(field4==1)
  	   {
			 document.getElementById("c4").innerHTML="";
  	   }
       else
  	   {
    	document.getElementById("c4").innerHTML="Enter Expiry Date";
  	   }
		}
	    else
		{
	    document.getElementById("c3").innerHTML="Enter Membership Details";
	    field4=1;
		}
      
    	   
	if(field1==1 && field2==1 && field3==1 && (field4==1 || field4==0) && field5==1 && field6==1 && field7==1)
		{
		callAjax();		
		}
	
	if(field1==0)
		{
		document.getElementById("c1").innerHTML="Enter Customer name";
		}
	if(field2==0)
		{
		document.getElementById("c2").innerHTML="Enter Customer Address";
		}
	if(field5==0)
		{
		document.getElementById("c5").innerHTML="Enter City";
		}
	if(field6==0)
		{
		document.getElementById("c6").innerHTML="Enter Email id";
		}
	if(field7==0)
		{
		document.getElementById("c7").innerHTML="Enter Contact number";
		}
		
	}

function callAjax()
{
	$.ajax({ 

		url:'CustomerController',

		type:'get',

		data:{cname:$("#cname").val(),caddress:$("#caddress").val(),member:$("input:checked").val(),edate:$("#edate").val(),ccity:$("#ccity").val(),cemail:$("#cemail").val(),ccontact:$("#ccontact").val()},

		success:function(data)

		{
			if(data=="fail")

			{
				location="#error/Customer not added";
			}
			else
			{   
				location="#success/Customer Added Successfully";
			}
		},
		
		error:function(){
			alert("failed");
		} 
		});

}
	
	
	
