package todo_list_web.service.actions;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.dao.AgendaDAO;
import todo_list_web.dao.TaskDAO;
import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.model.User;

public class RetrieveAllTasksAction implements Action {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException, Exception {
		
		User currentUser = (User) req.getSession().getAttribute("loggedUser");
		
		Connection connection = (Connection) req.getAttribute("connection");
		List<Task> allTasks = new TaskDAO(connection).retrieveAllFromUser(currentUser);
		
		List<Agenda> allAgendas = new AgendaDAO(connection).retrieveAll(currentUser);
		
			req.setAttribute("allTasks", allTasks);
			req.setAttribute("allAgendas", allAgendas);
			req.setAttribute("error", "You don't have any tasks");
		
		return "allTasks";
		
		
	}

}
