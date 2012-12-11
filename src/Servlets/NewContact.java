package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.*;

/**
 * Servlet implementation class NewContact
 */
public class NewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewContact() {
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
		DAOContact dao = new DAOContact();
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String Street = request.getParameter("Street");
		String City = request.getParameter("City");
		String zip = request.getParameter("zip");
		String Country = request.getParameter("Country");
		String[] group = request.getParameterValues("group");
		Contact c = new Contact();
		c.setFirstName(firstname);
		c.setLastName(lastname);
		c.setEmail(email);
		Address adr = new Address();
		adr.setCity(City);
		adr.setCountry(Country);
		adr.setStreet(Street);
		adr.setZip(zip);

		DAOContactGroup groupe = new DAOContactGroup();
		Set<ContactGroup> cgroup = new HashSet<ContactGroup>();
		ContactGroup groupeContact = null;
		for (int i = 0; i < group.length; i++) {
			groupeContact = groupe.getContactGroup(group[i]);
			cgroup.add(groupeContact);
		}
		
		/*
		 * ContactGroup cg =new ContactGroup(); cg.setGroupName(group);
		 */

		System.out.println(cgroup.size());

		Set<PhoneNumber> phones = new HashSet<PhoneNumber>();

		// Ajout du premier tel
		String phonem = request.getParameter("mobile");
		String phonemKind = request.getParameter("mobilekind");
		PhoneNumber phoneNumberm = new PhoneNumber();
		phoneNumberm.setPhoneNumber(phonem);
		phoneNumberm.setPhoneKind(phonemKind);
		phones.add(phoneNumberm);

		// Ajout du second tel
		String phoneh = request.getParameter("home");
		String phonehKind = request.getParameter("homekind");
		PhoneNumber phoneNumberh = new PhoneNumber();
		phoneNumberh.setPhoneNumber(phoneh);
		phoneNumberh.setPhoneKind(phonehKind);

		phones.add(phoneNumberh);

		// Ajout du troisieme tel
		String phoneo = request.getParameter("office");
		String phoneoKind = request.getParameter("officekind");
		PhoneNumber phoneNumbero = new PhoneNumber();
		phoneNumbero.setPhoneNumber(phoneo);
		phoneNumbero.setPhoneKind(phoneoKind);
		phones.add(phoneNumbero);

		dao.addContact(c, adr, phones, cgroup);
		response.sendRedirect("Menu.jsp");
	}
}
