package todo_list_web.factory;


import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionFactoryTest {

	Connection con = null;
	@Test
	public void openConection() throws SQLException {
		
		try {
		con = ConnectionFactory.getConnection();
		if(con!=null) {
			System.out.println("Connected.........");
		}
		}catch(SQLException e) {
			
			throw new RuntimeException();
		}
		
		finally {
			if(con!=null) {
				con.close();
			}
			System.out.println("Connection closed........");
		}
		
	}
	

}
