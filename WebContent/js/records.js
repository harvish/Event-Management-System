/**
 * 
 */


var obj1;

function printt(){
	window.print();
}

function printDiv() {
    var printContents = document.getElementById("div").innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}




/*$(document).ready(function() {   
	$("#from").datepicker ({maxDate: "+0D",dateFormat:"yy/mm/dd"});
	count=0;

	$("#from" ).change(function(){	
	count++;
	if(count>0){
		$("#to").datepicker('destroy');
		$("#to").val("");
	}
	var dateTypeVar = $('#from').datepicker('getDate');
	dateString = $.datepicker.formatDate('yy/mm/dd',dateTypeVar);
	$("#to").datepicker({ maxDate: "0D", minDate: dateString,dateFormat:"yy/mm/dd" });
	});*/
	
/*});*/

function gett()
{
	/*if($("#div").text()!="")
		{
		$("#div").text("NO RECORDS FOUND");
		
		}*/

	

	if($("#from").val()=="" || $("#to").val()=="")
	{
	
	var t=document.getElementById("td1");
	t.innerHTML="<span class=\"error\">*Enter both the date values</span>";
	}
	
	
	else{
		var t=document.getElementById("td1");
		t.innerText="";
	
	
	
	
	$.getJSON("ReportsController?sess="+new Date().getTime()+"&from="+$("#from").val()+"&to="+$("#to").val(),function(obj){
	
	obj1=obj;
	
	
	if(obj.table.length==0)
	{
	$("#div").html("<h3 style=\"color:red\" align=\"center\">SORRY, NO RECORDS WERE FOUND</h3>");

	}
	
	else{
	
	var key, count = 0;
	for(key in obj.table) {
	  if(obj.table.hasOwnProperty(key)) {
	    count++;
	  }
	}
	
	//alert(count);
	

	var grandtotal=0;
	
	for(var i =0;i<count ;i++)
		{if(obj.table[i].totalamount!="" || obj.table[i].totalamount!=null)
		grandtotal=grandtotal+parseFloat(obj.table[i].totalamount);		
		}
	
	
	
	
	var x="<table class=\"table\"  style=\"background-color: aliceblue\"  border=\"3px\" id=\"tab\"><tr><th>EVENT ID</th><th>DATE</th><th>EVENT NAME</th><th>VENUE NAME</th><th>TOTAL AMOUNT</th></tr>";
	for ( var i = 0; i < count; i++) {
		x=x+"<tr><td>"+obj.table[i].eventid+"</td><td>"+obj.table[i].date+"</td><td>"+obj.table[i].eventname+"</td><td>"+obj.table[i].venuename+"</td><td>"+obj.table[i].totalamount+"</td></tr>" ;                                           
	}
	x=x+"<tr><td></td><td></td><td></td><td>GRANDTOTAL</td><td>"+grandtotal+"</td></tr></table>";

	
	$("#div").html(x);
/*document.writeln(obj.table[0].eventid+" "+obj.table[0].date);*/
	
	}	

});


}}




function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
    //If JSONData is not an object then JSON.parse will parse the JSON string in an Object
    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
    
    var CSV = '';    
    //Set Report title in first row or line
    
    CSV += ReportTitle + '\r\n\n';

    //This condition will generate the Label/Header
    if (ShowLabel) {
        var row = "";
        
        //This loop will extract the label from 1st index of on array
        for (var index in arrData[0]) {
            
            //Now convert each value to string and comma-seprated
            row += index + ',';
        }

        row = row.slice(0, -1);
        
        //append Label row with line break
        CSV += row + '\r\n';
    }
    
    //1st loop is to extract each row
    for (var i = 0; i < arrData.length; i++) {
        var row = "";
        
        //2nd loop will extract each column and convert it in string comma-seprated
        for (var index in arrData[i]) {
            row += '"' + arrData[i][index] + '",';
        }

        row.slice(0, row.length - 1);
        
        //add a line break after each row
        CSV += row + '\r\n';
    }
      CSV+='\r\n,,,"Grand Total","=sum(E4:E'+(3+arrData.length)+')"\r\n';
    if (CSV == '') {        
        alert("Invalid data");
        return;
    }   
    
    //Generate a file name
    var fileName = "MyReport_";
    //this will remove the blank-spaces from the title and replace it with an underscore
    fileName += ReportTitle.replace(/ /g,"_");   
    
    //Initialize file format you want csv or xls
    var uri = 'data:text/csv;charset=utf-8,' + escape(CSV);
    
    // Now the little tricky part.
    // you can use either>> window.open(uri);
    // but this will not work in some browsers
    // or you will not get the correct file extension    
    
    //this trick will generate a temp <a /> tag
    var link = document.createElement("a");    
    link.href = uri;
    
    //set the visibility hidden so it will not effect on your web-layout
    link.style = "visibility:hidden";
    link.download = fileName + ".csv";
    
    //this part will append the anchor tag and remove it after automatic click
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
}




