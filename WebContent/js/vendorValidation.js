/**
 * 
 */
$(document).ready(function(){
	$(window).load(function(){
		("#body").hide();
		("#loader").fadeOut(2000);
		
	});
	$("#addMoreFacility").hide();
	$("#loader").hide();
	$("#Success").hide();
	$("#vendorName").blur(function(){
		vendorNameValidation();
		});
	$("#vendorAddress").blur(function(){
		vendorAddressValidation();
		});
	$("#vendorCity").blur(function(){
		vendorCityValidation();
		});
	$("#vendorEmail").blur(function(){
		vendorEmailValidation();
		});
	$("#vendorContact").blur(function(){
		
		vendorContactValidation();
		});
	$("#register").click(function(){
		
		if(vendorRegisterValidation())
			{
				$("#body").hide();
				$("#loader").show();
				$.ajax({
				url:'VendorController',
				type:'GET',
				data:{vendorName:$("#vendorName").val(),
					  vendorAddress:$("#vendorAddress").val(),
					  vendorCity:$("#vendorCity").val(),
					  vendorEmail:$("#vendorEmail").val(),
					  vendorContact:$("#vendorContact").val()},
				success:function(data){
					if(data=="fail")
						{
						
						alert(data);
						 $("#body").load("error.jsp");
						}
					else
						{
						$("#form2").hide();
						alert(data);
						
						
						$("#loader").fadeOut("slow",function(){
							$("#Success").fadeIn("slow");
							//$("#body").show();		
						});
										
						}
				},
				error:function(){
					alert("fail in ajax fail");
				}	
			});
			$("#addMoreFacility").show();
		}
		});
	$("#addMoreFacility").click(function(){
		//alert("hi");
		$("#Success").hide();
		$("#loader").show();
		$("#body").hide();
		$("#loader").fadeOut(2000,function()
			{
			//	alert("hi");
				$("#body").load("pages/AddFacilityDup.jsp");
				$("#body").fadeIn("slow");
			});
		
		//window.location="AddFacilityDup.jsp";
	});
	$("#reset1").click(function()
	{
		
		nullFunction(document.getElementById("vendorCheck"));
		nullFunction(document.getElementById("addressCheck"));
		nullFunction(document.getElementById("cityCheck"));
		nullFunction(document.getElementById("emailCheck"));
		nullFunction(document.getElementById("contactCheck"));
		
	}
	);
});
function nullFunction(tag)
{
	tag.innerHTML="";
}
function nullCheck(value,tag)
{
	if(value==null || value=='')
		{
		tag.innerHTML="*above field is empty";
		return false;
		}
	else
	return true;
}
function namePatternCheck(value)
{

	var regex1=/[@#$%^&*(){}<,>.?""''\-[]|]/;
    var regex=/[a-z A-Z]{1,30}$/;
    var regex2=/[0-9][\s]/;
    if(regex.test(value)&&!regex1.test(value)&&!regex2.test(value) )
		{
    	return true;
    	
		}
    	else
	return false;
}
function addressPatternCheck(value)
{
	var regex1=/[@#$%^&*() {}<,>.?""''\-[]|]/;
    var regex=/([a-z A-Z]{1,30})||([0-9]{1,30})$/;
    if(regex.test(value)&&!regex1.test(value) )
		return true;
	else
	return false;
}
function cityPatternCheck(value)
{

	var regex1=/[@#$%^&*(){} <,>.?""''\-[]|]/;
    var regex=/[a-z A-Z]{1,30}$/;
    var regex2=/[0-9]/;
    if(regex.test(value)&&!regex1.test(value)&&!regex2.test(value) )
		{
    	return true;
    	
		}
    	else
	return false;
}
function contactPatternCheck(value)
{
	var regex1=/[@#$%^&*(){} <,>.?""''\-[]|]/;
    var regex=/[a-z A-Z]{1,30}$/;
    var regex2=/[0-9]/;
    if(regex2.test(value)&&!regex1.test(value)&&!regex.test(value) && value.length==10 )
		{
    	return true;
    	}
    	else
	return false;
}
function emailPatternCheck(value)
{
	var regex=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(regex.test(value))
		return true;
	else
		return false;
}
function vendorNameValidation()
{
	var labCheck=document.getElementById("vendorCheck");
	nullFunction(labCheck);
	if(nullCheck($("#vendorName").val(),labCheck))
	{
		if(namePatternCheck($("#vendorName").val()))
		{
		return true;
		}
	else
		{
		labCheck.innerHTML="*can contain only alphabets";
		return false;
		}
	}
	else
		{
		return false;
		}
}
function vendorAddressValidation()
{
	var labCheck=document.getElementById("addressCheck");
	nullFunction(labCheck);
	if(nullCheck($("#vendorAddress").val(),labCheck))
	{
		if(addressPatternCheck($("#vendorAddress").val()))
		{
			return true;
		}
		else
		{
			labCheck.innerHTML="*can contain only alphabets and letters";
			return false;
		}
	}
}
function vendorCityValidation()
{
	var labCheck=document.getElementById("cityCheck");
	nullFunction(labCheck);
	if(nullCheck($("#vendorCity").val(),labCheck))
		{
			if(cityPatternCheck($("#vendorCity").val()))
			{
				return true;
			}
			else
			{
				labCheck.innerHTML="*can contain only alphabets";
				return false;
			}
		}
}
function vendorEmailValidation()
{
	var labCheck=document.getElementById("emailCheck");
	nullFunction(labCheck);
	if(nullCheck($("#vendorEmail").val(),labCheck))
		{
		if(emailPatternCheck($("#vendorEmail").val()))
		{
		return true;
		}
	else
		{
		labCheck.innerHTML="*enter a valid email";
		return false;
		}
		}
}
function vendorContactValidation()
{
	var labCheck=document.getElementById("contactCheck");
	nullFunction(labCheck);
	if(nullCheck($("#vendorContact").val(),labCheck))
		{
		if(contactPatternCheck($("#vendorContact").val()))
			{
			return true;
			}
		else
			{
			labCheck.innerHTML="*can contain only numbers and length should be 10";
			return false;
			}
		}
}
function vendorRegisterValidation()
{
	var name=vendorNameValidation();
	var add=vendorAddressValidation();
	var city=vendorCityValidation();
	var contact=vendorContactValidation();
	var email=vendorEmailValidation();
	if(name && add && city && contact && email)
		return true;
	else
		return false;
}
