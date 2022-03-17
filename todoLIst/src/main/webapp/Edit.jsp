<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.sql.Connection"
    import="java.sql.DriverManager"
    import = "java.sql.PreparedStatement"
    import ="java.sql.ResultSet"
    import ="javax.swing.JFrame"
import ="javax.swing.JOptionPane"
import ="jakarta.servlet.http.Cookie"
 %>
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


<%

JFrame  f=new JFrame();   
String id=JOptionPane.showInputDialog(f,"Enter ID No : ");     




Class.forName("com.mysql.cj.jdbc.Driver");	    

Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","");

PreparedStatement ps = con.prepareStatement("select notes,startDate,dueOn,RemainderDate from lists where generatedId = ?");

ps.setString(1,id);
ResultSet rs =   ps.executeQuery();

String notes="";
String startDate="";
String dueOn="";
String RemainderDate="";

boolean present = false; 

while(rs.next()){

 notes= rs.getString(1);
 startDate= rs.getString(2);
  dueOn= rs.getString(3);
 RemainderDate= rs.getString(4);
  
 present = true;

}




%>

<%if(present){ 
	Cookie ck=new Cookie("idForEdit",id);//creating cookie object  
	response.addCookie(ck);%>	
	
    <div align="center">
<h1 style="color:#5068C7;">Edit Task</h1>
<form action="EditTask" method="post">
<table>
  <tr><td>Notes : </td><td><textarea type="text" name="notes"> <%= notes %>  </textarea></td></tr>
  <tr><td>Start Date : </td><td><input type="date" name="startdate" value="<%= startDate %>"></td></tr>
   <tr><td>Due on : </td><td><input type="date" name="dueon"  value="<%= dueOn %>"></td></tr>
  
   <tr><td>Remainder : </td><td><input type="date" name="remainder"  value="<%= RemainderDate %>"></td></tr>
  
  
  
 </table><br>
  <input type="submit" value="Submit" style="font-size:20px;border:1px solid skyblue;border-radius:1rem;width:100px;">
</form>
</div>

<%}
else if(id==null){%>
  <script>
	
  window.location.href="index.jsp";
	
	</script>

	
<% }
else{  %>
	
	<script>
	alert("Please give correct ID Number..!");
	
	window.location.href="index.jsp";
	</script>
	
	
  <% }%>


</body>
</html>