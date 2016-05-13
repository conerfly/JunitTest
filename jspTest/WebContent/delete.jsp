<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<% 
		//public void delete(String[] users) {
		String deluser="";
		deluser = request.getParameter("name");
		Context context = null;										//database connection
        DataSource datasource = null;
        Connection connect = null;
        context = new InitialContext();
        datasource = (DataSource) context.lookup("java:/comp/env/jdbc/username");
        connect = datasource.getConnection();
        response.setContentType("text/html");								            //set response 
        PrintWriter output = response.getWriter();
		if(deluser!=null){
			PreparedStatement pstmt = connect.prepareStatement("DELETE FROM username WHERE username= ?");
			pstmt.setString(1, deluser);
		    int result = pstmt.executeUpdate();
		    output.println("Delete user successful!");
		    output.println("<a href='main1.html'>Back</a>");
		}else{
			output.println("Invalid parameter");
		}
			
		/* System.out.print("!!!!!!!!2");
			Context context = null;										//database connection
		    DataSource datasource = null;
		    Connection connect = null;
		    Statement statement = null;
		    context = new InitialContext();
		    datasource = (DataSource) context.lookup("java:/comp/env/jdbc/username");
		    connect = datasource.getConnection();
		    statement = connect.createStatement();
			String query =""; */
		    //response.setContentType("text/html");								            //set response 
			//PrintWriter output = response.getWriter();
		    //System.out.print("!!!!!!!!");
		    /* int j=0;
		    while(users[j]){
		    	if(response.getParameters(users[j])!=null){
		    		query = "DELETE FROM username WHERE username="+users[j]+";";
				    int result = statement.executeUpdate(query);
		    	}
		    	j++;
		    } */
			//query = "DELETE FROM username WHERE username="+users[j]+";";
		    //int result = statement.executeUpdate(query);
		    //output.println("Add user successfully");
		    //return;
	//}
	%>
</body>
</html>