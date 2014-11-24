package servlets;


import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.DataService;
import services.EntityManagerDataService;
import models.Account;
import models.ModelAndView;
import models.Roles;
import Controllers.RegisterController;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register/*")
@MultipartConfig(location="", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataService dataService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		dataService = (DataService) this.getServletContext().getAttribute("data");
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterController regControl = new RegisterController(request, response, dataService, "");
		if(request.getRequestURI().contains("users")){
			if(((Account)request.getSession().getAttribute("account")) != null && ((Account)request.getSession().getAttribute("account")).getRole() == Roles.Admin){
				ModelAndView mv = regControl.getUserList();
				RequestDispatcher rd = request.getRequestDispatcher(mv.getViewName());
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Unauthorized.jsp");
				rd.forward(request, response);
			}
		}
		else{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/register.jsp");
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterController regControl = new RegisterController(request, response, dataService, this.getServletContext().getRealPath(File.separator));
		ModelAndView mv;
		if(request.getRequestURI().contains("delete")){
			mv = regControl.deleteUser();
			response.sendRedirect(mv.getViewName());
		}
		else if(request.getRequestURI().contains("update")){
			mv = regControl.updateRole();
			response.sendRedirect(mv.getViewName());
		}
		else{
			mv = regControl.commitUserRegisterUser();
			if(mv.getModel() != null){
				request.setAttribute("errorMessage", mv.getModel());
				RequestDispatcher rd = request.getRequestDispatcher(mv.getViewName());
				rd.forward(request, response);
			}
			else{
				response.sendRedirect(mv.getViewName());
			}
		}
	}
}