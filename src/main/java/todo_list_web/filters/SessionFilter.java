package todo_list_web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo_list_web.model.User;

@WebFilter(urlPatterns = {"/mvc/agendas", "/mvc/allTasks", "/mvc/viewAgenda", "/mvc/viewTask"})
public class SessionFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
		System.out.println("Init Session Filter");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		User currentUser = (User) session.getAttribute("loggedUser");
		
		if(currentUser!=null) {
			chain.doFilter(request, response);
		}else{
			session.setAttribute("msg", "You're not logged in");
			((HttpServletResponse)response).sendRedirect("../signin.jsp");
		}
		
		
	}

	@Override
	public void destroy() {
		
		System.out.println("Destroy Session Filter");
		
	}

}
