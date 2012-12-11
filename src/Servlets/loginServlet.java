package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import domain.ContactGroup;

import util.HibernateUtil;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
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
		// TODO Auto-generated method stub
		String name = request.getParameter("name");

		if (name.equals(request.getParameter("password"))) {
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
			try {
				Session session = HibernateUtil.getSessionFactory()
						.openSession();
				org.hibernate.Transaction tx = session.beginTransaction();
				tx.begin();
				ContactGroup cg1=new ContactGroup();
				cg1.setGroupName("Family");
				session.save(cg1);
				ContactGroup cg2=new ContactGroup();
				cg2.setGroupName("Friends");
				session.save(cg2);
				ContactGroup cg3=new ContactGroup();
				cg3.setGroupName("Colleague");
				session.save(cg3);
				tx.commit();
				session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}
