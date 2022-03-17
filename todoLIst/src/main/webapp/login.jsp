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

input{
border-right:none;
border-top:none;
border-left:none;
}
td{
font-size:20px;
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

<div align="center">
<h1 style="color:#5068C7;">UserLogin</h1>
<form action="Login" method="post">
<table>
  <tr><td>User ID : </td><td><input type="text" name="userid" autocomplete="off"></td></tr>
  <tr><td>Password : </td><td><input type="password" name="password"></td></tr>
         
   
 
  
 </table><br>
<input type="submit" value="login" style="font-size:18px;color:lightgreen">  you don't have a account  <input type="submit" formaction="registration.jsp" value="Register" style="font-size:18px;color:yellow;">
</form>
</div>

</body>
</html>