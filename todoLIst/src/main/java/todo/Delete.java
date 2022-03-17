package todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.Register;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger log=Logger.getLogger(Delete.class);
		 String log4jConfPath = "/home/venkat-zstk269/eclipse-workspaceUpdated/todoLIst/src/main/java/log4j.properties";
	        PropertyConfigurator.configure(log4jConfPath);
		
		JFrame  f=new JFrame();   
	    String id=JOptionPane.showInputDialog(f,"Enter the ID : ");   
	    
	   
	
	    
	    PrintWriter out = response.getWriter();
	    
		try {
			
			if(id==null) {
				response.sendRedirect("index.jsp");
			}
			
			int id1 = Integer.parseInt(id);
			if(Database.deleteData(id1)) {
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
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
