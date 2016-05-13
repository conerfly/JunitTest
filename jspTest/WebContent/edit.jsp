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
	<form method="post">
		<font size=4 face="Verdana" color=#120292> <br> <br>
			<table cellspacing=5 cellpadding=5 bgcolor=#959999 colspan=2
				rowspan=2 align="center">
				<tr>
					<td>Enter new username:</td>
					<td><input type=text name="newuname"></td>
				</tr>
				<!-- <tr>
						<td>Enter old Password: </td>
						<td><input type=password name="oldpassword"></td>
					</tr>
					<tr>
						<td>Enter new Password: </td>
						<td><input type=password name="newpassword"></td>
					</tr> -->
			</table> <br>
			<table align="center">
				<tr>
					<td><input type="submit" value="Submit"></td>
					<td><input type="Reset" value="Cancel"></td>
				</tr>
			</table>
		</font>
	</form>
	<% 
			String olduser="";
			olduser = request.getParameter("name");
			Context context = null;										//database connection
	        DataSource datasource = null;
	        Connection connect = null;
	        context = new InitialContext();
	        datasource = (DataSource) context.lookup("java:/comp/env/jdbc/username");
	        connect = datasource.getConnection();
	        response.setContentType("text/html");
	        String newuser=request.getParameter("newuname");							//insert username into database;
	        //String oldpwd=request.getParameter("oldpassword");
			//String newpwd=request.getParameter("newpassword");	
			PreparedStatement pstmt = connect.prepareStatement("update username set username = ? where username = ?");
			//PreparedStatement pstmt2 = connect.prepareStatement("");
			//PreparedStatement pstmt3 = connect.prepareStatement("update username set password = ? where password = ?");
			pstmt.setString(1, newuser);
			pstmt.setString(2, olduser);
			if(newuser!=null){
				int result = pstmt.executeUpdate();
			}
        %>
</body>
</html>