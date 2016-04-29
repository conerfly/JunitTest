<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="com.mysql.jdbc.PreparedStatement" %>

<html>
	<body>
		<font face ="verdana">
			<%
				Context context = null;										//database connection
		        DataSource datasource = null;
		        Connection connect = null;
		        Statement statement = null;
		        context = new InitialContext();
	            datasource = (DataSource) context.lookup("java:/comp/env/jdbc/username");
	            connect = datasource.getConnection();
	            statement = connect.createStatement();

	            response.setContentType("text/html");								            //set response 

		        PrintWriter output = response.getWriter();
		        
		        String query = "";												//insert username into database;
				String user=request.getParameter("uname");
				String pwd=request.getParameter("password");
				query = "SELECT password from username where username = '"+user+"'";
	            ResultSet resultSet = statement.executeQuery(query);	           
			%>
			<%
				if(resultSet.next()){
					if(resultSet.getString("password").equals(pwd)){
						query = "SELECT * FROM username";
						resultSet = statement.executeQuery(query);
			%>
			<table cellspacing=5 cellpadding=5 bgcolor=#959999 colspan=2 rowspan=2 align='center'>
			<% 
						// why cannot write table outside java section?
						//output.println("<table cellspacing=5 cellpadding=5 bgcolor=#959999 colspan=2 rowspan=2 align='center'>");
						while (resultSet.next()) {
			                String username = resultSet.getString("username");
			                output.println("<tr><td> User: " + username + "</td></tr>");
			            }
						//output.println("</table>");
						output.println("<form action='Add.jsp'>");
						output.println("<br><input type='submit' value='Add' align='center'>");
						output.println("</form>");
			%>    
			</table>        
			<%
					}else{
						output.println("Incorrect password");
					}	
				}else{
					output.println("Incorrect username <br>");
				}
			%>
		</font>
	</body>
</html>