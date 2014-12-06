package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import exceptions.UsernameAlreadyExistsException;
import models.Account;
import models.CommentModel;
import models.LocationModel;
import models.ModelAndView;
import models.RegisterUserModel;
import models.Roles;
import services.DataService;

@Stateless
@LocalBean
public class PostController {

	@Inject DataService dataService;
	
	public ModelAndView commitUserLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegisterUserModel model = new RegisterUserModel();
		
		try {
			Account account = dataService.login(username, password);
			if(account != null) {
				System.out.println("Logged in");
				model.setUser(account);
				request.getSession().setAttribute("account", account);
				return new ModelAndView(model, request.getContextPath() + "/voyager/user/" + account.getUsername(), true);
			} else {
				model.setErrorMessage("Incorrect Login");
				return new ModelAndView(model, "/WEB-INF/account/login.jsp");
			}
		} catch(Exception e) {
			model.setErrorMessage("Incorrect Login");
			e.printStackTrace();
			return new ModelAndView(model, "/WEB-INF/account/login.jsp");
		}

	}

	public ModelAndView commitUserRegisterUser(HttpServletRequest request, boolean newUser, String filePath) {
		String username = "";
		String password = "";
		String confirmPassword = "";
		String email = "";
		String confirmEmail = "";
		String avatarPath = "";
		try{
			username = this.getValue(request.getPart("username"));
			password = this.getValue(request.getPart("password"));
			confirmPassword = this.getValue(request.getPart("confirmPassword"));
			email = this.getValue(request.getPart("email"));
			confirmEmail = this.getValue(request.getPart("confirmEmail"));
			avatarPath = FileUploadController.getFileName(request.getPart("image"));
		} catch (ServletException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		RegisterUserModel model = new RegisterUserModel();
		ModelAndView mv = null;
		
		if(!password.equals(confirmPassword)) {
			request.setAttribute("attemptedAccount", new Account(username, email, avatarPath, Roles.User, password));
			mv = new ModelAndView("Passwords did not match", "/WEB-INF/register.jsp");
		}
		if(!email.equals(confirmEmail)){
			request.setAttribute("attemptedAccount", new Account(username, email, avatarPath, Roles.User, password));
			mv = new ModelAndView("Emails did not match. ", "/WEB-INF/register.jsp");
		}
		try {
			Account user = new Account(username, email, avatarPath, Roles.User, password);
			if(newUser){
				dataService.registerUser(user);
				FileUploadController.processRequest(request, filePath);
				request.getSession().setAttribute("account", dataService.getUser(user.getUsername()));
			}
			else{
				user.setUserId(dataService.getUserId(user.getUsername()));
				dataService.updateUser(user);
			}
			model.setUser(user);
			mv = new ModelAndView(model, "/voyager/user/" + user.getUsername());
		} catch(UsernameAlreadyExistsException e) {
			request.setAttribute("attemptedAccount", new Account(username, email, avatarPath, Roles.User, password));
			mv = new ModelAndView("Username has already been used.", "/WEB-INF/register.jsp");
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mv;
	}
		
    public ModelAndView commitNewLocation(HttpServletRequest request, String filePath) {
		ModelAndView mv = null;
		if(request.getSession().getAttribute("account") == null){
			mv = new ModelAndView(null, "/WEB-INF/Unauthorized.jsp");
		}
		else{
	        String placeName = "";
	        String locationString = "";
	        String history = "";
	        String imgPath = "";
	        
	        try{
	            placeName = this.getValue(request.getPart("placeName"));
	            locationString = this.getValue(request.getPart("location"));
	            history = this.getValue(request.getPart("history"));
	            imgPath = FileUploadController.getFileName(request.getPart("image"));
	        } catch (ServletException e1) {
	            e1.printStackTrace();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	        LocationModel location = null;
	        try {
	            location = new LocationModel(0, placeName, imgPath, locationString, history);
	            location = dataService.addLocation(location);
	            FileUploadController.processRequest(request, filePath);
	        } catch (ServletException e1) {
	            e1.printStackTrace();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	        mv = new ModelAndView(location, request.getContextPath() + "voyager/loc/" + location.getId(), true);
		}
        return mv;
    }

	public ModelAndView updateRole(HttpServletRequest request){
		Roles role = Roles.valueOf(request.getParameter("role"));
		String username = request.getParameter("username");
		Account toUpdate = dataService.getUser(username);
		toUpdate.setRole(role);
		dataService.updateUser(toUpdate);
		return new ModelAndView(toUpdate, request.getContextPath() + "/register/users");
	}
	
	public ModelAndView deleteUser(HttpServletRequest request){
		Account toRemove = dataService.getUser(request.getParameter("username"));
		dataService.removeUser(toRemove);
		return new ModelAndView(toRemove, request.getContextPath() + "/register/users");
	}
	
	public ModelAndView postComment(HttpServletRequest request){
		try{
			LocationModel location = dataService.getLocation(Integer.parseInt(request.getParameter("locationId")));
			Account user = (Account)request.getSession().getAttribute("account");
			String commentString = request.getParameter("comment");
			CommentModel comment = new CommentModel(user, commentString, location);
			location.addComment(comment);
			user.addComment(comment);
			dataService.saveComment(comment);
			return new ModelAndView(comment, request.getContextPath() + "/voyager/loc/" + location.getId(), true);
		} catch(NullPointerException ex){
			return new ModelAndView(null, "/WEB-INF/Unauthorized.jsp");
		}
	}
	
	
	
	private String getValue(Part part) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
	    StringBuilder value = new StringBuilder();
	    char[] buffer = new char[1024];
	    for (int length = 0; (length = reader.read(buffer)) > 0;) {
	        value.append(buffer, 0, length);
	    }
	    return value.toString();
	}
}
