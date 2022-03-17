<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
color:#CFD1D3;
background:#15202B;

}

td,th,table{
border:1px solid grey;
border-collapse: collapse;
font-size:20px;
}


input,textarea{
border:none;
}



</style>
</head>
<body>

    <div align="center">
<h1 style="color:#5068C7;">Create Task</h1>
<form action="CreateTask" method="post">
<table>
  <tr><td >Notes : </td><td><textarea type="text" name="notes" placeholder="type here.." style="width:250px;text-align:center;" > </textarea></td></tr>
  <tr><td>Start Date : </td><td><input type="date" name="startdate" style="text-align:center;"></td></tr>
   <tr><td>Due on : </td><td><input type="date" name="dueon"  style="text-align:center;"></td></tr>
  
   <tr><td>Remainder : </td><td><input type="date" name="remainder"  style="text-align:center;"></td></tr>
  
 
 
  
 </table><br>
  <input type="submit" value="Create" style="font-size:20px;border:1px solid skyblue;border-radius:1rem;width:100px;">
</form>
</div>
    

</body>
</html>