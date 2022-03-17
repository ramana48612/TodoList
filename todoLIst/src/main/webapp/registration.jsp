<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
*{
color:#CFD1D3;
background:#15202B;
}
input{
border-right:none;
}
td{
font-size:20px;
}
</style>
</head>
<body>

<div align="center">
<form action="Register" method="post">

<table >
<tr><td><h1 style="color:#5068C7;">Register</h1></tr>

<tr><td>User Name : </td><td><input type="text" name="name"></td></tr>
<tr><td>Email : </td><td><input type="text" name="email"></td></tr>
<tr><td>phone :  </td><td><input type="number" name="phone"></td></tr>
<tr><td>Password : </td><td><input type="password" name="password"></td></tr>



</table><br>
<input type="submit" id="button" value="Register" style="font-size:20px;border:1px solid skyblue;border-radius:1rem;width:100px;">






<center id="loading" style="display: none;">
<div class="spinner-grow text-primary" role="status">
  <span class="sr-only"></span>
</div>
<div class="spinner-grow text-secondary" role="status">
  <span class="sr-only"></span>
</div>
<div class="spinner-grow text-success" role="status">
  <span class="sr-only"></span>
</div>
<div class="spinner-grow text-danger" role="status">
  <span class="sr-only" ></span>
</div>
</center>
</form>
</div>
<script type="text/javascript">
document.getElementById("button").addEventListener("click",()=>{
	document.getElementById("loading").style.display="block";	
})
</script>
</body>
</html>