package todo_list_web.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import todo_list_web.factory.ConnectionFactory;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;

public class TaskDAOTest {

//	@Test
	public void test() {

		Agenda a = new Agenda();
		a.setId(6);
		Task t = new Task();
		t.setName("Task2000");
		t.setDeadline(LocalDate.now().plusDays(3));
		t.setCategory("SouTop");
		t.setDone(false);
		try {
			Connection connection = ConnectionFactory.getConnection();
			TaskDAO dao = new TaskDAO(connection);
			dao.add(t, a);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

//	@Test
	public void retrieveTest() {
		int id = 11;

		try {
			Connection connection = ConnectionFactory.getConnection();

			TaskDAO dao = new TaskDAO(connection);
			Task t = dao.retrieve(id);
			System.out.println(t);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

//	@Test
	public void retrieveAllTest() {

		Agenda a = new Agenda();
		a.setId(6);
		try {
			Connection connection = ConnectionFactory.getConnection();
			List<Task> list = new TaskDAO(connection).retrieveAllFromAgenda(a);

			for (Task t : list) {
				System.out.println(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

//	@Test
	public void editTest() {

		Task t = new Task();
		t.setId(6);
		t.setName("Edited");
		t.setDeadline(LocalDate.now().plusDays(10));
		t.setCategory("Edit");
		t.setDone(false);

		Agenda a = new Agenda();
		a.setId(9);
		try {
			Connection connection = ConnectionFactory.getConnection();
			TaskDAO dao = new TaskDAO(connection);
			dao.update(t, a);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Test
	public void editStatusTest() {

		Task t = new Task();
		t.setId(11);
		t.setDone(true);

		try {
			Connection connection = ConnectionFactory.getConnection();
			TaskDAO dao = new TaskDAO(connection);
			dao.editStatus(t);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

//	@Test
	public void deleteTest() {

		int id = 10;
		try {
			Connection connection = ConnectionFactory.getConnection();
			TaskDAO dao = new TaskDAO(connection);
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
