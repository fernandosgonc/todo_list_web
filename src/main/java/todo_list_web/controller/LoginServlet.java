package todo_list_web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo_list_web.model.User;
import todo_list_web.service.LoginValidator;

@WebServlet(urlPatterns = { "/home", "/login" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("homepage.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("username");
		String password = req.getParameter("password");

		if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {

			try {

				User user = LoginValidator.authenticate(login, password);
				if (user != null) {
					
					HttpSession session = req.getSession();
					session.setAttribute("loggedUser", user);

					resp.sendRedirect("agendas");
//					RequestDispatcher rd = req.getRequestDispatcher("agendas");
//					rd.forward(req, resp);
					
				} else {
					resp.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			resp.sendRedirect("login.jsp");
		}

	}

}
