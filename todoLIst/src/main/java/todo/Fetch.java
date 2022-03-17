package todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;


public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Fetch() {
        super();
       
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		
String t1 = request.getParameter("t1");
		
		PrintWriter out = response.getWriter();
		List<JSONObject> j1;
		try {
		 	j1=fetch(response,t1);
			
			
			out.write(j1.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			JSONObject j2=new JSONObject();
			j2.put("status", "failed");
			out.flush();
			out.close();
			out.write(j2.toJSONString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

	private List<JSONObject> fetch(HttpServletResponse response, String t1) throws Exception {
List<JSONObject> ljs = new ArrayList();
     
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");	    

		@SuppressWarnings("unchecked")
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","");

		PreparedStatement ps = con.prepareStatement("select notes,startDate,dueOn,RemainderDate,generatedId from lists where id = ?");

		ps.setString(1,t1);
		ResultSet rs =   ps.executeQuery();

         while(rs.next()) {
        	  JSONObject jo = new JSONObject();
        	 jo.put("gid",rs.getString(5) );
        	 jo.put("notes",rs.getString(1) );
        	 jo.put("startdate",rs.getString(2) );
        	 jo.put("dueon",rs.getString(3) );
        	 jo.put("remainder",rs.getString(4) );
        	 
        	 ljs.add(jo);
         }

		
		return ljs;
	}

}
