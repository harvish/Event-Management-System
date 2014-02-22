/**
 * 
 */
var tfIdName;
var idName;
var tdIdName;
var counter=1;
$(document).ready(function(){
	loadxml1();
	$("#admore").click(function(){
		selectTdDynamicGenerator();
		selectDynamicIdGenerator();
		tableDynamicGenerator();
		quantityDynamicGenerator();
		counter++;
		$('<tr><td>FACILITY</td><td><select id='+tfIdName+' name="tfIdName" onfocus="loadxml2dy()"  onchange="loadxml2dy()" ></select></td><td>VENDOR ID</td><td><select id='+idName+'  name="vendor_id" onfocus="loadxml3dy()" onchange="loadxml3dy()"></select></td><td>COST</td><td><input type="text" id='+tdIdName+'></td><td>QUANTITY</td><td><input type="text" id='+qIdName+' name="quantity"></td>').appendTo("#dataTable");
		loadxml1dy();
	});
	
	
});
function selectTdDynamicGenerator()
{

tfIdName="select1p";
tfIdName=tfIdName+counter;

}
function selectDynamicIdGenerator()
{
	idName="select2p";
	idName=idName+counter;
}
function tableDynamicGenerator()
{
	tdIdName="select3p";
	tdIdName=tdIdName+counter;
	
}

function quantityDynamicGenerator()
{
	qIdName="select4p";
	qIdName=qIdName+counter;
	
}


function loadxml()
{
$.get("Facility_controller?cid="+$("#customer_id").val(), function(resp){
	var res=resp.split("+");
	s=document.getElementById("select");
	while(s.hasChildNodes())
	{
	s.removeChild(s.lastChild);
	}

	for(var j = 0; j < res.length-1; j++)
	{ 
		var t = document.createElement("option");
		t.value =res[j];
		t.innerHTML =res[j] ;
		s.appendChild(t);
	}  

});
}

function loadxmldy()
{
$.get("Facility_controller?cid="+$("#customer_id").val(), function(resp){
	var res=resp.split("+");
	s=document.getElementById("select");
	while(s.hasChildNodes())
	{
	s.removeChild(s.lastChild);
	}

	for(var j = 0; j < res.length-1; j++)
	{ 
		var t = document.createElement("option");
		t.value =res[j];
		t.innerHTML =res[j] ;
		s.appendChild(t);
	}  

});
}

function loadxml1()
{
$.get("Facilty_type", function(resp){
	var res=resp.split("+");
	s=document.getElementById("select1");
	while(s.hasChildNodes())
	{
	s.removeChild(s.lastChild);
	}

	for(var j = 0; j < res.length-1; j++)
	{ 
		var t = document.createElement("option");
		t.value =res[j];
		t.innerHTML =res[j] ;
		s.appendChild(t);
	}  

});
}

var sel2;
function loadxml1dy()
{	
$.get("Facilty_type", function(resp){
	var res=resp.split("+");
	s=document.getElementById(tfIdName);
	while(s.hasChildNodes())
	{
	s.removeChild(s.lastChild);
	}

	for(var j = 0; j < res.length-1; j++)
	{ 
		var t = document.createElement("option");
		t.value =res[j];
		t.innerHTML =res[j] ;
		s.appendChild(t);
	}  

});

}

function loadxml2()
{
$.get("vendor_id?facility="+$("#select1").val(), function(resp){
	var res=resp.split("+");
	s=document.getElementById("select2");
	while(s.hasChildNodes())
	{
	s.removeChild(s.lastChild);
	}

	for(var j = 0; j < res.length-1; j++)
	{ 
		var t = document.createElement("option");
		t.value =res[j];
		t.innerHTML =res[j] ;
		s.appendChild(t);
	}  

});
}

function loadxml2dy()
{
$.get("vendor_id?facility="+$('#'+tfIdName).val(), function(resp){
	var res=resp.split("+");
	s=document.getElementById(idName);
	while(s.hasChildNodes())
	{
	s.removeChild(s.lastChild);
	}

	for(var j = 0; j < res.length-1; j++)
	{ 
		var t = document.createElement("option");
		t.value =res[j];
		t.innerHTML =res[j] ;
		s.appendChild(t);
	}  

});
}

function loadxml3()
{
$.get("Cost_controller?facility="+$("#select1").val()+"&vendor_id="+$("#select2").val(), function(resp){
	$("#myDiv").val(resp);

});
}


function loadxml3dy()
{
	$.get("Cost_controller?facility="+$('#'+tfIdName).val()+"&vendor_id="+$("#"+idName).val(), function(resp){
	
	$("#"+tdIdName).val(resp);

});
}

function submitthis(){
	$.ajax({
		url:"insertFacility",
		data:$("#formh").serialize(),
		type:"post",
		success: function(resp){
			//alert("success");
			location='#success/Facility Added';
		},
		error: function(){
			// alert("failed");
			location='#error/Facility not Added';
		}
	});
}
