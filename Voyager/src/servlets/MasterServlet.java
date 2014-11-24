package servlets;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ModelAndView;
import Controllers.RegisterController;
import services.DataService;

/**
 * Servlet implementation class MasterServlet
 */
@WebServlet("/voyager/*")
@MultipartConfig(location="", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class MasterServlet extends HttpServlet {
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
		RequestDispatcher rd = null;
		
		if(request.getPathInfo().equals("/*") || request.getPathInfo().equals("/home")) {
			rd = request.getRequestDispatcher("/index.jsp");
		} else if(request.getPathInfo().equals("/register")) {
			rd = request.getRequestDispatcher("/WEB-INF/register.jsp");
		} else if(request.getPathInfo().equals("/locations")) {
			request.setAttribute("location", dataService.retrievePost("Test1"));
			rd = request.getRequestDispatcher("locations.jsp");
		} else if(request.getPathInfo().equals("/login")) {
			rd = request.getRequestDispatcher("/WEB-INF/account/login.jsp");
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/404.jsp");
		}
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = this.getServletContext().getRealPath(File.separator);
		RegisterController regControl = new RegisterController(request, response, dataService, this.getServletContext().getRealPath(File.separator));
		ModelAndView mv = regControl.commitUserRegisterUser();
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
