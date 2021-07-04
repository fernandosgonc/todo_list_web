package todo_list_web.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static final String url = "jdbc:mysql://localhost/todo_listdb";
	private static final String user = "root";
	private static final String password = "6370";
	
	private static Connection connection = null;
	
	@SuppressWarnings("deprecation")
	public static Connection getConnection() throws SQLException {
		if(connection == null || connection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connection = DriverManager.getConnection(url, user, password);
				
				
			}catch(SQLException e) {
				e.printStackTrace();
				throw new RuntimeException();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		return connection;
	}
	


}
