package models;

public class ModelSideDriver {

	public static void main(String[] args) {
		DataService access = new DatabaseAccess();
		access.login("David", "Pass");
	}

}
