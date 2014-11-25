package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.Comments;
import services.DataService;
import services.DatabaseAccess;
import models.CommentModel;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/locations/*")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DataService da = new DatabaseAccess();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Comments list = new Comments();
		/*list.AddComment(new CommentModel(15, "New Guy", "This is a test comment, for testing purposes"));
		list.AddComment(new CommentModel(10, "Old Dude", "Radical!"));
		list.AddComment(new CommentModel(1, "SuperCool", "Semi long comment, for test"));
		*/
		RequestDispatcher rd = request.getRequestDispatcher("/locations.jsp");
		
		request.setAttribute("comments", list.getCommentsList());
		request.setAttribute("location", da.retrieveLocation("Test1"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
