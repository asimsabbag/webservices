package com.qait.newbook;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;

@Path("login")
public class Login {
	

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response login(@FormParam("email") String email,@FormParam("password") String password) throws URISyntaxException{
		try{  
			System.out.println("In this ");
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/newbook","root","start"); 
    		System.out.println("connection set");
    		Statement stmt=con.createStatement();  
    		ResultSet rs=stmt.executeQuery("select password from userdata where email like '"+email+"'");  
    		System.out.println("Paassed");
    		while(rs.next())  
    		{
			    
    			if(rs.getString(1).equals(password))
    			{
    				System.out.println("connected....");
    				URI location = new URI("http://localhost:8090/newbook/home.html");
    		    	return Response.seeOther(location).build(); 
    			}	
    		}
    		con.close();}  
    		catch(Exception e){
    			System.out.println("What happen");
    			}  
		URI location = new URI("http://localhost:8090/newbook/login.html");
	    return Response.seeOther(location).build();
		    		
    	}
	

}

