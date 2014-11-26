package Tester;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;

import models.AttractionModel;
import models.LocationModel;
import services.EntityManagerDataService;

public class LocationTest {

	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("voyagerUnit");
		EntityManagerDataService emds = new EntityManagerDataService();
		EntityManager em = emf.createEntityManager();
		emds.em = em;
		
		LocationModel location = new LocationModel(34, "The Secret Garden", "", "Something", "A brief history");
		AttractionModel attraction1 = new AttractionModel("Crystal Rose", "stuff needs to go here.");
		AttractionModel attraction2 = new AttractionModel("Secret Bush", "stuff needs to go here.");
		AttractionModel attraction3 = new AttractionModel("Somthing else", "stuff needs to go here.");
		Set<AttractionModel> attractions = new HashSet<>();
		attractions.add(attraction1);
		attractions.add(attraction2);
		attractions.add(attraction3);
		location.setAttractions(attractions);
		
		em.getTransaction().begin();
		em.persist(location);
		em.getTransaction().commit();
	}
}
