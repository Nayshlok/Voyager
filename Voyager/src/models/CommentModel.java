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
	@Column
	private String comment = "";
	@Column
	private Date time;
	
	public CommentModel(int ID, Account user, String comment)
	{
		this.ID = ID;
		this.user = user;
		this.comment = comment;
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
	
}
