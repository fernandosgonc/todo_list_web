package todo_list_web.model;

import java.time.LocalDate;

public class Task {

	private int id;
	private String name;
	private LocalDate deadline;
	private boolean done; // "status" in DB
	private String category;

	public Task() {

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

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean status) {
		this.done = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", deadline=" + deadline + ", done=" + done + ", category="
				+ category + "]";
	}

}
