package todo_list_web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import todo_list_web.model.Agenda;
import todo_list_web.model.User;

public class AgendaDAO {

	Connection con;

	public AgendaDAO(Connection con) {
		this.con = con;
	}

	public void create(Agenda agenda, User owner) throws SQLException {

		String sql = "insert into agenda (agenda_name, creation_date, user_id) values (?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, agenda.getName());
		ps.setObject(2, agenda.getCreationDate());
		ps.setInt(3, owner.getId());

		int rows = ps.executeUpdate();
		System.out.println(rows + " rows affected");

		if (ps != null) {
			ps.close();
		}
	}

	public void edit(Agenda agenda) throws SQLException {

		String sql = "update agenda set agenda_name =? where agenda_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, agenda.getName());
		ps.setInt(2, agenda.getId());

		int rows = ps.executeUpdate();
		System.out.println(rows + " rows affected");

		if (ps != null) {
			ps.close();
		}

	}

	public void delete(int agendaId) throws SQLException {

		String sql = "delete from agenda where agenda_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, agendaId);

		int rows = ps.executeUpdate();
		System.out.println(rows + " rows affected");

		if (ps != null) {
			ps.close();
		}
	}

	public Agenda retrieve(Integer id) throws SQLException {

		String sql = "select *  from agenda where agenda_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		Agenda agenda = null;
		while (rs.next()) {
			agenda = new Agenda();
			agenda.setId(rs.getInt("agenda_id"));
			agenda.setName(rs.getString("agenda_name"));
			agenda.setCreationDate(rs.getObject("creation_date", LocalDate.class));

		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return agenda;
	}

	public List<Agenda> retrieveAll(User owner) throws SQLException {

		String sql = "select a.agenda_id, a.agenda_name, a.creation_date from agenda a join user u on a.user_id = u.user_id where u.user_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, owner.getId());

		ResultSet rs = ps.executeQuery();

		List<Agenda> agendasList = new ArrayList<>();
		while (rs.next()) {
			Agenda agenda = new Agenda();
			agenda.setId(rs.getInt("agenda_id"));
			agenda.setName(rs.getString("agenda_name"));
			LocalDate creationDate = rs.getObject("creation_date", LocalDate.class);
			agenda.setCreationDate(creationDate);

			agendasList.add(agenda);
		}

		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return agendasList;
	}

}
