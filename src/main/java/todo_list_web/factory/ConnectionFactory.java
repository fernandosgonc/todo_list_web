package todo_list_web.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static final String url = "jdbc:mysql://localhost/todo_listdb";
	private static final String user = "root";
	private static final String password = "9959";
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException {
		if(connection == null || connection.isClosed()) {
			try {

				connection = DriverManager.getConnection(url, user, password);
				
				
			}catch(SQLException e) {
				throw new RuntimeException();
			}
			

		}
		return connection;
	}
	


}
