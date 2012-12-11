package Servlets;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.DAOContact;

/**
 * Servlet implementation class FindContact
 */
public class FindContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		DAOContact dao = new DAOContact();
		boolean found = false;
		ArrayList<domain.Contact> cres = null;
		//System.out.println(request.getParameter("firstname"));
		if (!request.getParameter("firstname").equals("")) {
			cres=dao.getContactByFirstName(request.getParameter("firstname"));
			found = true;
			System.out.println(" firstname");
		}
		if (!request.getParameter("lastname").equals("")) {
			cres=dao.getContactByLastName(request.getParameter("lastname"));
			found = true;
		}
		if (!request.getParameter("email").equals("")) {
			cres=dao.getContactByEmail(request.getParameter("email"));
			found = true;
		}
		
		if (!found)
			response.sendRedirect("index.html");
		else
			for(int i=0;i< cres.size();i++)
			response.getWriter().println(cres.get(i).getFirstName()+" " +cres.get(i).getLastName() +"\n");
	}

}
