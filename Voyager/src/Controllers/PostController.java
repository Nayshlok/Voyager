package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import exceptions.UsernameAlreadyExistsException;
import models.Account;
import models.LocationModel;
import models.ModelAndView;
import models.RegisterUserModel;
import models.Roles;
import services.DataService;

public class PostController {

	private HttpServletRequest request;
	private DataService dataService;
	private String filePath;
	
	public PostController(HttpServletRequest request, DataService dataService, String filePath) {
		this.request = request;
		this.dataService = dataService;
		this.filePath = filePath;
	}
	
	public ModelAndView commitUserLogin() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegisterUserModel model = new RegisterUserModel();
		
		try {
			Account account = dataService.login(username, password);
			if(account != null) {
				System.out.println("Logged in");
				model.setUser(account);
				request.setAttribute("account", account);
				return new ModelAndView(model, request.getContextPath() + "voyager/profile", true);
			} else {
				model.setErrorMessage("Incorrect Login");
				
				return new ModelAndView(model, "/WEB-INF/account/login.jsp");
			}
		} catch(Exception e) {
			model.setErrorMessage("Incorrect Login");
			
			return new ModelAndView(model, "/WEB-INF/account/login.jsp");
		}

	}
	
	public ModelAndView commitUserRegisterUser() {
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
			dataService.registerUser(user);
			FileUploadController.processRequest(request, filePath);
			model.setUser(user);
			mv = new ModelAndView(model, "/WEB-INF/account/profile.jsp");
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
		
	public ModelAndView updateRole(){
		Roles role = Roles.valueOf(request.getParameter("role"));
		String username = request.getParameter("username");
		Account toUpdate = dataService.getUser(username);
		toUpdate.setRole(role);
		dataService.updateUser(toUpdate);
		return new ModelAndView(toUpdate, request.getContextPath() + "/register/users");
	}
	
	public ModelAndView deleteUser(){
		Account toRemove = dataService.getUser(request.getParameter("username"));
		dataService.removeUser(toRemove);
		return new ModelAndView(toRemove, request.getContextPath() + "/register/users");
	}
	
	public ModelAndView Search(){
		ModelAndView model;
		LocationModel loc= SearchController.DatabaseSearch(request.getParameter("search"), dataService);
		if(loc==null){
			model= new ModelAndView(loc, request.getContextPath()+ "idex");
		}
		model= new ModelAndView(loc, request.getContextPath()+"loc/"+loc.getID());
		return model;
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