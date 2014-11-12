package models;

import java.util.List;

public class Account{
	
	private int UserID;
	
	
	private String username;
	
	private String password;
	
	private String Email;
	
	private String Avatar;
	
	private Roles role;
	
	private List<String> History;
	
	private List<String> Comments;
	
	
	//private Set<AccountRole> roles = new HashSet<>();
	
	public Account(String UserName, String Email, String Avatar,Roles role, String password){
		this.setUsername(UserName);
		this.Email = Email;
		this.Avatar = Avatar;
		this.role = role;
		this.password = password;

	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
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
		return History;
	}
	public void setHistory(List<String> history) {
		History = history;
	}

	public List<String> getComments() {
		return Comments;
	}
	public void setComments(List<String> comments) {
		Comments = comments;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
