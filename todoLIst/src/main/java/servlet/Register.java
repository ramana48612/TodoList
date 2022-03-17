package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaFile.DatabaseSignin;
import javaFile.LoginDao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger log=Logger.getLogger(Register.class);
		 String log4jConfPath = "/home/venkat-zstk269/eclipse-workspaceUpdated/todoLIst/src/main/java/log4j.properties";
	        PropertyConfigurator.configure(log4jConfPath);
		
		String name = request.getParameter("name"); 
		String email = request.getParameter("email"); 
		String phone = request.getParameter("phone"); 
		String password = request.getParameter("password"); 
		
		HttpSession session=request.getSession();  
        session.setAttribute("name",name);
        session.setAttribute("email",email);
        session.setAttribute("phone",phone);
        session.setAttribute("password",password);
		
		
		try {
			
			
			   Random random = new Random();
				String	 OTP =  String.valueOf(random.nextInt(899999)+100000);
				session.setAttribute("OTP",OTP);
				
				
				String msg = "yoursg OTP is "+OTP;
	
				DatabaseSignin.sendMail(email,msg);
				
				response.sendRedirect("otp.jsp");

				
		    
		} catch (Exception e) {

		        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		        Date date = new Date();  	        
		        log.error(formatter.format(date)+" ERROR (Register data- insertinng datas into database)  : ");
		    
		}
		
		
	}

}
