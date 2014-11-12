package Tester;

import models.Account;
import models.Roles;

import org.junit.Test;

import Controllers.AccountController;

public class AccountControllerTest {
	private AccountController ac = new AccountController();
	
	
	@Test
	public void testUpdateUser() {
		Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		ac.registerUser(user);
		ac.updateUser(user, "idontknow", "StEvE@gmial.com", Roles.Admin);
		ac.removeUser(user);

	}

	@Test
	public void testLogin() {
		Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		ac.registerUser(user);
		ac.login("steve", "password");
		ac.removeUser(user);

	}

	@Test
	public void testRegisterUser() {
		Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		ac.registerUser(user);
		ac.removeUser(user);

	}

	@Test
	public void testRemoveUser() {
		Account user= new Account("steve", "steve@aol.com", "null", Roles.User, "password");
		ac.registerUser(user);
		ac.removeUser(user);
	}

}
