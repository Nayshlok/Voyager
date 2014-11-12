package models;

public class RegisterUserModel {
	private Account user;
	private String errorMessage;
	public String getErrorMessage()
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	public Account getUser()
	{
		return user;
	}
	public void setUser(Account user)
	{
		this.user = user;
	}
}
