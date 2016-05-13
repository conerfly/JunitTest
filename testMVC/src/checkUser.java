import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.PreparedStatement;

public class checkUser {
	static Context context = null;										//database connection
    static DataSource datasource = null;
    static Connection connect = null;
    Statement statement = null;
    
	public static ResultSet check(String user, String password, PrintWriter out) throws NamingException, SQLException{
	    context = new InitialContext();
	    datasource = (DataSource) context.lookup("java:/comp/env/jdbc/username");
	    connect = datasource.getConnection();
	    PreparedStatement pstmt = connect.prepareStatement("SELECT password from username where username = ?");
        pstmt.setString(1,user);
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet.next()){
			if(resultSet.getString("password").equals(password)){
				pstmt = connect.prepareStatement("SELECT * FROM username");
				resultSet = pstmt.executeQuery();
				return resultSet;
			}else{
				resultSet = null;
				return resultSet;
			}
        }else{
        	resultSet = null;
        	return resultSet;
        }
	}
}
