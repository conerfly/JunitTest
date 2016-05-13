<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>
<html>
<body>
	<font face="verdana"> <%
				Context context = null;										//database connection
		        DataSource datasource = null;
		        Connection connect = null;
		        Statement statement = null;
		        context = new InitialContext();
	            datasource = (DataSource) context.lookup("java:/comp/env/jdbc/username");
	            connect = datasource.getConnection();
	            response.setContentType("text/html");								            //set response 
		        PrintWriter output = response.getWriter();		        
				String user=request.getParameter("uname");										
				String pwd=request.getParameter("password");	
				PreparedStatement pstmt = connect.prepareStatement("SELECT password from username where username = ?");
	            pstmt.setString(1,user);
	            ResultSet resultSet = pstmt.executeQuery();	           
			%> <%
				if(resultSet.next()){
					if(resultSet.getString("password").equals(pwd)){
						//query = "SELECT * FROM username";
						pstmt = connect.prepareStatement("SELECT * FROM username");
						resultSet = pstmt.executeQuery();
			%> <% 			
						//why cannot write table outside java section?
						output.println("<table cellspacing=5 cellpadding=5 bgcolor=#959999 colspan=2 rowspan=2 align='center'>");
						while (resultSet.next()) {
			                String username = resultSet.getString("username");                     
			                output.println("<tr><td> User: " + username + " <a href='edit.jsp?name="+username+"'>Edit</a> <a href='delete.jsp?name="+username+"'>Delete</a></td></tr>");
						}
						output.println("</table>");
						output.println("<br><a href='Add.jsp'>Add</a>");
			%> <%
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