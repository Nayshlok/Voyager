package models;


import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login/*")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataService dataService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		dataService = (DataService) this.getServletContext().getAttribute("data");
	}
	//private static final UserService us = new HashMapUserService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = "/WEB-INF/account/login.jsp";
		if(request.getRequestURI().contains("testView")){
			target = "/WEB-INF/SessionTester.jsp";
		}
		else if(request.getRequestURI().contains("profile")){
			target = "/WEB-INF/account/profile.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginController control = new LoginController(request, response, dataService);
		ModelAndView mv = control.login();
		RequestDispatcher rd = request.getRequestDispatcher(mv.getViewName());
		rd.forward(request, response);
	}

}
