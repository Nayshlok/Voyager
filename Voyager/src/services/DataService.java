package services;

import java.util.List;

import models.Account;
import models.LocationModel;
import models.Post;

public interface DataService {

	public Account login(String username, String password);
	
	public Account getUser(String username);

	public void registerUser(Account user);

	public void removeUser(Account user);

	public void updateUser(Account user);

	public int getUserId(String user);

	public String getUsername(int userId);

	public void addLocation(LocationModel location);
	
	public LocationModel getLocation(int id);
	
	public List<LocationModel> getAllLocations();
	
	public List<LocationModel> getLocations(String name);
	
	public LocationModel retrieveLocation(String location);
	
	public List<Account> getAllUsers();
}