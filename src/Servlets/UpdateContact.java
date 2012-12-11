package Servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Address;
import domain.Contact;
import domain.ContactGroup;
import domain.DAOContact;
import domain.DAOContactGroup;
import domain.PhoneNumber;

/**
 * Servlet implementation class UpdateContact
 */
public class UpdateContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateContact() {
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
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		Contact contact = dao.getContact(firstname, lastname);

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String Street = request.getParameter("Street");
		String City = request.getParameter("City");
		String zip = request.getParameter("zip");
		String Country = request.getParameter("Country");
		// String group = request.getParameter("group");
		String[] group = request.getParameterValues("group");

		Contact c = new Contact();
		c.setFirstName(firstName);
		c.setLastName(lastName);
		c.setEmail(email);
		Address adr = new Address();
		adr.setCity(City);
		adr.setCountry(Country);
		adr.setStreet(Street);
		adr.setZip(zip);

		Set<ContactGroup> cgroup = new HashSet<ContactGroup>();
		DAOContactGroup groupe = new DAOContactGroup();
		
		for (int i = 0; i < group.length; i++) {
			ContactGroup cg = groupe.getContactGroup(group[i]);
		//	cg.setGroupName(group[i]);
			cgroup.add(cg);
		}
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

		if (dao.modifyContact(contact.getId(), c, adr, phones, cgroup) == null) {
			response.getWriter().println("contact non modifié");

		} else {
			response.sendRedirect("Menu.jsp");

		}
		;

	}

}
