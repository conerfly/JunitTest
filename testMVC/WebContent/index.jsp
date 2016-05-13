<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<form name="f1" action="check" method="get">
		<font size=4 face="Verdana" color=#120292> <br> <br>
			<table cellspacing=5 cellpadding=5 bgcolor=#959999 colspan=2
				rowspan=2 align="center">
				<tr>
					<td>Login</td>
				</tr>
				<tr>
					<td>Enter username:</td>
					<td><input type=text name="uname"></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><input type=password name="password"></td>
				</tr>
			</table> <br>
			<table align="center">
				<tr>
					<td><input type="submit" value=" Enter "></td>
					<td><input type="Reset" value=" Cancel "></td>
				</tr>
			</table>
		</font>
	</form>
</body>
</html>