package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@NamedQueries({
	@NamedQuery(name="byLocationName", query="SELECT u FROM LocationModel u WHERE u.name = :locationName"),
	@NamedQuery(name="allLocations", query="SELECT u FROM LocationModel u"),
	@NamedQuery(name="byLocationAddress", query="SELECT u FROM LocationModel u WHERE u.name like :locationName or u.location like :location")
})

@Entity
@Table(name="LocationTable", uniqueConstraints=@UniqueConstraint(columnNames={"location"}))
public class LocationModel 
{
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private int numVisited;

	@Column
	private String name;

	@Column
	private String picture;

	@Column
	private String location;
	
	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy="location")
	private Set<AttractionModel> attractions;
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy="location")
	private Set<CommentModel> comments; 
	
	@Column
	private String history;
	
	public LocationModel(){
		comments = new HashSet<>();
		attractions = new HashSet();
	}
	
	public LocationModel(int NumVisited, String Name, String Picture, String Location, String History)
	{
		this.setNumVisited(NumVisited);
		this.setName(Name);
		this.setPicture(Picture);
		this.setLocation(Location);
		this.setHistory(History);
	}
	
	public int getNumVisited() {
		return numVisited;
	}
	public void setNumVisited(int numVisited) {
		this.numVisited = numVisited;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


	public Set<AttractionModel> getAttractions() {
		return attractions;
	}
	public void setAttractions(Set<AttractionModel> attractions) {
		this.attractions = attractions;
	}
	public void addAttraction(AttractionModel attraction){
		this.attractions.add(attraction);
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}
