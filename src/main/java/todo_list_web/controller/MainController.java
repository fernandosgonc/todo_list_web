package todo_list_web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo_list_web.service.actions.Action;
import todo_list_web.service.actions.ActionFactory;

@WebServlet("/mvc/*")
public class MainController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DENTRO DO DOGET");
		System.out.println(req.getMethod() + req.getPathInfo());

		
		Action action = ActionFactory.getAction(req);
		System.out.println("ACTION: " + action);

		try {
			String page = action.execute(req, resp);
			System.out.println("Page: " + page);

			
			if (page.equals(req.getPathInfo().substring(1))) {
				System.out.println("req dispat");
	            req.getRequestDispatcher("/WEB-INF/" + page + ".jsp").forward(req, resp);
	        }
	        else {
	        	System.out.println("redirect");
	            resp.sendRedirect(page);
	        }


		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma exececao", e);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("DENTRO DO DOPOST");
		System.out.println(req.getMethod() + req.getPathInfo());

		Action action = ActionFactory.getAction(req);
		System.out.println("ACTION: " + action);

		try {
			String page = action.execute(req, resp);
			System.out.println("Page: " + page);

				resp.sendRedirect(page);

		} catch (Exception e) {
			throw new ServletException("A logica de negocios causou uma exececao", e);
		}

	}

}
