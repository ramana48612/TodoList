<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.Connection"
    import="java.sql.DriverManager"
    import = "java.sql.PreparedStatement"
    import ="java.sql.ResultSet" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<style type="text/css">
*{
color:#CFD1D3;
background:#15202B;
}

td,th,table{
text-align:center;
border:1px solid grey;
border-collapse: collapse;
padding:10px;

}
th{
font-size:23px;
}
td{
font-size:19px;
}


a{
margin-right:20px;
text-decoration:none;
font-size:20px;
color:#4DA1FF;
}



</style>
</head>
<body>

<%

Cookie ck[] = request.getCookies();
boolean state = false;
String userid = "";
for(Cookie cookie : ck ){
	if("Status".equals(cookie.getName())&& "true".equals(cookie.getValue())){
		state = true;
		
	}
	if("userid".equals(cookie.getName())){
		
		userid = cookie.getValue();
	}
}

 if(!state){
	 response.sendRedirect("login.jsp");
 }
 
 

%>


 <h1>User	 ID : <%=userid%></h1> 


<div align="center">
<a href="CreateTask.jsp">Create Task  </a> 
<a href="Edit.jsp">Edit</a>
<a href="Delete">Delete</a>
<a href="Logout" > Logout</a><br><br><br>

</div>





<table align="center" class="table table-striped" id="myTable">
 <!--  <thead>
    <tr >
        <th style="width:100px;">gid</th>
        <th style="width:350px;">notes</th>
        <th style="width:150px;text-align:center;">startdate</th>
        <th style="width:150px;text-align:center;">dueon</th>
        <th style="width:150px;text-align:center;">remainder</th>
    </tr>
</thead>  
   <tbody >
        
    </tbody>-->
</table>



<script >
  
 let result="";
 
 
 
 window.addEventListener('DOMContentLoaded',async()=>{
	    var datas=await fetch("http://localhost:8081/todoLIst/hello?t1="+<%= userid%>,{method:"POST"});
	    result=await datas.json();
	    console.log(result)
	   
	      buildTable(result)	 	    
	 })
 
  
	 
	 
	 	
	


		function buildTable(data){
	 var files = data;
     $(document).ready(function() {
         var table = $('<table/>').appendTo($('#myTable'));
         
         $('<tr/>').appendTo(table)
         .append($('<th style="width:100px;"/>').text("gid"))
         .append($('<th style="width:350px;"/>').text("notes"))
         .append($('<th style="width:150px;text-align:center;"/>').text("startdate"))
         .append($('<th style="width:150px;text-align:center;"/>').text("dueon"))
         .append($('<th style="width:150px;text-align:center;"/>').text("remainder"));
         
     
         
         $(files).each(function(i, file) {
        	 
             $('<tr/>').appendTo(table)
                 .append($('<td/>').text(file.gid))
                 .append($('<td/>').text(file.notes))
                 .append($('<td/>').text(file.startdate))
                 .append($('<td/>').text(file.dueon))
                 .append($('<td/>').text(file.remainder));
             
         });
         
     });
         }

			
  </script>




</body>
</html>