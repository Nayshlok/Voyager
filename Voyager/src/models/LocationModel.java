package models;

import java.util.List;

public class LocationModel 
{
	private int ID;

	private int NumVisited;

	private String Name;

	private String Picture;

	private String Location;
	
	private List<String> attractions;
	
	private String History;
	
	public LocationModel(int ID, int NumVisited, String Name, String Picture, String Location, String History)
	{
		this.ID = ID;
		this.setNumVisited(NumVisited);
		this.setName(Name);
		this.setPicture(Picture);
		this.setLocation(Location);
		this.setHistory(History);
	}
	
	
	public long getID() {
		return ID;
	}


	public int getNumVisited() {
		return NumVisited;
	}
	public void setNumVisited(int numVisited) {
		NumVisited = numVisited;
	}


	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}


	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}


	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}


	public List<String> getAttractions() {
		return attractions;
	}
	public void setAttractions(List<String> attractions) {
		this.attractions = attractions;
	}


	public String getHistory() {
		return History;
	}
	public void setHistory(String history) {
		History = history;
	}
	
	
}
