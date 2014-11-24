package Controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import services.DataService;
import models.Account;
import models.ModelAndView;
import models.RegisterUserModel;

public class LoginController {
	private DataService dataService;
	private HttpServletRequest request;

	public LoginController(HttpServletRequest request, DataService dataService) {
		this.request = request;
		this.dataService = dataService;
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
				return new ModelAndView(model, "/WEB-INF/account/profile.jsp");
			} else {
				model.setErrorMessage("Incorrect Login");
				
				return new ModelAndView(model, "/WEB-INF/account/login.jsp");
			}
		} catch(Exception e) {
			model.setErrorMessage("Incorrect Login");
			
			return new ModelAndView(model, "/WEB-INF/account/login.jsp");
		}

	}
}
