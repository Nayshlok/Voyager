package models;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.BadLoginException;

public class LoginController {
	private DataService dataService;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public LoginController(HttpServletRequest request, HttpServletResponse response,DataService ds) {
		dataService = ds;
		this.request = request;
		this.response = response;
	}

	public ModelAndView login() {		
		try {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			Account model = dataService.login(userName, password);
			request.getSession().setAttribute("currentUser", model);
			return new ModelAndView(model, "/WEB-INF/account/profile.jsp");
		} catch(BadLoginException e) {			
			request.setAttribute("errorMessage", e.getMessage());
			return new ModelAndView(e.getMessage(), "/WEB-INF/account/login.jsp");
		}

	}
}
