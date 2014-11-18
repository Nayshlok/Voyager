package models;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PublicProfileServlet
 */
@WebServlet("/PublicProfileServlet")
public class PublicProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DatabaseAccess db= new DatabaseAccess();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Username",db.getUserName(10));		request.setAttribute("comment","random comment");
		RequestDispatcher view = request.getRequestDispatcher("/publicProfile.jsp");
	        view.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
