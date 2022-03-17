package todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.Register;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateTask() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger log=Logger.getLogger(Register.class);
		 String log4jConfPath = "/home/venkat-zstk269/eclipse-workspaceUpdated/todoLIst/src/main/java/log4j.properties";
	        PropertyConfigurator.configure(log4jConfPath);
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	        Date date = new Date(0); 
	        
	        
	String notes =	request.getParameter("notes");
	String startDate = request.getParameter("startdate");
	String dueon = request.getParameter("dueon");
	String remainder = request.getParameter("remainder");
	
	String currentStringDateString = String.valueOf(java.time.LocalDate.now());
	if(startDate.equals(""))
		startDate = currentStringDateString;
	if(dueon.equals(""))
		dueon = currentStringDateString;
	if(remainder.equals(""))
		remainder = dueon;
	
	Cookie ck[] = request.getCookies();
	
	String id = "";
	for(Cookie cookie : ck ){
	
		if("userid".equals(cookie.getName())){
			
			id = cookie.getValue();
		}
	}

	
	
	try {
		
		if(Database.addData(id,notes,startDate,dueon,remainder)) {
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("database problem....");
		}
	} catch (Exception e) {        
	        log.error(formatter.format(date)+" ERROR (Create task - insertinng datas into database)  : ");	    
		
	}
	
	
	
	}
}
