<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
			<font size=4 face="Verdana" color=#120292>
				<table cellspacing=5 cellpadding=5 bgcolor=#959999 colspan=2 rowspan=2 align="center">
					<tr>
						<td>Enter username:</td>
						<td><input type=text name="newuname"></td>
					</tr>
					<tr>
						<td>Enter Password: </td>
						<td><input type=password name="newpassword"></td>
					</tr>
				</table>
				<table align="center">
					<tr>
						<td><input type="submit" name="adduser" value="Add" ></td>
						<td><input type="Reset" value=" Cancel " ></td>
					</tr>
				</table>
			</font>
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
					if(request.getParameter("adduser")!=null){
						query = "INSERT INTO username VALUES ('"+user+"','"+pwd+"')";
			            ResultSet resultSet = statement.executeQuery(query);
			            output.println("Add user successfully");
					}
			%>
</body>
</html>