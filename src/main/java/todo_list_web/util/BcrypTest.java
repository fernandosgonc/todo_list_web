package todo_list_web.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import todo_list_web.dao.UserDAO;
import todo_list_web.factory.ConnectionFactory;

public class BcrypTest {
	
	public static void main(String[] args) {
		
		
		System.out.println(BCrypt.gensalt() + BCrypt.gensalt().length());
		System.out.println(BCrypt.gensalt() + BCrypt.gensalt().length());
		System.out.println(BCrypt.gensalt() + BCrypt.gensalt().length());
		
		
//		String senha1 = "senha3";
//		String senha2 = "senha1";
//		String sal = BCrypt.gensalt();
//		
//		String h1 = BCrypt.hashpw(senha1, sal);
//		String h2 = BCrypt.hashpw(senha2, sal);
//		System.out.println(BCrypt.checkpw(senha1, h2));
		
////		String user = "fernadosgonc";
//		String psw = "1always2";
////		String salt = "";
////		
////		
////		String hashpsw = BCrypt.hashpw(psw, salt);
////		
////		try {
////			put(user, hashpsw, salt);
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
//		
//		
////		
////		try {
////			salt = get();
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
//		
////		String hashpsw = BCrypt.hashpw(psw, salt);
//		String h = "$2a$10$ZrehPJq7X.eTNXE66ZXqF.H6s9DbLjEfqhKKkK/cq8UFoOpvxqXsC";
//		if(BCrypt.checkpw(psw, h)) {
//			System.out.println("equal");
////			System.out.println(BCrypt.hashpw(psw, salt).equals("$2a$10$ZrehPJq7X.eTNXE66ZXqF.H6s9DbLjEfqhKKkK/cq8UFoOpvxqXsC"));
//		}else {
//			System.out.println("diff");
//		}
//		
	}
	

	
	
	public static void put(String user, String psw, String salt ) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		
		
		String sql = "insert into hashing (username, psw, salt) values (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, psw);
		ps.setString(3, salt);
		ps.execute();
		ps.close();
		con.close();
	}
	
	public static String get() throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		
		
		String sql = "select salt, psw from hashing";
		PreparedStatement ps = con.prepareStatement(sql);
		String salt = "";
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			salt = rs.getString("salt");
		}
		
		ps.execute();
		ps.close();
		con.close();
		return salt;
	}
}
