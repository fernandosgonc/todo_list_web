package todo_list_web.service.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	
	private static Map<String, Action> map = new HashMap<String, Action>();
	
	static {
		System.out.println("Map chamado");
		map.put("GET/home", new HomeAction());
		map.put("GET/signin", new LoginAction());
		map.put("GET/signout", new SignOutAction());
		map.put("GET/agendas", new ListAgendasAction());
		map.put("GET/deleteAgenda", new DeleteAgendaAction());
		map.put("GET/edit", new PrepareEditAction());
		map.put("GET/viewAgenda", new ViewAgendaAction());
		map.put("GET/delete", new DeleteTaskAction());
		map.put("GET/viewTask", new RetriveTaskAction());
		map.put("GET/allTasks", new RetrieveAllTasksAction());
		
		map.put("POST/createAgenda", new CreateAgendaAction());
		map.put("POST/editAgenda", new EditAgendaAction());
		map.put("POST/signin", new LoginAction());
		map.put("POST/signup", new SignUpAction());
		map.put("POST/editTask", new EditTaskAction());
		map.put("POST/addTask", new AddTaskAction());
		
		
		
	}
	
	public static Action getAction(HttpServletRequest req) {
		return map.get(req.getMethod()+req.getPathInfo());
	}

}
