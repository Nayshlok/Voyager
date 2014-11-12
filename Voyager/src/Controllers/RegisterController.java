package Controllers;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.UsernameAlreadyExistsException;
import models.Account;
import models.DataService;
import models.ModelAndView;
import models.RegisterUserModel;
import models.Roles;


public class RegisterController {
	
	private DataService dataService;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String filePath;
	
	public RegisterController(HttpServletRequest request, HttpServletResponse response, DataService dataService, String FilePath) {
		this.request = request;
		this.response = response;
		this.dataService = dataService;
	}
	
	public ModelAndView commitUserRegisterUser() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String email = request.getParameter("email");
		String confirmEmail = request.getParameter("confirmEmail");
		String avatarPath = null;
		try {
			avatarPath = FileUploadController.processRequest(request, response, filePath);
		} catch (ServletException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		RegisterUserModel model = new RegisterUserModel();
		ModelAndView mv = null;
		
		if(!password.equals(confirmPassword)) {
			model.setErrorMessage("Bad username/password. ");
			mv = new ModelAndView(model, "/WEB-INF/register.jsp");
		}
		if(!email.equals(confirmEmail)){
			model.setErrorMessage(model.getErrorMessage() + "Emails did not match. ");
			mv = new ModelAndView(model, "/WEB-INF/register.jsp");
		}
		try {
			Account user = new Account(username, email, avatarPath, Roles.User, password);
			dataService.registerUser(user);
			model.setUser(user);
			mv = new ModelAndView(model, "/WEB-INF/account/profile.jsp");
		} catch(UsernameAlreadyExistsException e) {
			model.setErrorMessage("Username has already been used.");
			
			mv = new ModelAndView(model, "/WEB-INF/account/register.jsp");
		}
		
		return mv;
	}
}
