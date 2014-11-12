package Tester;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import models.Account;
import models.DataService;
import models.DatabaseAccess;
import models.Post;
import models.Roles;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;


public class Tester {

	private static DataService access = new DatabaseAccess();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		access = new DatabaseAccess();
		//registerTest();
		//loginTest();
		//updateTest();
		//removeUser();
		//registerTest();
		//postTest();
		postRead();
	}
	
	public static void registerTest(){
		Account testing = new Account("Billy", "Bob@gmail.com", "", Roles.Admin, "SuperSecret");
		access.registerUser(testing);
	}
	
	public static void loginTest(){
		Account failLogin = access.login("Billy", "Password");
		System.out.println(failLogin);
		Account loggedIn = access.login("Billy", "SuperSecret");
		System.out.println(loggedIn.getUsername());
	}
	
	public static void updateTest(){
		Account toUpdate = new Account("Billy", "Billy@gmail.com", "", Roles.User, "SuperSecret");
		access.updateUser(toUpdate);
	}
	
	public static void removeUser(){
		Account user = new Account("Billy", "Billy@gmail.com", "", Roles.User, "SuperSecret");
		access.removeUser(user);
	}
	
	public static void postTest(){
		Post testPost = new Post("Test1", "Lots of information to have", "Billy");
		access.enterPost(testPost);
	}
	
	public static void postRead(){
		Post testRead = access.retrievePost("Test1");
		System.out.println(testRead.getTitle());
		System.out.println(testRead.getAuthor());
		System.out.println(testRead.getMessage());
	}

}