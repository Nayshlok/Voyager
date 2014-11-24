package services;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import exceptions.BadLoginException;
import models.Account;
import models.Post;

public class EntityManagerDataService implements DataService{

	@PersistenceContext(name="voyagerUnit")
	public EntityManager em;
	
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
	public void enterPost(Post post) {
		System.out.println("Not implemented");
	}

	@Override
	public Post retrievePost(String postTitle) {
		// TODO Auto-generated method stub
		return null;
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

	
}