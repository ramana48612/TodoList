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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class EditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditTask() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger log=Logger.getLogger(EditTask.class);
		 String log4jConfPath = "/home/venkat-zstk269/eclipse-workspaceUpdated/todoLIst/src/main/java/log4j.properties";
	        PropertyConfigurator.configure(log4jConfPath);
	        
//		System.out.println("checking"+id);
		Cookie ck[] = request.getCookies();
		
		String id = "";
		for(Cookie cookie : ck ){
			
			if("idForEdit".equals(cookie.getName())){
				
				id = cookie.getValue();
			}
		}
		
	  
		PrintWriter out = response.getWriter();
		String notes = request.getParameter("notes");
		String startDate = request.getParameter("startdate");
		String dueOn = request.getParameter("dueon");
		String remainder = request.getParameter("remainder");

		
		int id1 = Integer.parseInt(id);
		try {
			if(Database.editTask(id1,notes,startDate,dueOn,remainder)) {
				response.sendRedirect("index.jsp");
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
		        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		        Date date = new Date(0);  
		        
		        
		        log.error(formatter.format(date)+" ERROR (Delete  - while deleting data (id is not found))  : ");
		    
			   out.println("<script type=\"text/javascript\">");
		       out.println("alert('Please give Correct Number...');");
		       out.println("window.location.href=\"index.jsp\"");
		       out.println("</script>");
		}
	    
		
	     
	}

}
