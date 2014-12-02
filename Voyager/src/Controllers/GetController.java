package Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import services.DataService;
import models.Account;
import models.LocationModel;
import models.ModelAndView;

public class GetController {
	
	private HttpServletRequest request;
	private DataService dataService;
	
	public GetController(HttpServletRequest request, DataService dataService) {
		this.request = request;
		this.dataService = dataService;
	}
	
	public ModelAndView getAllLocations() {
		List<LocationModel> allLocations = dataService.getAllLocations();
		request.setAttribute("location", allLocations);
		return new ModelAndView(allLocations, "/locations.jsp");
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
		return new ModelAndView(null, "/WEB-INF/register.jsp");
	}
	
	public ModelAndView getHomePage() {
		return new ModelAndView(null, "/index.jsp");
	}
	
	public ModelAndView getProfilePage() {
		return new ModelAndView(request.getSession().getAttribute("account"), "/profile.jsp");
	}
	
	public ModelAndView beginLocationSubmissionWorkflow() {
		return new ModelAndView(null, "/submit.jsp");
	}
	
    public ModelAndView getSingleLocation(int id) {
        LocationModel loc = dataService.getLocation(id);
        ModelAndView mav = null;
        if(loc != null) {
            request.setAttribute("location", loc);
            mav = new ModelAndView(loc, "/location.jsp");
        } else {
            mav = new ModelAndView(null, "/WEB-INF/404.jsp");
        }
        return mav;
    }
    
    public ModelAndView logout() {
    	request.getSession().invalidate();
    	return new ModelAndView(null, "/index.jsp");
    }

	
	public ModelAndView getCommentForm(){
		return new ModelAndView(null, "/WEB-INF/comment.jsp");
	}	
}
