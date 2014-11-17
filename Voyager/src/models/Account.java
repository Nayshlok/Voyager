package models;

import java.util.List;

public class Account{
	
	private int UserID;
	
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String avatar;
	
	private Roles role;
	
	private List<String> history;
	
	private List<String> comments;
	
	
	//private Set<AccountRole> roles = new HashSet<>();
	
	public Account(){
		userName = "";
		password = "";
		email = "";
		avatar = "";
		role = Roles.User;
		
	}
	
	public Account(String UserName, String Email, String Avatar,Roles role, String password){
		this.setUsername(UserName);
		this.email = Email;
		this.avatar = Avatar;
		this.role = role;
		this.password = password;

	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getUserID() {
		return UserID;
	}
	
	
	public void setPassword(String pass){
	
		this.password = pass;
	}
	public String getPassword(){
		return this.password;
	}

	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}

	public List<String> getHistory() {
		return history;
	}
	public void setHistory(List<String> history) {
		this.history = history;
	}

	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}

}
