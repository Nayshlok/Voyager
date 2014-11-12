package models;

public interface DataService {

	public Account login(String username, String password);

	public void registerUser(Account user);

	public void removeUser(Account user);

	public void updateUser(Account user);

	public int getUserId(String user);

	public String getUserName(int userId);

	public void enterPost(Post post);

	public Post retrievePost(String postTitle);

}