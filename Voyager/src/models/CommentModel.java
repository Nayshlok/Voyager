package models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CommentTable")
public class CommentModel 
{
	
	@Id
	@Column
	@GeneratedValue(generator="fingerSequence", strategy=GenerationType.IDENTITY)
	private int ID;
	@ManyToOne
	@Column
	private Account user;
	@ManyToOne
	@Column
	private LocationModel location;	
	@Column
	private String comment = "";
	@Column
	private Date time;
	
	public CommentModel(){
		
	}
	
	public CommentModel(Account user, String comment, LocationModel location)
	{
		this.user = user;
		this.comment = comment;
		this.location = location;
		time = new Date();
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getID() {
		return ID;
	}
	public Account getUser() {
		return user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public LocationModel getLocation() {
		return location;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setUser(Account user) {
		this.user = user;
	}

	public void setLocation(LocationModel location) {
		this.location = location;
	}
	
}
