package Tester;

import services.DataService;
import services.DatabaseAccess;

public class ModelSideDriver {

	public static void main(String[] args) {
		DataService access = new DatabaseAccess();
		access.login("David", "Pass");
	}

}
