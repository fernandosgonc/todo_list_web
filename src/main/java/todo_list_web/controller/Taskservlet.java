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

@WebServlet(urlPatterns = { "/tasks", "/allTasks","/addTask", "/edit", "/delete", "/update"})
public class TaskServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String URI = req.getRequestURI();
		
		if(URI.contains("/allTasks")) {
			getAllTaks(req, resp);
		}else if(URI.contains("/edit")) {
			prepareUpdate(req, resp);
		}
		else if(URI.contains("/tasks")) {
			getAgendaTasks(req, resp);
		}else if(URI.contains("/delete")) {
			delete(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().contains("/update")) {
			update(req, resp);
		}else if(req.getRequestURI().contains("/addTask")) {
			addTask(req, resp);
		}
		
	}
	
	public void addTask(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String deadline = req.getParameter("deadline");
		String status = req.getParameter("status");
		String agendaId = req.getParameter("agendaId");
		try {
			
			Interactor.addTask(name, category, deadline, status, agendaId);
			resp.sendRedirect("allTasks");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getAgendaTasks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer agendaId = Integer.parseInt(req.getParameter("agenda_id"));
		
			try {
				Agenda a = Interactor.getAgenda(agendaId);
				List<Task> tasksList = Interactor.getAgendaTasks(a);
				req.setAttribute("agenda", a);
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
				List<Agenda> agendas = Interactor.getUserAgendas(user);
				req.setAttribute("allTasks", allTasks);
				req.setAttribute("allAgendas", agendas);
				RequestDispatcher rd = req.getRequestDispatcher("restrict/allTasks.jsp");
				rd.forward(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}else {
			resp.sendRedirect("login");
		}
		
	}
	
	
	

	public void prepareUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer taskId = Integer.parseInt(req.getParameter("task_id"));
		
		try {
			Task t = Interactor.getTask(taskId);
			User user = (User)req.getSession().getAttribute("loggedUser");
			List<Agenda> listAgendas = Interactor.getUserAgendas(user);
			Agenda agenda = Interactor.getTaskAgenda(taskId);
			
			req.setAttribute("task", t);
			req.setAttribute("agenda", agenda);
			req.setAttribute("allAgendas", listAgendas);
			
			RequestDispatcher rd = req.getRequestDispatcher("restrict/editTask.jsp");
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String category = req.getParameter("category");
		String deadline = req.getParameter("deadline");
		String status = req.getParameter("status");
		String agenda = req.getParameter("agenda");

		try {
			Interactor.updateTask(id, name, category, deadline, status, agenda);
			resp.sendRedirect("allTasks");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer taskId = Integer.parseInt(req.getParameter("task_id"));
		
		try {
			Interactor.deleteTask(taskId);
			resp.sendRedirect("allTasks");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
