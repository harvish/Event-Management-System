/**
 * 
 */
var facilityCode;
var facilityName;
function dropDownAjax1()
{
	$.ajax({
		url:'FacilityDropDownController',
		method:'GET',
		success:function(data){
			var obj=eval('('+data+')');
			facilityCode=obj[0].facilityCode.split(" ");
			facilityName=obj[0].facilityName.split("/");
			var selectId=document.getElementById("facilityDropDown");
			for(var j = 0; j < facilityCode.length-1; j++)
			 {		var option = document.createElement("option");
					option.value =facilityCode[j];
					option.innerHTML =facilityName[j];
					selectId.appendChild(option);
			   			
				}
			},
		error:function(){
			location='error/Sorry an error occured'
		}
	});
}

$(document).ready(function(){
	dropDownAjax1();
	$("#loader").hide();
	$(window).load(function(){
		("#body").hide();
		("#loader").fadeOut(2000);
		
	});
	
	$("#addMore").click(function(){
		if(addMoreCounterCheck<facilityCode.length-2){
		if(optionChecker())
		{	
		selectRemove();
		selectDynamicIdGenerator();
		tableDynamicGenerator();
		selectTdDynamicGenerator();
	$('<tr  style="border-bottom: thin;"><td>DESCRIPTION</td><td><select id='+idName+' name=facility1 ><option value="">select an option</option></select></td><td>COST</td><td><input type="text" id="cost" name="faciltyCost1"></td></tr>').appendTo("#table");
	$('<tr style="border: hidden; border-left: none; border-right: none;  border-bottom: thin; "><td class="valfields" ></td><td class="valfields"id='+tfIdName+'></td><td  class="valfields"></td><td class="valfields" id='+tdIdName+'></td></tr>').appendTo('#table');
	var selectId=document.getElementById(idName);
	for(var j = 0; j < facilityName.length-1; j++)
	 {
	 if(facilityName[j]!="ns"){
		 var option = document.createElement("option");
		 option.value =facilityCode[j];
		 option.innerHTML =facilityName[j];
		 selectId.appendChild(option);
	   }
	
	 }
	}
		else
			{
			alert("please select an option to proceed");
			}
	}
	else
		{
		alert("you cant add any more fields");
		}
		addMoreCounterCheck++;
});
  $("#submit").click(function(){
	  if(validate())
		{ $("#body").hide(); 
		  $("#loader").show();
		  
	  var fCode;
	  var fName;
	  var fd=document.getElementsByName("faciltyCost1");
	  var fc=document.getElementsByName("facility1");
	  fCode=fd[0].value+" ";
	  for(i=1;i<fd.length;i++)
		  fCode=fCode+fd[i].value+" ";
	  fName=fc[0].value+" ";
	  for(i=1;i<fc.length;i++)
		  fName=fName+fc[i].value+" ";
	 
	
	  $.ajax({
		  url:'VendorFacility',
	      method:'GET',
	      data:{faciltycost1:fCode,facility1:fName},
	      success:function(data){
	       	  if(data=="success")
	    		  {
	       		$("#loader").fadeOut("slow",function()
	    				{
	       			location='home.html#success/All Values Inserted Successfully';
	       			  /*$("#body").load("Success.jsp");*/
	    				$("#body").fadeIn("slow");});
	       		// $("#loader").fadeOut(3000);
	       		 
	    		 
	    		  }
	    	  else{
	    		  //$("#loader").fadeOut(3000);
	    		  $("#body").show();
	    		  $("#body").load("pages/error.jsp");
	    	  		}
	      },
	      error:function(){
	    	  alert("fail");
	    	  $("#body").load("pages/error.jsp");
	      }
	  
	  });
		}
	});
  $("#reset").click(function(){
	  $("#body1").load("AddFacilityDup.jsp"); 
  });
});
var addMoreCounterCheck=0;
var counter=0;
var idName;
var tdIdName;
var tfIdName;
function selectTdDynamicGenerator()
{

tfIdName="sd";
tfIdName=tfIdName+counter;

}
function selectDynamicIdGenerator()
{
	idName="facilityDropDown";
	idName=idName+counter;
	counter++;
	
}
function tableDynamicGenerator()
{
	tdIdName="td";
	tdIdName=tdIdName+counter;
	
}

function validate()
{
var fd=document.getElementsByName("faciltycost1");
var fc=document.getElementsByName("facility1");
var flag=0;
var flag2=0;

for(i=0;i<fd.length;i++)
{	
	if(fd[i].value==""|| isNaN(fd[i].value) )
		{
		flag++;
		var j=i;
		var id="td"+""+j;
		$('#'+id).text("*please enter a number");
		}
	
}

for(i=0;i<fc.length;i++)
{	
	if(fc[i].value=="")
		{
		flag2++;
		var id="sd"+""+i;
		$('#'+id).text("*select an option");
		}
}
if(flag>0)
	{
	return false;
	}
else
	{
		if(flag2==0)
			{
			return true;
			}
		else
			{
			return false;
			}
					
	}
}
function optionChecker()
{
var fc=document.getElementsByName("facility1");
var flag=0;
for(i=0;i<fc.length;i++)
{	
	if(fc[i].value=="")
		{
		flag++;
		}
}
if(flag>0)
	{
	return false;
	}
else
	{
	return true;					
	}
}
function selectRemove()
{
	var selector=document.getElementsByTagName("select");
	for(i=0;i<selector.length;i++)
		{
		for(j=0;j<facilityName.length;j++)
			{
			if(facilityCode[j]==(selector[i].value))
				facilityName[j]="ns";
			}
		}
}