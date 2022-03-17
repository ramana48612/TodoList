package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javaFile.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Logger log=Logger.getLogger(Login.class);
		 String log4jConfPath = "/home/venkat-zstk269/eclipse-workspaceUpdated/todoLIst/src/main/java/log4j.properties";
	        PropertyConfigurator.configure(log4jConfPath);
	        
	        
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUserid(userid);
		loginBean.setPassword(password);
		
		LoginDao loginDao = new LoginDao();

		try {
			
			if(loginDao.validate(loginBean)) {
				HttpSession session=request.getSession();
				session.setAttribute("Name", userid);
				Cookie cookie = new Cookie("Status", "true");
				cookie.setMaxAge(12*60*60);
				response.addCookie(cookie);
				
				
				Cookie cookie1 = new Cookie("userid", userid);
				cookie1.setMaxAge(12*60*60);
				response.addCookie(cookie1);
				
				response.sendRedirect("index.jsp");
			}else {
				
			        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			        Date date = new Date();  
         	        log.info(formatter.format(date)+" - Wrong user ID  or Passwurd (login unsuccessfull)");
			        
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
		
		        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		        Date date = new Date();   
		        log.error(formatter.format(date)+" ERROR (LoginDao- checking id and password)");
		    
		}
		
		
	}

}
