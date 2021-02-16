package todo_list_web.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Agenda {

	private int id;
	private String name;
	private LocalDate creationDate;
	private List<Task> tasksList;

	public Agenda() {
		this.creationDate = LocalDate.now();
		this.tasksList = new ArrayList<Task>();
	}

	public List<Task> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<Task> tasksList) {
		this.tasksList = tasksList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", name=" + name + ", creationDate=" + creationDate + "]";
	}

}
