package com.qait.newbook;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("signup")
public class Signup {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response signup(@FormParam("name") String name,@FormParam("email") String email, @FormParam("password") String password) throws URISyntaxException{
		try{  
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/newbook","root","start");  
    		  System.out.println("Connection set");
    		PreparedStatement ps=con.prepareStatement("insert into userdata values(?,?,?)");  
    		
    		ps.setString(1,email);  
    		ps.setString(2,password);  
    		ps.setString(3,name);
    		
    		ps.executeUpdate();
    		
    		System.out.println("Registered");
    		con.close();  
    		}catch(Exception e){ System.out.println(e);}  
    		  
    	URI location = new URI("http://localhost:8090/newbook/index.html");
    	return Response.seeOther(location).build(); 
    	}
	
	
	
	

}
