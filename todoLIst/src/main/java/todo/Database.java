package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Database {
	
	public static boolean addData(String id, String notes, String startDate, String dueon, String remainder) throws Exception {
		
		
		
		 Class.forName("com.mysql.cj.jdbc.Driver");	    
			
	     Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","");
	     
	     PreparedStatement ps = con.prepareStatement("insert into lists(id,notes,startDate,dueOn,RemainderDate) values(?,?,?,?,?)");
	     
	     ps.setString(1, id);
		    ps.setString(2, notes);		
		    ps.setString(3, startDate);	
		    ps.setString(4, dueon);
		    ps.setString(5, remainder);
		    
		  boolean bool = ( ps.executeUpdate()==1);
		  con.close();
		  
		  return bool;
		
	  
		
	}

	public static boolean deleteData(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");	    
		
	     con= DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","");
	     
	    
		
	     PreparedStatement ps = con.prepareStatement("delete from lists where generatedId = "+id);
	     
	    if( ps.executeUpdate()==1) {
	    	return true;
	    }
	     
		}catch (Exception e) {
	
			System.out.println("error........");
			return false;
		}finally {
			con.close();
		}
		return false;
		
	}

	public static boolean editTask(int id, String notes, String startDate, String dueOn, String remainder) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");	    
		
	     con= DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","");
	     
	     PreparedStatement ps = con.prepareStatement("update lists set notes =?, startDate = ?, dueOn = ?, RemainderDate = ? where generatedId = ?");
	     ps.setString(1, notes);
	     ps.setString(2, startDate);
	     ps.setString(3, dueOn);
	     ps.setString(4, remainder);
	     ps.setInt(5, id);
	     if( ps.executeUpdate()==1) {    	 
		    	return true;
		    } 
		     
			}catch (Exception e) {
		 
				System.out.println("error........");
				return false;
			}finally {
				con.close();
			}
		
			return false;
			
			
	}
	
	
	

}
