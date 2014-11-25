package Controllers;

import javax.servlet.http.HttpServletRequest;

import services.DataService;

public class PostController {

	private HttpServletRequest request;
	private DataService dataService;
	
	public PostController(HttpServletRequest request, DataService dataService) {
		this.request = request;
		this.dataService = dataService;
	}
}
