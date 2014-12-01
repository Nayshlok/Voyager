package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@NamedQueries({
	@NamedQuery(name="byUsername", query="SELECT u FROM Account u WHERE u.username = :username"),
	@NamedQuery(name="allUsers", query="SELECT u FROM Account u")
})

@Entity
@Table(name="AccountTable", uniqueConstraints=@UniqueConstraint(columnNames={"username"}))
public class Account{
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
		
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column
	private String avatar;
	
	@Enumerated
	@Column
	private Roles role;
	
	@Transient
	private Set<String> history;
	
	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy="user")
	private Set<CommentModel> comments;

	public Account(){
		username = "";
		password = "";
		email = "";
		avatar = "";
		role = Roles.User;
		history = new HashSet<>();
		comments = new HashSet<>();
	}
	
	public Account(String UserName, String Email, String Avatar,Roles role, String password){
		this.setUsername(UserName);
		this.email = Email;
		this.avatar = Avatar;
		this.role = role;
		this.password = password;
		this.history = new HashSet<>();
		this.comments = new HashSet<>();
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
		return userId;
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

	public Set<String> getHistory() {
		return history;
	}
	public void setHistory(Set<String> history) {
		this.history = history;
	}

	public Set<CommentModel> getComments() {
		return comments;
	}
	public void setComments(Set<CommentModel> comments) {
		this.comments = comments;
	}
	public void addComment(CommentModel comment){
		this.comments.add(comment);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
