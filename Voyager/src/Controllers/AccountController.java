package Controllers;

import models.Account;
import models.DatabaseAccess;
import models.Roles;

public class AccountController {
	   private Account model;

	   private DatabaseAccess db = new DatabaseAccess(); 
	   
	  
	   
	   public void updateUser(Account user, String password, String email, Roles role){
		   user.setPassword(password);
		   user.setEmail(email);
		   user.setRole(role); 
		   db.updateUser(user);
	   }
	   
	   public Account login(String username, String password){
		   model= db.login(username, password);
		   
		   return model;
	   }
	   
	   public void registerUser(Account user){
		   user.setRole(Roles.User);
		   db.registerUser(user);
		   
	   }
	   
	  
	   public void removeUser(Account user){
		   db.removeUser(user);
		  
	   }
	   
	   
	   
}




























