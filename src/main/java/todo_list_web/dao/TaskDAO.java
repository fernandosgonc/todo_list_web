package todo_list_web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import todo_list_web.factory.ConnectionFactory;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.model.User;

public class TaskDAO {

	private Connection con = null;

	public void add(Task task, Agenda agenda) throws SQLException {

		con = ConnectionFactory.getConnection();
		String sql = "insert into task (task_name, deadline, status, category, agenda_id) values (?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, task.getName());
		ps.setObject(2, task.getDeadline());
		ps.setBoolean(3, task.isDone());
		ps.setString(4, task.getCategory());
		ps.setInt(5, agenda.getId());

		int rows = ps.executeUpdate();
		System.out.println(rows + " affected");

		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}
	}

	public Task retrieve(Integer id) throws SQLException {

		con = ConnectionFactory.getConnection();

		String sql = "select * from task where task_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		Task t = null;
		while (rs.next()) {
			t = new Task();
			t.setId(rs.getInt("task_id"));
			t.setName(rs.getString("task_name"));
			t.setCategory(rs.getString("category"));
			t.setDeadline(rs.getObject("deadline", LocalDate.class));
			t.setDone(rs.getBoolean("status"));
		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}

		return t;

	}

	public List<Task> retrieveAllFromAgenda(Agenda agenda) throws SQLException {

		con = ConnectionFactory.getConnection();

		String sql = "select t.task_id, t.task_name, t.deadline, t.category, t.status from task t join agenda a on t.agenda_id = a.agenda_id where a.agenda_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, agenda.getId());

		ResultSet rs = ps.executeQuery();

		List<Task> list = new ArrayList<Task>();
		Task t = null;
		while (rs.next()) {
			t = new Task();
			t.setId(rs.getInt("task_id"));
			t.setName(rs.getString("task_name"));
			t.setDeadline(rs.getObject("deadline", LocalDate.class));
			t.setCategory(rs.getString("category"));
			t.setDone(rs.getBoolean("status"));
			list.add(t);
		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}

		return list;

	}
	
	public List<Task> retrieveAllFromUser(User owner) throws SQLException {

		con = ConnectionFactory.getConnection();

		String sql = "select t.task_id, t.task_name, t.category, t.deadline, t.status from task t join agenda a on t.agenda_id = a.agenda_id join user u on a.user_id = u.user_id where u.user_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, owner.getId());

		ResultSet rs = ps.executeQuery();

		List<Task> list = new ArrayList<Task>();
		Task t = null;
		while (rs.next()) {
			t = new Task();
			t.setId(rs.getInt("task_id"));
			t.setName(rs.getString("task_name"));
			t.setCategory(rs.getString("category"));
			t.setDeadline(rs.getObject("deadline", LocalDate.class));
			t.setDone(rs.getBoolean("status"));
			list.add(t);
		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}

		return list;

	}

	
public Agenda retrieveAgendaRelatedToTask(Task task) throws SQLException {
	con = ConnectionFactory.getConnection();

	String sql = "select a.agenda_id, a.agenda_name from agenda a join task t on t.agenda_id = a.agenda_id where t.task_id=?";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setInt(1, task.getId());

	ResultSet rs = ps.executeQuery();

	Agenda agenda = null;
	if(rs.next()) {
		agenda = new Agenda();
		agenda.setId(rs.getInt("agenda_id"));
		agenda.setName(rs.getString("agenda_name"));
	}
	

	if (rs != null) {
		rs.close();
	}
	if (ps != null) {
		ps.close();
	}
	if (con != null) {
		con.close();
	}

	return agenda;
}
	
	public void update(Task task, Agenda newAgenda) throws SQLException {

		con = ConnectionFactory.getConnection();

		String sql = "update task set task_name=?, category=?, deadline=?, status=?, agenda_id=? where task_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, task.getName());
		ps.setString(2, task.getCategory());
		ps.setObject(3, task.getDeadline());
		ps.setBoolean(4, task.isDone());
		ps.setInt(5, newAgenda.getId());
		ps.setInt(6, task.getId());

		int rows = ps.executeUpdate();
		System.out.println(rows+" affected");

		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}

	}
	
	
	public void editStatus(Task task) throws SQLException {
		
		con = ConnectionFactory.getConnection();

		String sql = "update task set status=? where task_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		boolean done = false;
		if(!task.isDone()) {
			done=true;
		}
		ps.setBoolean(1, done);
		ps.setInt(2, task.getId());
		
		int rows = ps.executeUpdate();
		System.out.println(rows+" affected");

		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}

	}
	
	
	public void delete(Integer id) throws SQLException {

		con = ConnectionFactory.getConnection();

		String sql = "delete from task where task_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		int rows = ps.executeUpdate();
		System.out.println(rows+" affected");

		if (ps != null) {
			ps.close();
		}
		if (con != null) {
			con.close();
		}

	}
	
}
