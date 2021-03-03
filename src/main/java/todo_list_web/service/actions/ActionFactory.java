package todo_list_web.service.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
	
	private static Map<String, Action> map = new HashMap<String, Action>();
	
	static {
		System.out.println("Map chamado");
		map.put("GET/home", new HomeAction());
		map.put("POST/signin", new LoginAction());
		map.put("GET/signout", new SignOutAction());
		map.put("GET/agendas", new ListAgendasAction());
		map.put("POST/createAgenda", new CreateAgendaAction());
		map.put("GET/deleteAgenda", new DeleteAgendaAction());
		map.put("GET/edit", new PrepareEditAction());
		map.put("POST/editAgenda", new EditAgendaAction());
		map.put("GET/open", new OpenAgendaAction());
		map.put("POST/editTask", new EditTaskAction());
		map.put("GET/delete", new DeleteTaskAction());
		map.put("POST/addTask", new AddTaskAction());
		map.put("GET/viewTask", new RetriveTaskAction());
		
		
	}
	
	public static Action getAction(HttpServletRequest req) {
		return map.get(req.getMethod()+req.getPathInfo());
	}

}
