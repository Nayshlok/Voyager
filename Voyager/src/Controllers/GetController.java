package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import services.DataService;
import models.Account;
import models.ModelAndView;

public class GetController {
	
	public ModelAndView getUserList(HttpServletRequest request, DataService dataService){
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
	
	public ModelAndView getSingleLocation() {
		return null;
	}
}
