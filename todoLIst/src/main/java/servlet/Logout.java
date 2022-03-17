package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Logout() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     Cookie ck=new Cookie("Status","");  
	         ck.setMaxAge(0);  
	         response.addCookie(ck);  
	            
	         Cookie cookie1 = new Cookie("userid", "");
			 cookie1.setMaxAge(0);
			 response.addCookie(cookie1);
			
			 Cookie cookie2 = new Cookie("idForEdit", "");
			 cookie2.setMaxAge(0);
			 response.addCookie(cookie2);
				
			
	         response.sendRedirect("index.jsp");
		
		
	}



}
