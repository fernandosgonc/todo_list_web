package todo_list_web.service.actions;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;

public class EditTaskAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		Integer taskId = Integer.parseInt(req.getParameter("id"));
		String taskName = req.getParameter("name");
		String category = req.getParameter("category");
		
		String txtDeadline = req.getParameter("deadline");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate deadline = LocalDate.parse(txtDeadline, formatter);
		
		char status = req.getParameter("status").charAt(0);
		Integer agendaId = Integer.parseInt(req.getParameter("agenda"));
		
		Task task = new Task();
		task.setId(taskId);
		task.setName(taskName);
		task.setCategory(category);
		task.setDeadline(deadline);
		
		boolean isDone = false;
		if(status == '1') {
			isDone = true;
		}
		task.setDone(isDone);
		
		
		Agenda agenda = new Agenda();
		agenda.setId(agendaId);
		
		
		Connection connection = (Connection) req.getAttribute("connection");
		TaskDAO dao = new TaskDAO(connection);
		dao.update(task, agenda);
		
		return "viewTask?task_id="+taskId;
	}

}
