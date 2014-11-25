package Tester;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Account;
import models.Roles;

import org.junit.Before;
import org.junit.Test;

import services.DatabaseAccess;
import services.EntityManagerDataService;

public class DatabaseTest {
	private EntityManagerDataService db = new EntityManagerDataService();
	
	public DatabaseTest(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("voyagerUnit");
		db.em = emf.createEntityManager();
	}
	
	@Test
	public void testLogin() {
		db.em.getTransaction();
		 Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		db.registerUser(user);
		db.login(user.getUsername(), user.getPassword());
	}

	@Test
	public void testRegisterUser() {
		 Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		db.registerUser(user);
	}

	@Test
	public void testRemoveUser() {
		 Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		db.registerUser(user);
		db.removeUser(user);
	}

	@Test
	public void testUpdateUser() {
		 Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		db.registerUser(user);
		db.updateUser(user);
	}

}
