package todo_list_web.dao;


import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import todo_list_web.model.Agenda;
import todo_list_web.model.User;

public class AgendaDAOTest {

	@Test
	public void testCreate() {
		
		Agenda a = new Agenda();
		User u = new User();
		u.setId(10);
		a.setName("Teste4");
		
		AgendaDAO adao = new AgendaDAO();
		try {
			adao.create(a, u);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();		
		}
		
	}
	

	
//	@Test
	public void testDelete() {
		
		int id = 5;
		AgendaDAO dao = new AgendaDAO();
		try {
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	
//	@Test
	public void testEdit() {
		Agenda ag = new Agenda();
		ag.setName("Test");
		ag.setId(8);
		
		AgendaDAO dao = new AgendaDAO();
		try {
			dao.edit(ag);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
//	@Test
	public void testRetriveAll() {
		
		User u = new User();
		u.setId(10);
		
		try {
			List<Agenda> list = new AgendaDAO().retrieveAll(u);
			
			for(Agenda a : list) {
				System.out.println(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	
//	@Test
	public void testRetrieve() {
		
	
		
		try {
			Agenda a = new AgendaDAO().retrieve(8);
			
				System.out.println(a);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

}
