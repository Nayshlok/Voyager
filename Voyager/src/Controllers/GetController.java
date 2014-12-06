package Controllers;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import models.Account;
import models.LocationModel;
import models.ModelAndView;
import models.Roles;
import services.DataService;

@Stateless
@LocalBean
public class GetController {
	
	@Inject DataService dataService;
	
	public ModelAndView getAllLocations(HttpServletRequest request) {
		List<LocationModel> allLocations = dataService.getAllLocations();
		request.setAttribute("location", allLocations);
		return new ModelAndView(allLocations, "/locations.jsp");
	}
	
	public ModelAndView getUserList(HttpServletRequest request){
		ModelAndView mv = new ModelAndView(null, "/WEB-INF/Unauthorized.jsp");
		if(request.getSession().getAttribute("account") != null){
			if(((Account)request.getSession().getAttribute("account")).getRole() == Roles.Admin){
				List<Account> allUsers = dataService.getAllUsers();
				request.setAttribute("userList", allUsers);
				mv = new ModelAndView(allUsers, "/WEB-INF/Users.jsp");
			}
		}
		return mv;
	}
	
	public ModelAndView beginLoginWorkflow() {
		return new ModelAndView(null, "/WEB-INF/account/login.jsp");
	}
	
	public ModelAndView beginRegisterWorkflow() {
		return new ModelAndView(null, "/WEB-INF/register.jsp");
	}
	
	public ModelAndView beginUpdateFlow(HttpServletRequest request){
		ModelAndView mv = null;
		if(request.getSession().getAttribute("account") == null){
			mv = new ModelAndView(null, "/WEB-INF/Unauthorized.jsp");
		}
		else{
			mv = new ModelAndView(null, "/update.jsp");
		}
		return mv;
	}
	
	public ModelAndView getHomePage() {
		return new ModelAndView(null, "/index.jsp");
	}
	
	public ModelAndView getProfilePage(HttpServletRequest request, String username) {
		Account account = dataService.getUser(username);
		request.setAttribute("profileAccount", account);
		return new ModelAndView(account, "/profile.jsp");
	}
	
	public ModelAndView beginLocationSubmissionWorkflow(HttpServletRequest request) {
		ModelAndView mv = null;
		if(request.getSession().getAttribute("account") == null){
			mv = new ModelAndView(null, "/WEB-INF/Unauthorized.jsp");
		}
		else{
			mv = new ModelAndView(null, "/submit.jsp");
		}
		return mv;
	}
	
    public ModelAndView getSingleLocation(HttpServletRequest request, int id) {
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
    
    public ModelAndView logout(HttpServletRequest request) {
    	request.getSession().invalidate();
    	return new ModelAndView(null, "/index.jsp");
    }
    
    public ModelAndView search(HttpServletRequest request){
        ModelAndView model;
        List<LocationModel> loc = SearchController.databaseSearch(request.getParameter("search"), dataService);
        if(loc == null){
            model = new ModelAndView(null, "/WEB-INF/404.jsp");
        }
		request.setAttribute("location", loc);

        model = new ModelAndView(loc, "/locations.jsp");
        return model;
    }
	
	public ModelAndView getCommentForm(HttpServletRequest request){
		ModelAndView mv = null;
		if(request.getSession().getAttribute("account") == null){
			mv = new ModelAndView(null, "/WEB-INF/Unauthorized.jsp");
		}
		else{
			request.setAttribute("locaitonId", request.getParameter("locationId"));
			mv = new ModelAndView(null, "/WEB-INF/comment.jsp");
		}
		return mv;
	}
	
	public ModelAndView getImage(String imagePath){
		ModelAndView mv = null;
		mv = new ModelAndView(null, "/resources/images/" + imagePath);
		return mv;
	}
}
