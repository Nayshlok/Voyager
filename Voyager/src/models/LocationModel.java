package models;

import java.util.List;

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
	@NamedQuery(name="allLocation", query="SELECT u FROM LocationModel u"),
	@NamedQuery(name="byLocationAddress", query="SELECT u FROM LocationModel u WHERE u.location = :Location")
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
	
	@Column
	@OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy="location")
	private List<AttractionModel> attractions;
	
	@Column
	private String history;
	
	public LocationModel(int ID, int NumVisited, String Name, String Picture, String Location, String History)
	{
		this.id = ID;
		this.setNumVisited(NumVisited);
		this.setName(Name);
		this.setPicture(Picture);
		this.setLocation(Location);
		this.setHistory(History);
	}
	
	
	public long getID() {
		return id;
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


	public List<AttractionModel> getAttractions() {
		return attractions;
	}
	public void setAttractions(List<AttractionModel> attractions) {
		this.attractions = attractions;
	}


	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	
	
}
