package todo_list_web.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String name;
	private String email;
	private String login;
	private String password;
	private char gender;
	private String salt;
	private List<Agenda> agendasList;

	public User() {
		this.agendasList = new ArrayList<Agenda>();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<Agenda> getAgendasList() {
		return agendasList;
	}

	public void setAgendasList(List<Agenda> agendasList) {
		this.agendasList = agendasList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", login=" + login + ", password=" + password
				+ ", gender=" + gender + ", salt=" + salt + "]";
	}

}
