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

@WebServlet(urlPatterns = { "/home", "/login", "/signup", "/signout" })
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String URI = req.getRequestURI();
		
		if (URI.endsWith("/home")) {
			resp.sendRedirect("homepage.jsp");
			
		} else if (URI.endsWith("/login")) {
			resp.sendRedirect("login.jsp");
			
		} else if (URI.endsWith("/signup")) {
			resp.sendRedirect("signup.jsp");
			
		}else if (URI.endsWith("/signout")) {
			resp.sendRedirect("signout.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String URI = req.getRequestURI();
		
		if (URI.endsWith("/login")) {
			login(req, resp);
		} else if (URI.endsWith("/signup")) {
			signup(req, resp);
		}
		
	}

	public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String login = req.getParameter("username");
		String password = req.getParameter("password");

		if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {

			try {

				User user = LoginValidator.authenticate(login, password);
				if (user != null) {

					HttpSession session = req.getSession();
					session.setAttribute("loggedUser", user);

					resp.sendRedirect("agendas");

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

	public void signup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String login = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");

		try {
			LoginValidator.register(name, email, login, password, gender.charAt(0));
			
			//log in after registration
			req.setAttribute("login", login);
			req.setAttribute("password", password);
			RequestDispatcher rd = req.getRequestDispatcher("login");
			rd.forward(req, resp);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
