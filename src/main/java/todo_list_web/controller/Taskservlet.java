package todo_list_web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.model.Agenda;
import todo_list_web.model.Task;
import todo_list_web.model.User;
import todo_list_web.service.Interactor;

@WebServlet(urlPatterns = { "/tasks", "/allTasks"})
public class Taskservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String URI = req.getRequestURI();
		
		if(URI.endsWith("/allTasks")) {
			getAllTaks(req, resp);
		}else {
			Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
			getAgendaTasks(agendaId, req, resp);
		}
		
	}
	
	public void getAgendaTasks(Integer agendaId, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
			try {
				Agenda a = Interactor.getAgenda(agendaId);
				List<Task> tasksList = Interactor.getAgendaTasks(a);
				req.setAttribute("tasks", tasksList);
				RequestDispatcher rd = req.getRequestDispatcher("restrict/listatasks.jsp");
				rd.forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		

	}
	
	public void getAllTaks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User)req.getSession().getAttribute("loggedUser");
		
		if(user!=null) {
			
			try {
				List<Task> allTasks = Interactor.getAllTasks(user);
				req.setAttribute("allTasks", allTasks);
				RequestDispatcher rd = req.getRequestDispatcher("restrict/allTasks.jsp");
				rd.forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}else {
			resp.sendRedirect("login");
		}
		
	}
}
