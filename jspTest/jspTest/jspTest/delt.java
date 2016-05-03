package jspTest;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import com.mysql.jdbc.Statement;

public class delt{

	public void delete(String name) throws NamingException, SQLException{
		Context context = null;										//database connection
        DataSource datasource = null;
        Connection connect = null;
        java.sql.Statement statement = null;
        context = new InitialContext();
        datasource = (DataSource) context.lookup("java:/comp/env/jdbc/username");
        connect = datasource.getConnection();
        statement = connect.createStatement();
        String query = "";
        //response.setContentType("text/html");								            //set response 
		//PrintWriter output = response.getWriter();
		query = "DELETE FROM username WHERE username="+name+";";
        int result = statement.executeUpdate(query);
        //output.println("Add user successfully");
	}
}
