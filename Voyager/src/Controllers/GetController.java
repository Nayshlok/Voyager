package Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import services.DataService;
import models.Account;
import models.ModelAndView;

public class GetController {
	
	private HttpServletRequest request;
	private DataService dataService;
	
	public GetController(HttpServletRequest request, DataService dataService) {
		this.request = request;
		this.dataService = dataService;
	}
	
	public ModelAndView getAllLocations() {
		/*
		 * "location" model needs to be set to the list of locations from JPA 
		 */
		request.setAttribute("location", null);
		return new ModelAndView(null, "locations.jsp");
	}
	
	public ModelAndView getUserList(){
		List<Account> allUsers = dataService.getAllUsers();
		request.setAttribute("userList", allUsers);
		return new ModelAndView(allUsers, "/WEB-INF/Users.jsp");
	}
	
	public ModelAndView beginLoginWorkflow() {
		return new ModelAndView(null, "/WEB-INF/account/login.jsp");
	}
	
	public ModelAndView beginRegisterWorkflow() {
		return new ModelAndView(null, "/WEB-INF/account/register.jsp");
	}
	
	public ModelAndView getHomePage() {
		return new ModelAndView(null, "index.jsp");
	}
	
	public ModelAndView getProfilePage() {
		return null;
	}
	
	public ModelAndView beginLocationSubmissionWorkflow() {
		return new ModelAndView(null, "submit.jsp");
	}
	
	public ModelAndView getSingleLocation(Long id) {
		request.setAttribute("location", dataService.retrievePost("Test1"));
		return null;
	}
}
