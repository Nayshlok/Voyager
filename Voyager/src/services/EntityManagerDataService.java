package services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Account;
import models.CommentModel;
import models.LocationModel;
import exceptions.BadLoginException;

@Stateless
@LocalBean
@Local(DataService.class)
public class EntityManagerDataService implements DataService{

	@PersistenceContext(name="voyagerUnit")
	EntityManager em;
	
	@Override
	public Account login(String username, String password) {
		TypedQuery<Account> query = em.createNamedQuery("byUsername", Account.class);
		query.setParameter("username", username);

		Account user = query.getSingleResult();
		
		if ( user.getPassword().equals(password) ) {
			return user;
		}
		
		throw new BadLoginException("Bad username or password!");
	}

	@Override
	public void registerUser(Account user) {
		TypedQuery<Account> query = em.createNamedQuery("byUsername", Account.class);
		query.setParameter("username", user.getUsername());
		
		if ( !query.getResultList().isEmpty() ) {
			throw new IllegalArgumentException("Username already exists");
		}
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	@Override
	public void removeUser(Account user) {
		
		em.getTransaction().begin();
		Account toRemove = em.find(Account.class, user.getUserID());
		em.remove(toRemove);
		em.getTransaction().commit();
	}

	@Override
	public void updateUser(Account user) {
		em.getTransaction().begin();
		em.merge(user);		
		em.getTransaction().commit();
	}

	@Override
	public int getUserId(String user) {
		int id = -1;
		TypedQuery<Account> query = em.createNamedQuery("byUsername", Account.class);
		query.setParameter("username", user);
		try{
			Account found = query.getSingleResult();
			id = found.getUserID();
		} catch(NoResultException ex){
			//ignore and leave id -1
		}
		return id;
	}

	@Override
	public String getUsername(int userId) {
		return em.find(Account.class, userId).getUsername();
	}

	@Override
	public List<Account> getAllUsers() {
		TypedQuery<Account> query = em.createNamedQuery("allUsers", Account.class);
		return query.getResultList();
	}

	@Override
	public Account getUser(String username) {
		return em.find(Account.class, getUserId(username));
	}

	@Override
	public LocationModel addLocation(LocationModel location) {
		LocationModel persistedLocation = null;
		em.getTransaction().begin();
		try{
			em.persist(location);
			TypedQuery<LocationModel> typeQuery = em.createNamedQuery("byLocationName", LocationModel.class);
			typeQuery.setParameter("locationName", location.getName());
			persistedLocation = typeQuery.getSingleResult();
		}
		catch(Exception e){
			em.getTransaction().rollback();
			throw e;
		}
		em.getTransaction().commit();
		
		return persistedLocation;
	}

	@Override
	public LocationModel getLocation(int id) {
		return em.find(LocationModel.class, id);
	}

	@Override
	public List<LocationModel> getAllLocations() {
		TypedQuery<LocationModel> locationSearch = em.createNamedQuery("allLocations", LocationModel.class);
		return locationSearch.getResultList();
	}

	@Override
	public List<LocationModel> getLocations(String name) {
		TypedQuery<LocationModel> locationSearch = em.createNamedQuery("byLocationName", LocationModel.class);
		locationSearch.setParameter("locationName", "%"+name+"%");
		locationSearch.setParameter("location", "%"+name+"%");
		return locationSearch.getResultList();
	}

	@Override
	public LocationModel retrieveLocation(String location) {
		TypedQuery<LocationModel> locationSearch = em.createNamedQuery("byLocationAddress", LocationModel.class);
		locationSearch.setParameter("location", "%"+location+"%");
		return locationSearch.getSingleResult();
	}

	@Override
	public void saveComment(CommentModel comment) {
		em.getTransaction().begin();
		em.persist(comment);
		em.getTransaction().commit();
	}
}
