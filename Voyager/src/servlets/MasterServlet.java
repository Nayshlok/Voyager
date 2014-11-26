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
import services.DataService;
import Controllers.GetController;
import Controllers.PostController;
import Controllers.RegisterController;

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
		GetController gc = new GetController(request, dataService);
		ModelAndView mav; 
		RequestDispatcher rd = null;
		
		if(request.getPathInfo().equals("/*") || request.getPathInfo().equals("/home")) {
			mav = gc.getHomePage();
			rd = request.getRequestDispatcher(mav.getViewName());
		} else if(request.getPathInfo().equals("/register")) {
			mav = gc.beginRegisterWorkflow();
			rd = request.getRequestDispatcher(mav.getViewName());
		} else if(request.getPathInfo().equals("/locations")) {
			mav = gc.getAllLocations();
			rd = request.getRequestDispatcher(mav.getViewName());
		} else if(request.getPathInfo().equals("/login")) {
			mav = gc.beginLoginWorkflow();
			rd = request.getRequestDispatcher(mav.getViewName());
		} else if(request.getPathInfo().equals("/new")) {
			mav = gc.beginLocationSubmissionWorkflow();
			rd = request.getRequestDispatcher(mav.getViewName());
		} 
		//Needs a pattern or something for this
		else if(request.getPathInfo().equals("/loc/1")) {
			//this needs to be changed for dynamic IDs 
			mav = gc.getSingleLocation(1l);
			rd = request.getRequestDispatcher(mav.getViewName());
		} else {
			rd = request.getRequestDispatcher("/WEB-INF/404.jsp");
		}
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostController pc = new PostController(request, dataService, this.getServletContext().getRealPath(File.separator));
		ModelAndView mv = null;
		if(request.getPathInfo().equals("/login")){
			mv = pc.commitUserLogin();
		} 
		else if(request.getPathInfo().equals("/register") || request.getPathInfo().equals("/update")){
			mv = pc.commitUserRegisterUser();
		}
		else if(request.getPathInfo().equals("/delete")){
			mv = pc.deleteUser();
		}
		else if(request.getPathInfo().equals("/updateRole")){
			mv = pc.updateRole();
		} 
		else if(request.getPathInfo().equals("/search")){
			mv = pc.Search();
		} 
		else {
			mv = new ModelAndView(null, "/WEB-INF/404.jsp");
		}
		
		if(mv.isRedirect()){
			response.sendRedirect(mv.getViewName());
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher(mv.getViewName());
			rd.forward(request, response);
		}
		
	}

}
