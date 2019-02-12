package com.qait.newbook;
import java.sql.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("comment")
public class Comment {
	
	@POST
	@Path("addcomment")
	@Produces(MediaType.TEXT_PLAIN)
	public Response AddComment(@FormParam("comment") String comment,@FormParam("email") String email) throws URISyntaxException{
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/newbook","root","start");  
    		  
    		PreparedStatement ps=con.prepareStatement("insert into usercomment values(?,?)");  
    		
    		ps.setString(1,comment);  
    		ps.setString(2,email );
    		
    		ps.executeUpdate();
    		
    		System.out.println("Comment Added");
    		con.close();  
    		}catch(Exception e){ System.out.println(e);}  
    		  
    	URI location = new URI("http://localhost:8090/newbook/home.html");
    	return Response.seeOther(location).build(); 

}
	@GET
    @Path("getallcomments")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllComments() throws URISyntaxException {
    	String output = "";
    	try{  
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/newbook","root","root");  
    		Statement stmt=con.createStatement();  
    		ResultSet rs=stmt.executeQuery("select fname,comment from information");
    		
    		JSONArray json = new JSONArray();
    		ResultSetMetaData rsmd = rs.getMetaData();
    		while(rs.next()) {
    		  int numColumns = rsmd.getColumnCount();
    		  JSONObject obj = new JSONObject();
    		  for (int i=1; i<=numColumns; i++) {
    		    String column_name = rsmd.getColumnName(i);
    		    obj.put(column_name, rs.getObject(column_name));
    		  }
    		  json.put(obj);
    		}
    		con.close();
    		return Response.status(200).entity(json).build();	
    		}
    	catch(Exception e){ System.out.println(e);
    	}
    	URI location = new URI("http://localhost:8080/newbook/home.html");
    	return Response.seeOther(location).build(); 
    	}
}
