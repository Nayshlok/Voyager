package servlets;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ModelAndView;
import models.RegisterUserModel;
import Controllers.GetController;
import Controllers.PostController;

/**
 * Servlet implementation class MasterServlet
 */
@WebServlet("/voyager/*")
@MultipartConfig(location="", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Pattern locPattern = Pattern.compile("\\/loc\\/(?<id>[0-9]+)$");
	private static Pattern accountPattern = Pattern.compile("\\/user\\/(?<user>[A-Za-z0-9]+)$");
	private static Pattern imagePattern = Pattern.compile("\\/image\\/(?<image>[A-Za-z0-9.]+)$");

	@Inject GetController gc;
	@Inject PostController pc;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mav = null; 
		RequestDispatcher rd = null;
		Matcher m = locPattern.matcher(request.getPathInfo());
		Matcher userMatch = accountPattern.matcher(request.getPathInfo());
		Matcher imageMatch = imagePattern.matcher(request.getPathInfo());
				
		if(request.getPathInfo().equals("/*") || request.getPathInfo().equals("/home")) {
			mav = gc.getHomePage();
		} else if(request.getPathInfo().equals("/register")) {
			mav = gc.beginRegisterWorkflow();
		} else if(request.getPathInfo().equals("/update")){
			mav = gc.beginUpdateFlow(request);
		} else if(request.getPathInfo().equals("/locations")) {
			mav = gc.getAllLocations(request);
		} else if(request.getPathInfo().equals("/login")) {
			mav = gc.beginLoginWorkflow();
		} else if(request.getPathInfo().equals("/new")) {
			mav = gc.beginLocationSubmissionWorkflow(request);
		} else if(request.getPathInfo().equals("/comment")){
			mav = gc.getCommentForm(request);
		} else if(request.getPathInfo().equals("/search")){
			mav = gc.search(request);
		} else if(request.getPathInfo().equals("/users")) {
			mav = gc.getUserList(request);
		} else if(userMatch.find()){
			mav = gc.getProfilePage(request, userMatch.group("user"));
		} else if(imageMatch.find()){
			mav = gc.getImage(imageMatch.group("image"));
		} else if(m.find()) {
			mav = gc.getSingleLocation(request, Integer.parseInt(m.group("id")));
		} else if(request.getPathInfo().equals("/logout")) {
			mav = gc.logout(request);
		} else if(imageMatch.find()){ 
			
		}
		else {
			mav = new ModelAndView(null, "/WEB-INF/404.jsp");
		}
		rd = request.getRequestDispatcher(mav.getViewName());
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelAndView mv = null;
		String filePath = this.getServletContext().getRealPath(File.separator);
		if(request.getPathInfo().equals("/login")){
			mv = pc.commitUserLogin(request);
			request.setAttribute("errorMessage", ((RegisterUserModel)mv.getModel()).getErrorMessage());
		} else if(request.getPathInfo().equals("/register")){
			mv = pc.commitUserRegisterUser(request, true, filePath);
		} else if(request.getPathInfo().equals("/update")){ 
			mv = pc.commitUserRegisterUser(request, false, filePath);
		} else if(request.getPathInfo().equals("/delete")){
			mv = pc.deleteUser(request);
		} else if(request.getPathInfo().equals("/updateRole")){
			mv = pc.updateRole(request);
		} else if(request.getPathInfo().equals("/comment")){
			mv = pc.postComment(request);
		} else if(request.getPathInfo().equals("/new")) {
			mv = pc.commitNewLocation(request, filePath);
		} else {
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
