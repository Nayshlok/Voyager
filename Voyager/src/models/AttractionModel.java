package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AttractionTable")
public class AttractionModel {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@Column(name="LOCATION_ID")
	private LocationModel location;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	public AttractionModel(){
		
	}
	
	public AttractionModel(String name, String desc){
		this.name = name;
		this.description = desc;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	
}
