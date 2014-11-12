package Tester;

import models.Account;
import models.DatabaseAccess;
import models.Roles;

import org.junit.Test;

public class DatabaseTest {
	private DatabaseAccess db = new DatabaseAccess();
	@Test
	public void testLogin() {
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
