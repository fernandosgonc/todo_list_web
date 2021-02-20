package todo_list_web.service;

import java.sql.SQLException;
import java.util.List;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.model.User;

public class Interactor {

	private static AgendaDAO agendaDao = null;
	private static TaskDAO taskDao = null;

	public void createAgenda(String agendaName, User owner) throws SQLException {

		Agenda a = new Agenda();
		a.setName(agendaName);
		agendaDao = new AgendaDAO();
		agendaDao.create(a, owner);

	}

	public static List<Agenda> getUserAgendas(User owner) throws SQLException {
		agendaDao = new AgendaDAO();
		return agendaDao.retrieveAll(owner);

	}

	public static Agenda getAgenda(Integer agendaId) throws SQLException {
		agendaDao = new AgendaDAO();
		return agendaDao.retrieve(agendaId);
	}

	public static List<Task> getAgendaTasks(Agenda agenda) throws SQLException {
		taskDao = new TaskDAO();
		return taskDao.retrieveAllFromAgenda(agenda);
	}
	
	public static List<Task> getAllTasks(User user) throws SQLException {
		taskDao = new TaskDAO();
		return taskDao.retrieveAllFromUser(user);
	}

	public Task getTask(Integer taskId) throws SQLException {
		taskDao = new TaskDAO();
		return taskDao.retrieve(taskId);
	}

//	public static void main(String[] args) {
//		User u = new User();
//		u.setId(10);
//		try {
//			List<Agenda> a = Interactor.getUserAgendas(u);
//			for(Agenda ag : a) {
//				System.out.println(ag);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
