package todo_list_web.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.model.User;

public class Interactor {

	private static AgendaDAO agendaDao = null;
	private static TaskDAO taskDao = null;

	public static void createAgenda(String agendaName, User owner) throws SQLException {

		Agenda a = new Agenda();
		a.setName(agendaName);
		agendaDao = new AgendaDAO();
		agendaDao.create(a, owner);

	}
	
	public static void updateAgenda(Integer agendaId, String agendaName) throws SQLException {
		Agenda a = new Agenda();
		a.setId(agendaId);
		a.setName(agendaName);
		agendaDao = new AgendaDAO();
		agendaDao.edit(a);

	}
	
	
	public static void deleteAgenda(Integer agendaId) throws SQLException {
		agendaDao = new AgendaDAO();
		agendaDao.delete(agendaId);
	}

	public static List<Agenda> getUserAgendas(User owner) throws SQLException {
		agendaDao = new AgendaDAO();
		return agendaDao.retrieveAll(owner);

	}

	public static Agenda getAgenda(Integer agendaId) throws SQLException {
		agendaDao = new AgendaDAO();
		return agendaDao.retrieve(agendaId);
	}
	
	
	
	public static void addTask(String name, String category, String deadline, String status, String agendaId) throws SQLException {
		Task task = new Task();
		task.setName(name);
		task.setCategory(category);
		
		LocalDate parsed = LocalDate.parse(deadline, DateTimeFormatter.ISO_LOCAL_DATE);
		task.setDeadline(parsed);
		
		boolean condition = false;
		if(status.charAt(0) == '1') {
			condition = true;
		}
		task.setDone(condition);
		
		Integer id = Integer.parseInt(agendaId);
		Agenda agenda = new Agenda();
		agenda.setId(id);
		
		taskDao= new TaskDAO();
		taskDao.add(task, agenda);
		
	}

	public static List<Task> getAgendaTasks(Agenda agenda) throws SQLException {
		taskDao = new TaskDAO();
		return taskDao.retrieveAllFromAgenda(agenda);
	}
	
	public static List<Task> getAllTasks(User user) throws SQLException {
		taskDao = new TaskDAO();
		return taskDao.retrieveAllFromUser(user);
	}

	public static Task getTask(Integer taskId) throws SQLException {
		taskDao = new TaskDAO();
		return taskDao.retrieve(taskId);
	}
	
	public static void updateTask(Integer id, String name, String category, String deadline, String status, String agenda) throws SQLException {
		Task task = new Task();
		task.setId(id);
		task.setName(name);
		task.setCategory(category);
		
		LocalDate parsed = LocalDate.parse(deadline, DateTimeFormatter.ISO_LOCAL_DATE);
		task.setDeadline(parsed);
		
		boolean condition = false;
		if(status.charAt(0) == '1') {
			condition = true;
		}
		task.setDone(condition);
		
		Integer agendaId = Integer.parseInt(agenda);
		
		Agenda ag = new Agenda();
		ag.setId(agendaId);
		taskDao= new TaskDAO();
		taskDao.update(task, ag);
		
	}

	
	public static void deleteTask(Integer taskId) throws SQLException {
		
		taskDao = new TaskDAO();
		taskDao.delete(taskId);
	}
	
	public static Agenda getTaskAgenda(Integer taskId) throws SQLException {
		
		Task t = new Task();
		t.setId(taskId);
		taskDao = new TaskDAO();
		Agenda agenda = taskDao.retrieveAgendaRelatedToTask(t);
		return agenda;
	}
	
	

}
